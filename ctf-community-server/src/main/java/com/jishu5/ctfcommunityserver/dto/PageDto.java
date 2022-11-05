package com.jishu5.ctfcommunityserver.dto;

import lombok.Data;

@Data
public class PageDto {

    private long pageSize;

    private long currentPage;

    private long total;

    private long pages;
}
