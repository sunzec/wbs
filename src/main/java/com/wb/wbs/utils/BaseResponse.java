package com.wb.wbs.utils;

/**
 * @program: shiroDemo
 * @ClassName BaseResponseData
 * @description:
 * @author: SZW
 * @create: 2020-09-02 14:42
 * @Version 1.0
 **/
public class BaseResponse {

    /**
     * 响应码
     */
    Integer code;

    /**
     * 响应信息
     */
    String msg;

    /**
     * data 存储数据
     */
    Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}