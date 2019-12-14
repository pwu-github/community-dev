package com.wp.community.dto;

import lombok.Data;

/**
 * access_token参数封装类, 用于网络传输的抽象为dto，数据库用model
 */
@Data
public class AccessTokenDTO {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
