package com.wb.wbs.controller;

import com.wb.wbs.entity.DepotDepotList;
import com.wb.wbs.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: shiroDemo
 * @ClassName DepotController
 * @description:
 * @author: SZW
 * @create: 2020-09-07 07:59
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("wb/depot")
public class DepotController extends BaseController {

    /**
     * 添加仓库
     * Long depotKeyId;//主键 自己生成
     * String depotName;//仓库名
     * Long depotOrder;//仓库编号
     * String wheelMan;//联系人
     * String remark;//备注
     * String depotKind;//仓库类型
     *
     * @return
     */
    @PostMapping("/add")
    public BaseResponse add(String depotId, String depotName, Long depotOrder, String wheelMan,
                            String remark, String depotKind) {
        DepotDepotList depotDepotList = new DepotDepotList();
        depotDepotList.setDepotId(depotId);
        depotDepotList.setDepotName(depotName);
        depotDepotList.setDepotKind(depotKind);
        depotDepotList.setDepotOrder(depotOrder);
        depotDepotList.setRemark(remark);
        depotDepotList.setWheelMan(wheelMan);

        DepotDepotList dl = depotService.addOne(depotDepotList);
        return responseUtils.success(dl);
    }


    /**
     * 根据ID删除仓库
     */
    @GetMapping("/rm/{id}")
    public BaseResponse rmOne(Long id) {
        DepotDepotList dp = depotService.findOne(id);

        if (dp != null) {
            depotService.rmOne(dp);
            DepotDepotList dp2 = depotService.findOne(id);
            if (dp2 == null) {
                return responseUtils.success();
            }
            return responseUtils.error();
        }
        return responseUtils.error();
    }

    /**
     * @Desp 修改仓库信息
     * @param id
     * @param depotId
     * @param depotName
     * @param depotOrder
     * @param wheelMan
     * @param remark
     * @param depotKind
     * @return
     */
    @PostMapping("/upt")
    public BaseResponse uptOne(Long id, String depotId, String depotName, Long depotOrder, String wheelMan,
                               String remark, String depotKind) {
        DepotDepotList dp = depotService.findOne(id);
        if (dp != null) {
            dp.setDepotId(depotId);
            dp.setWheelMan(wheelMan);
            dp.setDepotName(depotName);
            dp.setDepotOrder(depotOrder);
            dp.setRemark(remark);
            dp.setDepotKind(depotKind);
            DepotDepotList dp2 = depotService.uptOne(dp);
            return responseUtils.success(dp2);
        }

        return responseUtils.error();

    }
    //查询仓库信息
    //1.查询所有信息
    //2.根据条件查询

    /**
     * @return
     * @Author szw
     * @Description
     * @Date 9:27 2020/9/10
     * @Param
     **/
    @GetMapping("/list")
    public BaseResponse list() {
        return responseUtils.success(depotService.findAll());
    }

    /**
     * @param depotName 仓库名
     * @return
     * @Description query
     * @Date 9:27 2020/9/10
     */
    @GetMapping("/query")
    public BaseResponse getByName(String depotName) {
        return responseUtils.success(depotService.findByName(depotName));
    }


}