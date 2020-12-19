package com.wb.wbs.service;

import com.wb.wbs.dao.WbManDanRepository;
import com.wb.wbs.entity.WbManDan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: shiroDemo
 * @ClassName WbManService
 * @description:
 * @author: SZW
 * @create: 2020-09-04 11:11
 * @Version 1.0
 **/
@Service
public class WbManService {

    @Autowired
    WbManDanRepository wbManDanRepository;

    /**
     * listAll
     *
     * @return
     */
    public List<WbManDan> listAll() {
        return wbManDanRepository.findAll();
    }

    /**
     * 添加wbManDan
     * addOne
     * @param wbManDan
     * @return
     */
    public WbManDan addOne(WbManDan wbManDan) {
        return wbManDanRepository.save(wbManDan);
    }

    public WbManDan upt(WbManDan wbManDan) {
        return wbManDanRepository.save(wbManDan);
    }

    public WbManDan findById(Long id) {
        return wbManDanRepository.getOne(id);
    }

    public List<WbManDan> findByPhoneLike(String phone) {

        return wbManDanRepository.findAllByPhoneLike(phone);
    }

    public WbManDan findByWbManId(Long wbManId) {
        return wbManDanRepository.findByWbManId(wbManId);
    }

    public WbManDan findByMacNum(String macNum) {
        return wbManDanRepository.findByMacNum(macNum);
    }

    public WbManDan findByPhone(String phone) {
        return wbManDanRepository.findByPhone(phone);
    }

}
