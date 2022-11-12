package com.jishu5.ctfcommunityserver.dto;

import lombok.Data;

@Data
public class Email {
    private String[] user;
    private String subject;
    private String content;
}

