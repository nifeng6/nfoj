package com.jishu5.ctfcommunityserver.service;

import com.jishu5.ctfcommunityserver.entity.R;
import com.jishu5.ctfcommunityserver.entity.ToolList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nifeng
 * @since 2022-11-05 13:24:34
 */
public interface ToolListService extends IService<ToolList> {

    public R getList(Integer currentPage, Integer pageSize, Integer type, String keywords);


    // 后台部分

    public R getList(Integer currentPage, Integer pageSize, String keywords, Integer type);

    public R deleteById(Integer id);

    public R deleteListById(String ids);

    public R addTools(ToolList toolList);

    public R updateTools(ToolList toolList);
}
