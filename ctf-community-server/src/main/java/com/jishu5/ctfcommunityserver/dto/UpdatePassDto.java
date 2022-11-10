package com.jishu5.ctfcommunityserver.dto;

import lombok.Data;

@Data
public class UpdatePassDto {

    private String oldPass;

    private String newPass;
}
