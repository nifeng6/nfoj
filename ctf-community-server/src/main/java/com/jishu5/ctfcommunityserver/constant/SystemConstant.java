package com.jishu5.ctfcommunityserver.constant;

public class SystemConstant {

    /**
     * token
     */
    public static final int JWT_ERRCODE_NULL = 4000;			//Token不存在
    public static final int JWT_ERRCODE_EXPIRE = 4001;			//Token过期
    public static final int JWT_ERRCODE_FAIL = 4002;			//验证不通过
    public static final int JWT_ERRCODE_NOADMIN = 4003;			//非管理员请求

    /**
     * JWT
     */
    public static final String JWT_SECERT = "545C0781AA06FCF54F927A6A8681CAB8";			//密匙
    public static final long JWT_TTL = 24*60 * 60 * 1000;								//token有效时间
}
