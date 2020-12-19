package com.wb.wbs.controller;

import com.wb.wbs.dao.CLUserRepository;
import com.wb.wbs.entity.ClUser;
import com.wb.wbs.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @program: shiroDemo
 * @ClassName UserController
 * @description:
 * @author: SZW
 * @create: 2020-08-31 13:21
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("user")
public class UserController  extends BaseController{
    @Autowired
    CLUserRepository clUserRepository;

    //add
    @GetMapping("/get/{id}")
    public ClUser getClUser(@PathVariable(name="id")Long id)
    {
        ClUser getClUser = clUserRepository.findById(id).orElse(null);
        return  getClUser;
    }


    @GetMapping("/getByName")
    public Map getUserByName(String name)
    {
        log.info("param",name);
        ClUser clUser = clUserRepository.findByUserName(name);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",clUser);
        return map;
    }

    @GetMapping("/test")
    public BaseResponse tt(String name, String psd, String token)
    {
        Integer page = 1;
        Integer size = 2;
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicate = new ArrayList<>();
                if(name != null) {
                    predicate.add(criteriaBuilder.like(root.get("userName"), "%"+name+"%"));
                }
                if(psd != null)
                {
                    predicate.add(criteriaBuilder.like(root.get("userPsd"),"%"+psd+"%"));
                }
                if(token != null)
                {
                    predicate.add(criteriaBuilder.like(root.get("userToken"),"%"+token+"%"));
                }
                return criteriaBuilder.and(predicate.toArray(new Predicate[predicate.size()]));
            }
        };


        Sort sort = Sort.by(Sort.Direction.DESC,"userId");
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<ClUser> pg = clUserRepository.findAll(specification, pageable);
        long totalElements = pg.getTotalElements();
        long totalPages = pg.getTotalPages();
        List<ClUser> content = pg.getContent();

        return responseUtils.success(pg);

    }

}