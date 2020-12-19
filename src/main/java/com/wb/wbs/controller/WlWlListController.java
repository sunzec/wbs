package com.wb.wbs.controller;

import com.wb.wbs.entity.WlWlList;
import com.wb.wbs.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shiroDemo
 * @ClassName WlWlList
 * @description:
 * @author: SZW
 * @create: 2020-09-07 08:27
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("wb/wl")
public class WlWlListController extends BaseController {



    /**
     * 新增物料信息
     */
    @PostMapping("/add")
    public BaseResponse addWl(WlWlList wlList) {
        return responseUtils.success(wlListService.save(wlList));
    }

    /**
     * 更新物料信息
     */
    @PostMapping("/upt")
    public BaseResponse uptWl(Long wlKeyId, WlWlList wlList) {
        //根据wlKeyId获得记录
        WlWlList old =wlListService.findOne(wlKeyId);
        if (old != null) {
            //注入数据
            old.setWlId(wlList.getWlId());
            old.setWlName(wlList.getWlName());
            old.setWlType(wlList.getWlType());
            old.setCurCount(wlList.getCurCount());
            old.setSumInRoadCount(wlList.getSumInRoadCount());
            old.setSumLockCount(wlList.getSumLockCount());
            old.setPrice(old.getPrice());
            old.setCostPrice(wlList.getCostPrice());
            old.setUnit(wlList.getUnit());
            old.setWlBarCode(wlList.getWlBarCode());
            old.setMinStock(wlList.getMinStock());
            old.setStockLocate(wlList.getStockLocate());
            old.setStrField2(wlList.getStrField2());
            old.setStrField3(wlList.getStrField3());
            old.setStrField4(wlList.getStrField4());
            old.setStrField5(wlList.getStrField5());
            old.setMaxStock(wlList.getMaxStock());
            old.setRemark(wlList.getRemark());
            old.setIsBreakDown(wlList.getIsBreakDown());
            old.setBaseNum(wlList.getBaseNum());
            old.setWlIsSerial(wlList.getWlIsSerial());
            old.setAdaptType(wlList.getAdaptType());
            old.setRealCount(wlList.getRealCount());
            old.setWarranty(old.getWarranty());
            WlWlList save1 = wlListService.save(old);
            return responseUtils.success(save1);
        }
        return responseUtils.error("找不到该记录");
    }

    /**
     * listAll()
     *
     * @return
     */
    @GetMapping("/list")
    public BaseResponse list() {
        return responseUtils.success(wlListService.list());
    }

    /**
     * search
     */
    @GetMapping("/search")
    public BaseResponse search(String wlName, String wlType, String wlBarCode) {
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicate = new ArrayList<>();
                if (wlName != null) {
                    predicate.add(criteriaBuilder.like(root.get("wlName"), "%" + wlName + "%"));
                }
                if (wlType != null) {
                    predicate.add(criteriaBuilder.equal(root.get("wlType"), wlType));
                }
                if (wlBarCode != null) {
                    predicate.add(criteriaBuilder.like(root.get("wlBarCode"), "%" + wlBarCode + "%"));
                }

                return criteriaBuilder.and(predicate.toArray(new Predicate[predicate.size()]));
            }
        };
        List<WlWlList> wlLists = wlListService.query(specification);
        return responseUtils.success(wlLists);
    }


}

