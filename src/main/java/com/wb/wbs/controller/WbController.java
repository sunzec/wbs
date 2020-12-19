package com.wb.wbs.controller;

import com.wb.wbs.entity.WbDan;
import com.wb.wbs.service.WbService;
import com.wb.wbs.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: shiroDemo
 * @ClassName WbController
 * @description: 维保单controller
 * @author: SZW
 * @create: 2020-09-02 15:36
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("wb")
public class WbController extends BaseController {

    @Autowired
    WbService wbService;
    /**
     * 遍历所有数据
     */
    @GetMapping("/list")
    public BaseResponse listAll()
    {
        List<WbDan> wbDanList = wbService.list();
        BaseResponse response = responseUtils.success(wbDanList);
        return  response;
    }


    @PostMapping("/add")
    public  BaseResponse addLst(WbDan wbDan)
    {
       return responseUtils.success(wbService.addList(wbDan));
    }


    /**
     * @Author szw
     * @Description 移除记录
     * @Date 17:13 2020/9/10
     * @Param
     * @return
     **/
    @PostMapping("/rm/{id}")
    public BaseResponse rmLst(Long id)
    {
        WbDan wb = wbService.getById(id);
        if(wb != null)
        {
            wbService.rmList(wb);
            if(wbService.getById(id) == null)
            {
                return  responseUtils.success();
            }
        }

        return responseUtils.error();
    }

    /**
     *功能描述 搜索
     * @author szw
     * @date 2020/9/3
     * @param
     * @return
     */
    @GetMapping("/findByName")
    public BaseResponse findByName(String name)
    {
        return responseUtils.success(wbService.findByName(name));
    }

}