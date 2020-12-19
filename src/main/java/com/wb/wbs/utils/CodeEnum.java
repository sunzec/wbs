package com.wb.wbs.utils;

/**
 * 响应枚举类
 */
public enum CodeEnum {

    SUCCESS(0, "success"),
    ERROR(1, "error"),
    STATUS(3,"remind"),
    AUTH_DENIED(401, "权限不够"),
    ;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private Integer code;
    private String msg;


}
