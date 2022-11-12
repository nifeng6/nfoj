package com.jishu5.ctfcommunityserver.dto.params.index;

import lombok.Data;

@Data
public class ResetPasswordVerityParams {

    private String email;

    private String code;

    private String password;

    private String username;
}
