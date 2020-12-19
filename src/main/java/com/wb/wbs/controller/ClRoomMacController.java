package com.wb.wbs.controller;


import com.wb.wbs.entity.ClClList;
import com.wb.wbs.entity.ClRoomMac;
import com.wb.wbs.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @program: shiroDemo
 * @ClassName ClRoomMac 科室信息
 * @description:
 * @author: SZW
 * @create: 2020-09-07 08:29
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("wb/cl/room")
public class ClRoomMacController extends  BaseController {


    /**
     * @Author szw
     * @Description 新增科室信息
     * @Date 15:34 2020/9/7
     * @Param clKeyId
     * @Param roomName
     * @param macName
     * @return BaseResponse
     **/
     public BaseResponse addRoomMac(Long clKeyId, String roomName, String macName)
     {
         //1.判断客户是否存在
         ClClList client = clClListService.findById(clKeyId);

         //判断是否存在该客户
         if (client != null)
         {
             return responseUtils.error("不存在该客户");
         }
         //2.注入数据
         ClRoomMac clRoomMac = new ClRoomMac();
         clRoomMac.setClKeyId(clKeyId);
         clRoomMac.setRoomName(roomName);
         clRoomMac.setMacName(macName);

         //3.存储数据库
         ClRoomMac cll = clRoomMacService.addOne(clRoomMac);

         //4.返回
         return responseUtils.success(cll);
     }

     /**
      * @Author szw
      * @Description 根据ID获得数据
      * @Date 16:28 2020/9/7
      * @Param id Long
      * @return  BaseReponse
      **/
     @GetMapping("/get/{id}")
     public  BaseResponse getById(@PathVariable(name = "id") Long id)
     {
         return  responseUtils.success(clRoomMacService.getById(id));
     }

     /**
      * @Author szw
      * @Description  删除该科室下的部门
      * @Date 17:07 2020/9/7
      * @Param  Long id
      * @return  BaseResponse
      **/
     @GetMapping("rm/{id}")
     public  BaseResponse deleteById(@PathVariable(name = "id") Long id)
     {
         ClRoomMac clRoomMac = clRoomMacService.getById(id);
         if(clRoomMac != null)
         {
             clRoomMacService.removeOne(clRoomMac);
             ClRoomMac cl2 = clRoomMacService.getById(id);
             if(cl2 == null)
             {
                 return  responseUtils.success();
             }
             return  responseUtils.error();
         }
         return  responseUtils.error();
     }

     /**
      * @Author szw
      * @Description 根据客户ID查询科室信息
      * @Date 17:16 2020/9/7
      * @Param clId 客户Id
      * @return  BaseResponse
      **/
     @GetMapping("/list")
     public  BaseResponse getALlByClId(Long clId)
     {
         return  responseUtils.success(clRoomMacService.findBYClId(clId));
     }


    /**
     * 更改科室信息
     * @param clKeyId
     * @param roomName
     * @param macName
     * @return
     */
    @PostMapping("/upt")
     public BaseResponse upt(Long id,Long clKeyId,String roomName,String macName)
     {
         //1.判断客户是否存在
         ClClList client = clClListService.findById(clKeyId);

         //判断是否存在该客户
         if (client != null)
         {
              return responseUtils.error("不存在该客户");
         }
         //2.注入数据
         ClRoomMac clRoomMac =  clRoomMacService.getById(id);
         if(clRoomMac == null)
         {
             return responseUtils.error("不存在该记录");
         }
         clRoomMac.setClKeyId(clKeyId);
         clRoomMac.setRoomName(roomName);
         clRoomMac.setMacName(macName);
         return  responseUtils.success(clRoomMacService.updateOne(clRoomMac));
     }

}