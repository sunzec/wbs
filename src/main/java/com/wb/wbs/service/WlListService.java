package com.wb.wbs.service;

import com.wb.wbs.dao.WlListRepository;
import com.wb.wbs.entity.WlWlList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WlListService {

    @Autowired
    public WlListRepository wlListRepository;

    public WlWlList save(WlWlList wlList)
    {
        return  wlListRepository.save(wlList);
    }

    public WlWlList findOne(Long wlKeyId) {
        return wlListRepository.findById(wlKeyId).orElse(null);
    }

    public List<WlWlList> list() {
        return  wlListRepository.findAll();
    }

    public List<WlWlList> query(Specification specification) {
        return wlListRepository.findAll(specification);
    }


}
