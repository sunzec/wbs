package com.wb.wbs.controller;


import com.wb.wbs.dao.WbManDistanceRepository;
import com.wb.wbs.dao.WbManLocationRepository;
import com.wb.wbs.entity.*;
import com.wb.wbs.inter.LimitRequest;
import com.wb.wbs.test.ShiroFl;
import com.wb.wbs.utils.BaseResponse;
import com.wb.wbs.utils.Locationutils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("wb/v1/may")
public class MayController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(MayController.class);


    /**
     * 接受用户的经纬度信息存储并返回结果
     * @param imei macNum
     * @param lat  纬度
     * @param lng 经度
     * @return
     */
    @ApiOperation(value = "存储定位信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "imei", value = "手机唯一标识", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lat", value = "纬度", required = true, dataType = "Double"),
            @ApiImplicitParam(name = "lng", value = "经度", required = true, dataType = "Double")
    })
    @PostMapping("/updates/location")
    @LimitRequest(count = 5)
    public BaseResponse mjGet(String imei,Double lat,Double lng) {

        logger.info("---------------");
        logger.info("请求时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a").format(new Date()));
        logger.info("macNum:" + imei);
        logger.info("lat:" + lat);
        logger.info("Lng:" + lng);

        //依据macNum查询
        WbManDan wbManDan = wbManService.findByMacNum(imei);
        if (wbManDan != null) {
            wbManDan.setLat(lat);
            wbManDan.setLng(lng);
            //更新用户信息
            WbManDan updateMsg = wbManService.upt(wbManDan);
            //更新用户位置信息记录表
            WbManLocation wbManLocation = new WbManLocation();
            wbManLocation.setCreateTime(new Date());
            wbManLocation.setUpdateTime(new Date());
            wbManLocation.setLat(lat);
            wbManLocation.setLng(lng);
            wbManLocation.setWbManId(wbManDan.getWbManId());
            wbManLocationRepository.save(wbManLocation);
            logger.info("---" + wbManDan.getWbManName() + "的位置已存储---");
            //判断是否有对应的订单未处理
            //如有未处理的订单返回一个提醒的标识
            Integer status = 1;
            List<WbDan> wbDanList = wbService.findByStatus(status);
            if (wbDanList.size() > 0) {
                //提醒有新的订单
                return responseUtils.remind(updateMsg);
            }
            return responseUtils.success(updateMsg);
        }
        return responseUtils.error("该人员不存在,请联系管理员电话18858948293");
    }

}
