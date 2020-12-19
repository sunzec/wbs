package com.wb.wbs.controller;

import com.wb.wbs.entity.WbList;
import com.wb.wbs.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: shiroDemo
 * @ClassName WbListController
 * @description:
 * @author: SZW
 * @create: 2020-09-07 07:57
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("wb/list")
public class WbListController extends BaseController  {


    /**
     * 搜索所有数据
     * @return
     */
    @GetMapping("list")
    public BaseResponse list()
    {
        List<WbList> wbListList =  wbListService.list();
        return responseUtils.success(wbListList);
    }

    /**
     * 根据barCode和 name 搜索
     * @param wbWlBarCode
     * @param wbWlName
     * @return
     */
    @GetMapping("get")
    public BaseResponse get(String wbWlBarCode,String wbWlName)
    {
        List<WbList> wbListList =  wbListService.get(wbWlBarCode,wbWlName);
        return  responseUtils.success(wbListList);
    }


    /**
     *    增加一条维保记录
     *    wbDanId;//维保单ID
     *      wbWlKeyId;//维保物料ID
     *      wbWlBarCode;//维保物料编号
     *     String wbWlName;//维保物料信息
     *     String wbWlType;//类型
     *     Double wbNumber;//数量
     *    Double wbPrice;//单价
     *     Double wbPay;//总费用
     *     String unit;//单位
     *     Double dzPrice;//对账金额
     * @return
     */
    @PostMapping("/add")
    public BaseResponse add(WbList wbList)
    {
        return responseUtils.success(wbListService.addOne(wbList));
    }


    /**
     * 更改维保记录
     * @param wbId
     * @param wbList
     * @return
     */
    @PostMapping("/update")
    public  BaseResponse update(Long wbId,WbList wbList)
    {
       WbList wb =  wbListService.findById(wbId);
       if(wb != null)
       {
           wb.setWbDanId(wbList.getWbDanId());
           wb.setWbWlKeyId(wbList.getWbWlKeyId());
           wb.setWbWlBarCode(wbList.getWbWlBarCode());
           wb.setWbWlName(wbList.getWbWlName());
           wb.setWbWlType(wbList.getWbWlType());
           wb.setWbNumber(wbList.getWbNumber());
           wb.setWbPrice(wbList.getWbPrice());
           wb.setWbPay(wbList.getWbPay());
           wb.setUnit(wbList.getUnit());
           wb.setDzPrice(wbList.getDzPrice());
           WbList wb2 = wbListService.uptOne(wb);
           return responseUtils.success(wb2);
       }
      return  responseUtils.error("无此单号");
    }

    /**
     * 删除一条维保记录
     */
    @PostMapping("/delete/{id}")
    public BaseResponse rmOne(@PathVariable(name = "id") Long id)
    {
        //获得该ID记录
        WbList wb = wbListService.findById(id);
        if(wb != null)
        {
            wbListService.rmOne(wb);
          WbList wb2 =  wbListService.findById(id);
            if(wb2 == null)
            {
                return responseUtils.success("删除成功");
            }
        }
        return responseUtils.error("不存在该记录");
    }

}