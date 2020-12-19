package com.wb.wbs.controller;


import com.wb.wbs.dao.WbManDistanceRepository;
import com.wb.wbs.dao.WbManLocationRepository;
import com.wb.wbs.entity.*;
import com.wb.wbs.inter.LimitRequest;
import com.wb.wbs.test.ShiroFl;
import com.wb.wbs.utils.BaseResponse;
import com.wb.wbs.utils.Locationutils;
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

    @Autowired
    WbManLocationRepository wbManLocationRepository;

    @Autowired
    WbManDistanceRepository wbManDistanceRepository;

    /**
     * 员工经纬度接口
     * @param manId long
     * @param wbDanId long
     * @param lat double
     * @param lng double
     * @return
     */
    @PostMapping("/add/lngAndLat")
    public BaseResponse add(Long manId, Long wbDanId, Double lat, Double lng) {
        //存储经纬度到维保人员表
        //更新维保人员信息
        WbManDan one = wbManService.findByWbManId(manId);
        if (one != null) {
            one.setLat(lat);
            one.setLng(lng);
            WbManDan ones = wbManService.upt(one);
            log.info("wbManService", ones);
           //维保人员Location表记录位置信息
            log.info("---开始添加维保人员Locaotion记录表信息---");
            WbManLocation wbManLocation = new WbManLocation();
            wbManLocation.setCreateTime(new Date());
            wbManLocation.setUpdateTime(new Date());
            wbManLocation.setWbManId(manId);
            wbManLocation.setWbDanId(wbDanId);
            wbManLocation.setLat(lat);
            wbManLocation.setLng(lng);
            WbManLocation loc = wbManLocationRepository.save(wbManLocation);
            log.info("location",loc);
            //存储维保人员距离信息
            //依据维保单ID找出改单的位置记录
            List<WbManLocation> locList = wbManLocationRepository.findAllByWbDanIdOrderByCreateTimeDesc(wbDanId);
            if(locList.size() == 1)
            {
                WbManDistance  wbManDistance = new WbManDistance();
                wbManDistance.setCreateTime(new Date());
                wbManDistance.setUpdateTime(new Date());
                wbManDistance.setDistance(0.0);
                wbManDistance.setWbManId(manId);
                wbManDistance.setWbDanId(wbDanId);
                WbManDistance save = wbManDistanceRepository.save(wbManDistance);
                log.info("记录为1条",save);
            }
            else
            {
                WbManLocation first = locList.get(0);
                WbManLocation last = locList.get(locList.size() -1);
                double distance = responseUtils.getDistance(first.getLng(),first.getLat(),last.getLng(),last.getLat());
                WbManDistance wbManDistance2 = new WbManDistance();
                wbManDistance2.setCreateTime(new Date());
                wbManDistance2.setUpdateTime(new Date());
                wbManDistance2.setDistance(distance);
                wbManDistance2.setWbManId(manId);
                wbManDistance2.setWbDanId(wbDanId);
                WbManDistance save2 = wbManDistanceRepository.save(wbManDistance2);
                log.info("记录为1条",save2);
            }
            return responseUtils.success("存储成功");
        } else {
            return responseUtils.error("无此维保人员ID");
        }
    }

    /**
     * 增加经纬度的测试接口
     * @param manId
     * @param lat
     * @param lng
     * @return
     */
    @PostMapping("/addOne")
    public BaseResponse addOne(Long manId,String macNum,Double lat, Double lng)
    {
        WbManDan one = wbManService.findByWbManId(manId);
        if (one != null) {
            one.setLat(lat);
            one.setLng(lng);
            WbManDan ones = wbManService.upt(one);
            log.info("wbManService", ones);
          return responseUtils.success(one);
        }
        return responseUtils.error("人员不存在");
    }

    /**
     * 根据唯一标识码获得维保人员信息
     * get请求
     * @param imei 唯一标识码
     * @return
     */
    @GetMapping("/get/location")
    public BaseResponse mailLocation(String imei)
    {
        return responseUtils.success(wbManService.findByMacNum(imei));
    }
    
    /**
     * 根据GPS坐标转化成BD坐标
     */
    public BaseResponse GPStoBd(double lat,double lng)
    {
        //转化
        Locationutils.GpsToBd(lat,lng);
        return  responseUtils.success();
    }

    /**
     * 测试服务器接口端数据接口
     */
    @GetMapping("/ttl")
    public BaseResponse ttl(String str)
    {
        //将返回的str显示在返回值中
        return  responseUtils.success(str);
    }


    /**
     * 测试OKHttp接口
     * Get
     */
    @GetMapping("/get/test")
    @LimitRequest(count = 3)
    public BaseResponse getTest(String clName )
    {
        //根据物料名获得Wl表中的数据
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicate = new ArrayList<>();
                if(clName != null) {
                    predicate.add(criteriaBuilder.like(root.get("wlName"), "%"+clName+"%"));
                }
                return criteriaBuilder.and(predicate.toArray(new Predicate[predicate.size()]));
            }
        };
        List<WlWlList> wlLists = wlListService.query(specification);
        return  responseUtils.success(wlLists);
    }

    /**
     * 测试OKHttp接口
     * Get
     */
    @PostMapping("/post/test")
    @LimitRequest(count = 3)
    public BaseResponse postTest(String wlName )
    {
        return  responseUtils.success(wlName);
    }


    /**
     * 接受经纬度信息返回
     * @param imei macNum
     * @param lat  纬度
     * @param lng 经度
     * @return
     */
    @PostMapping("/updates/location")
    @LimitRequest(count = 5)
    public BaseResponse mjGet(String imei,Double lat,Double lng) {
        logger.info("---------------");
        logger.info("请求时间" +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a").format(new Date()));
        logger.info("macNum:" + imei);
        logger.info("lat:" + lat);
        logger.info("Lng:" + lng);

        //依据macNum查询数据
        WbManDan wbManDan = wbManService.findByMacNum(imei);
        if (wbManDan != null) {
            wbManDan.setLat(lat);
            wbManDan.setLng(lng);
            //更新wbMan信息表
            WbManDan upt = wbManService.upt(wbManDan);
            //更新WB人员信息表
            WbManLocation wbManLocation = new WbManLocation();
            wbManLocation.setCreateTime(new Date());
            wbManLocation.setUpdateTime(new Date());
            wbManLocation.setLat(lat);
            wbManLocation.setLng(lng);
            wbManLocation.setWbManId(wbManDan.getWbManId());
            WbManLocation loc = wbManLocationRepository.save(wbManLocation);
            logger.info("---" + wbManDan.getWbManName() + "的位置已存储---");
            //判断是否有对应的订单未处理
            //如有未处理的订单返回一个提醒的标识
            Integer status = 1;
            List<WbDan> wbDanList = wbService.findByStatus(status);
            if (wbDanList.size() > 0) {
                //提醒有新的订单
                return responseUtils.remind(upt);
            }
            return responseUtils.success(upt);
        }
        return responseUtils.error("该人员不存在,请联系管理员添加18858948293");
    }

}
