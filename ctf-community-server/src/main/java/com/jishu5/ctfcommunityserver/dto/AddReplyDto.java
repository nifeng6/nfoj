package com.jishu5.ctfcommunityserver.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class AddReplyDto {

    private Integer articleId;

    private String content;

    private Integer replyUserId;

    // 回复表的id
    private Integer replyId;

    private Integer replyFatherId;

    // 1：一级评论，2：二级以上
    private Integer type;



}
