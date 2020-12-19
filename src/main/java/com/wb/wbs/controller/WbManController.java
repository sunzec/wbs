package com.wb.wbs.controller;

import com.wb.wbs.entity.WbManDan;
import com.wb.wbs.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: shiroDemo
 * @ClassName WbManController
 * @description: 维保人员接口
 * @author: SZW
 * @create: 2020-09-04 11:04
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("wb/wbMan")
public class WbManController extends BaseController {



    /**
     *功能描述 listAll 获得所有的维保人员
     * @author szw
     * @date 2020/9/4
     * @param
     * @return
     */
    @GetMapping("/list")
    public BaseResponse listAll() {

        //list
        List<WbManDan> wbManDanList = wbManService.listAll();

        if (!wbManDanList.isEmpty()) {
            return responseUtils.success(wbManDanList);
        }
        return responseUtils.error();
    }

    /**
     *功能描述 addWbMan 添加数据
     * @author szw
     * @date 2020/9/4
     * @param
     * @return
     */
    @PostMapping("/add")
    public BaseResponse addWbMan(WbManDan wbManDan) {
        WbManDan wbManDan1 = wbManService.addOne(wbManDan);
        if (wbManDan1 != null) {
            BaseResponse success = responseUtils.success(wbManDan1);
            return success;
        }
        return responseUtils.error();
    }

    /**
     *功能描述 uptWbMan 添加数据
     * @author szw
     * @date 2020/9/4
     * @param
     * @return
     */
    @PostMapping("/upt")
    public BaseResponse uptWbMan(WbManDan wbManDan) {

        WbManDan wbManDan1 = wbManService.upt(wbManDan);
        if (wbManDan1 != null) {
            BaseResponse success = responseUtils.success(wbManDan1);
            return success;
        }
        return responseUtils.error();
    }

    /**
     *功能描述 根据ID搜索
     * @author szw
     * @date 2020/9/4
     * @param
     * @return
     */
    @GetMapping("/get/{id}")
    public BaseResponse getByID(@PathVariable(name = "id") Long id) {
        return responseUtils.success(wbManService.findById(id));
    }

    /**
     *
     * @Author szw
     * @Description
     * @Date 9:30 2020/9/10
     * @Param  phone String
     * @return
     **/
    @GetMapping("/getByPhone")
    public BaseResponse findByPhone(String phone) {

        return responseUtils.success(wbManService.findByPhoneLike(phone));
    }

}