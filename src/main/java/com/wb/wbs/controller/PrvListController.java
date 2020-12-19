package com.wb.wbs.controller;

import com.wb.wbs.entity.ClPrvList;
import com.wb.wbs.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shiroDemo
 * @ClassName PrvListController
 * @description:
 * @author: SZW
 * @create: 2020-09-07 08:30
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("prv/v1")
public class PrvListController extends BaseController {


    /**
     * @param prvName    String 供货商姓名
     * @param wheelMan   String 联系人
     * @param email      String 邮箱
     * @param address    String 地址
     * @param web        String 税号
     * @param telPhone   String 电话
     * @param fax        String 传真
     * @param remark     String 备注
     * @param postalCode String 邮编
     * @param kind       String 类型
     * @param area       String 区域
     * @param shortName  String 简称
     * @param isActive   Boolean 是否联系
     * @return BaseReponse
     * @DESP: 增加供货商记录
     * @Param prvId Long 编号
     * @return BaseResponse
     */
    @PostMapping("/add")
    public BaseResponse addPrv(Long prvId, String prvName, String wheelMan, String email,
                               String address, String web, String telPhone, String fax, String remark,
                               String postalCode, String kind, String area, String shortName, Boolean isActive) {

        //注入对象
        ClPrvList clPrvList = new ClPrvList();
        clPrvList.setPrvId(prvId);
        clPrvList.setPrvName(prvName);
        clPrvList.setWheelMan(wheelMan);
        clPrvList.setEmail(email);
        clPrvList.setAddress(address);
        clPrvList.setWeb(web);
        clPrvList.setTelPhone(telPhone);
        clPrvList.setFax(fax);
        clPrvList.setRemark(remark);
        clPrvList.setPostalCode(postalCode);
        clPrvList.setKind(kind);
        clPrvList.setArea(area);
        clPrvList.setShortName(shortName);
        clPrvList.setIsActive(isActive);
        log.info("prvList:", clPrvList);

        //存储
        ClPrvList cl = prvListService.saveOne(clPrvList);
        return responseUtils.success(cl);
    }

    /**
     * 删除供应商
     */
    @GetMapping("/rm/{id}")
    public BaseResponse rmOne(@PathVariable(name = "id") Long id) {
        log.info("id:", id);
        // 查询
        ClPrvList clPrvList = prvListService.findOne(id);

        if (clPrvList != null) {
            prvListService.rmOne(clPrvList);
            ClPrvList cl = prvListService.findOne(id);
            if (cl == null) {
                return responseUtils.success();
            }
            return responseUtils.error();
        }
        return responseUtils.error("id有误");

    }

    /**
     * @param prvName    String 供货商姓名
     * @param wheelMan   String 联系人
     * @param email      String 邮箱
     * @param address    String 地址
     * @param web        String 税号
     * @param telPhone   String 电话
     * @param fax        String 传真
     * @param remark     String 备注
     * @param postalCode String 邮编
     * @param kind       String 类型
     * @param area       String 区域
     * @param shortName  String 简称
     * @param isActive   Boolean 是否联系
     * @return BaseReponse
     * @DESP: 更改供货商信息
     * @Param prvId String 编号
     */
    @PostMapping("/upt")
    public BaseResponse uptPrv(Long id, Long prvId, String prvName, String wheelMan, String email,
                               String address, String web, String telPhone, String fax, String remark,
                               String postalCode, String kind, String area, String shortName, Boolean isActive) {


        ClPrvList clPrvList = prvListService.findOne(id);

        if (clPrvList != null) {
            log.info("prvList Old:", clPrvList);
            clPrvList.setPrvId(prvId);
            clPrvList.setPrvName(prvName);
            clPrvList.setWheelMan(wheelMan);
            clPrvList.setEmail(email);
            clPrvList.setAddress(address);
            clPrvList.setWeb(web);
            clPrvList.setTelPhone(telPhone);
            clPrvList.setFax(fax);
            clPrvList.setRemark(remark);
            clPrvList.setPostalCode(postalCode);
            clPrvList.setKind(kind);
            clPrvList.setArea(area);
            clPrvList.setShortName(shortName);
            clPrvList.setIsActive(isActive);
            ClPrvList cl2 = prvListService.saveOne(clPrvList);
            log.info("prvList New:", clPrvList);
            return responseUtils.success(cl2);
        }
        return responseUtils.error("找不到该供货商");
    }

    /**
     * @return
     * @Author szw
     * @Description 查询所有信息
     * @Date 9:53 2020/9/9
     * @Param
     **/
    @GetMapping("/listAll")
    public BaseResponse findAll() {
        log.info("进入listAll方法-");
        return responseUtils.success(prvListService.list());

    }

    /**
     * 根据条件查询供货商数据
     * @param prvName
     * @param wheelMan
     * @param email
     * @param telPhone
     * @return
     */
    @GetMapping("/list")
    public  BaseResponse list(String prvName,String wheelMan,String email,String telPhone)
    {
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                if(prvName != null)
                {
                    predicates.add(criteriaBuilder.like(root.get("prvName"),"%"+prvName+"%"));
                }
                  if(wheelMan != null)
                {
                    predicates.add(criteriaBuilder.like(root.get("wheelMan"),"%"+wheelMan+"%"));
                }
                  if(email != null)
                {
                    predicates.add(criteriaBuilder.like(root.get("email"),"%"+email+"%"));
                }    if(telPhone != null)
                {
                    predicates.add(criteriaBuilder.like(root.get("telPhone"),"%"+telPhone+"%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<Predicate> list = prvListService.find(specification);
        return  responseUtils.success(list);
    }


    /**
     * 根据供应商ID获得
     */
    @GetMapping("get/{id}")
    public BaseResponse findOne(@PathVariable(name = "id") Long id) {
        log.info("进入findOne方法");
        return responseUtils.success(prvListService.findOne(id));
    }


}