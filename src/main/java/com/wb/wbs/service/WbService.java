package com.wb.wbs.service;

import com.wb.wbs.dao.WbRepository;
import com.wb.wbs.entity.WbDan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: shiroDemo
 * @ClassName WbService
 * @description:WbService
 * @author: SZW
 * @create: 2020-09-02 15:45
 * @Version 1.0
 **/
@Service
public class WbService {

    @Autowired
    public WbRepository wbRepository;

    public List<WbDan> list() {

        return wbRepository.findAll();
    }

    public  WbDan getById(Long id)
    {
        return wbRepository.getOne(id);
    }
    public WbDan addList(WbDan wbDan) {
        return wbRepository.save(wbDan);
    }
    public void  rmList(WbDan wbDan)
    {
        wbRepository.delete(wbDan);
    }

    public List<WbDan> findByName(String clName) {
        return wbRepository.findAllByClName(clName);
    }

    public List<WbDan> findByStatus(Integer status) {
        return wbRepository.findAllByStatus(status);
    }
}