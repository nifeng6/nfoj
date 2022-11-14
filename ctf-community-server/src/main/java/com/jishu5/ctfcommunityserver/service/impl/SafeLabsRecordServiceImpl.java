package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeLabs;
import com.jishu5.ctfcommunityserver.entity.SafeLabsRecord;
import com.jishu5.ctfcommunityserver.entity.User;
import com.jishu5.ctfcommunityserver.mapper.SafeLabsMapper;
import com.jishu5.ctfcommunityserver.mapper.SafeLabsRecordMapper;
import com.jishu5.ctfcommunityserver.service.SafeLabsRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.service.UserService;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
@Service
public class SafeLabsRecordServiceImpl extends ServiceImpl<SafeLabsRecordMapper, SafeLabsRecord> implements SafeLabsRecordService {

    @Autowired
    private SafeLabsRecordMapper safeLabsRecordMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private SafeLabsMapper safeLabsMapper;

    @Override
    public R getList(Integer currentPage, Integer pageSize) {
        try {
            Page<SafeLabsRecord> page = new Page<>(currentPage, pageSize);

            QueryWrapper<SafeLabsRecord> wrapper = new QueryWrapper<>();
            Page<SafeLabsRecord> safeLabsRecordPage = safeLabsRecordMapper.selectPage(page, wrapper);

            for (SafeLabsRecord safeLabsRecord : safeLabsRecordPage.getRecords()){
                User user = userService.getOne(new QueryWrapper<User>().eq("id", safeLabsRecord.getUserId()));
                SafeLabs safeLabs = safeLabsMapper.selectOne(new QueryWrapper<SafeLabs>().eq("id", safeLabsRecord.getLabId()));
                safeLabsRecord.setUser(user);
                safeLabsRecord.setSafeLabs(safeLabs);
            }

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("data", safeLabsRecordPage.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(page));
            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

    @Override
    public R getWeekRecord() {
        try {
            Map<String, Object> map = new TreeMap<>();
            Map<String, Object> resultMap = new HashMap<>();
            SimpleDateFormat formatVisible = new SimpleDateFormat("MM-dd");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatTimes = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            List<String> time = new ArrayList<>();
            List<Integer> total = new ArrayList<>();
            List<Integer> success = new ArrayList<>();

            for(int i=6;i>=0;i--){
                Calendar calendar = Calendar.getInstance();
                // 第一次循环得到7天前，0点-24点的unix时间戳
                // 第二次循环得到6天前，0点-24点的unix时间戳
                calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);
                // timeDay的格式形如：2020-12-21
                String timeDay = format.format(calendar.getTime());
                Date startTime = formatTimes.parse(timeDay + " 00:00:00");
                Date endTime   = formatTimes.parse(timeDay + " 23:59:59");

                QueryWrapper<SafeLabsRecord> wrapper = new QueryWrapper<>();
                wrapper.le("create_time",endTime);
                wrapper.ge("create_time",startTime);
                Integer count = safeLabsRecordMapper.selectCount(wrapper);
                Integer successCount = safeLabsRecordMapper.selectCount(wrapper.eq("is_success", 1));

                time.add(formatVisible.format(calendar.getTime()));
                total.add(count);
                success.add(successCount);


            }
            map.put("time", time);
            map.put("total", total);
            map.put("success", success);

            resultMap.put("data", map);

            return R.ok(resultMap);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return R.error();
        }
    }
}
