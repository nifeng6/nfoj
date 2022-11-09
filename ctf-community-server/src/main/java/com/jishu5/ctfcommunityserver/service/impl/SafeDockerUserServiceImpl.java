package com.jishu5.ctfcommunityserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.SafeDockerUser;
import com.jishu5.ctfcommunityserver.entity.SafeLabs;
import com.jishu5.ctfcommunityserver.entity.SafeType;
import com.jishu5.ctfcommunityserver.mapper.SafeDockerUserMapper;
import com.jishu5.ctfcommunityserver.service.SafeDockerUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jishu5.ctfcommunityserver.service.SafeLabsService;
import com.jishu5.ctfcommunityserver.service.SafeTypeService;
import com.jishu5.ctfcommunityserver.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
@Service
public class SafeDockerUserServiceImpl extends ServiceImpl<SafeDockerUserMapper, SafeDockerUser> implements SafeDockerUserService {

    @Autowired
    private SafeDockerUserMapper safeDockerUserMapper;

    @Autowired
    private SafeTypeService safeTypeService;

    @Autowired
    private SafeLabsService safeLabsService;

    public R getListById(Integer currentPage, Integer pageSize, Integer id){
        try {
            Page<SafeDockerUser> page = new Page<>(currentPage, pageSize);
            QueryWrapper<SafeDockerUser> wrapper = new QueryWrapper<>();
            Page<SafeDockerUser> pageResult = safeDockerUserMapper.selectPage(page, wrapper);

            for (SafeDockerUser safeDockerUser : pageResult.getRecords()){
                SafeLabs safeLabs = safeLabsService.getOne(new QueryWrapper<SafeLabs>().eq("id", safeDockerUser.getLabId()));
                SafeType safeType = safeTypeService.getOne(new QueryWrapper<SafeType>().eq("id",safeLabs.getTypeId()));

                safeLabs.setType(safeType);
                safeDockerUser.setLab(safeLabs);

            }

            Map<String, Object> resultMap = new HashMap<>();

            resultMap.put("data", pageResult.getRecords());
            resultMap.put("page", DtoUtils.pageDtoHandle(pageResult));

            return R.ok(resultMap);
        }catch (Exception e){
            return R.error();
        }
    }

}
