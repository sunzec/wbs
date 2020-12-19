package com.wb.wbs.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: shiroDemo
 * @ClassName ResponseUtils 返回工具类
 * @description:
 * @author: SZW
 * @create: 2020-09-02 14:46
 * @Version 1.0
 **/
public class ResponseUtils {

    /*
     *功能描述
     * @author szw
     * @date 2020/9/2
     * @param
     * @return
     */
    public BaseResponse success() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(CodeEnum.SUCCESS.getCode());
        baseResponse.setMsg(CodeEnum.SUCCESS.getMsg());
        return baseResponse;
    }

    /*
     *功能描述
     * @author szw
     * @date 2020/9/9
     * @param Objece data
     * @return
     */
    public BaseResponse success(Object data) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(CodeEnum.SUCCESS.getCode());
        baseResponse.setMsg(CodeEnum.SUCCESS.getMsg());
        baseResponse.setData(data);
        return baseResponse;
    }


    /**
     * 返回提醒信息
     * @return
     */
    public BaseResponse remind(Object data) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(CodeEnum.STATUS.getCode());
        baseResponse.setMsg(CodeEnum.STATUS.getMsg());
        baseResponse.setData(data);
        return baseResponse;
    }

    /**
     * 功能描述
     * @author szw
     * @date 2020/9/9
     * @param
     * @return
     */
    public BaseResponse error() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(CodeEnum.ERROR.getCode());
        baseResponse.setMsg(CodeEnum.ERROR.getMsg());
        return baseResponse;
    }


    /**
     *功能描述
     * @author szw
     * @date 2020/9/2
     * @param
     * @return
     */
    public BaseResponse error(Object data) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(CodeEnum.ERROR.getCode());
        baseResponse.setMsg(CodeEnum.ERROR.getMsg());
        baseResponse.setData(data);
        return baseResponse;
    }


   public BaseResponse error(String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(CodeEnum.ERROR.getCode());
        baseResponse.setMsg(msg);
        return baseResponse;
    }


    /**
     * 计算两点之间真实距离
     * @return 千米(km)
     */
    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        // 纬度
        double lat1 = (Math.PI / 180) * latitude1;
        double lat2 = (Math.PI / 180) * latitude2;

        // 经度
        double lon1 = (Math.PI / 180) * longitude1;
        double lon2 = (Math.PI / 180) * longitude2;

        // 地球半径
        double R = 6371;

        // 两点间距离 km，如果想要米的话，结果*1000
        double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;

        return d;
    }


    public static void testList()
    {
        List<String> list = new ArrayList<>();
        list.add("asdaaf");
        list.add("asdaaf1");
        list.add("asdaaf2");
        for (String attribute: list)
        {
            System.out.println(attribute);
        }
    }

    public static void main(String[] args) {
        testList();

    }


}