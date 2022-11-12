package com.jishu5.ctfcommunityserver.dao;

import com.jishu5.ctfcommunityserver.dto.params.index.EmailSendParams;
import com.jishu5.ctfcommunityserver.entity.R;

public interface EmailService {

    public R registerEmail(EmailSendParams emailSendParams);

    public R resetPasswordEmail(EmailSendParams emailSendParams);

}
