package com.jishu5.ctfcommunityserver.dto.params.index;

import lombok.Data;

@Data
public class ResetPasswordParams {

    private String username;

    private String password;

    private String emailCode;

}
