package com.jishu5.ctfcommunityserver.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

@Data
public class ShareCodeDto {

    private String content;

    private String type;

}
