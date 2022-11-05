package com.jishu5.ctfcommunityserver.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jishu5.ctfcommunityserver.dto.PageDto;

public class DtoUtils {

    public static <T> PageDto pageDtoHandle(Page<T> page){
        PageDto pageDto = new PageDto();
        pageDto.setTotal(page.getTotal());
        pageDto.setPages(page.getPages());
        pageDto.setPageSize(page.getSize());
        pageDto.setCurrentPage(page.getCurrent());

        return pageDto;
    }

}
