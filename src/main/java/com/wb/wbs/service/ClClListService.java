package com.wb.wbs.service;


import com.wb.wbs.dao.ClClListRespository;
import com.wb.wbs.entity.ClClList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClClListService {
    @Autowired
    ClClListRespository clClListRespository;

    public ClClList findById(Long id)
    {
        return  clClListRespository.findById(id).orElse(null);
    }

}
