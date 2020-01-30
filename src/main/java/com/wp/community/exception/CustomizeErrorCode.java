package com.wp.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题不存在了，要不换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或者评论"),
    NOT_LOGIN(2003,"当前操作需要登录，请登录"),
    SYS_ERROR(2004,"服务器冒烟了，稍后再试试！！"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在!"),
    COMMENT_NOT_FOUND(2006,"评论不存在了！" ),
    CONTENT_IS_EMPTY(2007,"内容不能为空！" );

    private Integer code;
    private String message;


    CustomizeErrorCode(Integer code,String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage(){
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
