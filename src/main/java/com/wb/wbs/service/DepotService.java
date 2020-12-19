package com.wb.wbs.service;

import com.wb.wbs.dao.DepotRepository;
import com.wb.wbs.entity.DepotDepotList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotService {


    @Autowired
    DepotRepository depotRepository;
    public DepotDepotList addOne(DepotDepotList depotDepotList) {
        return depotRepository.saveAndFlush(depotDepotList);
    }

    public DepotDepotList findOne(Long id) {
        return  depotRepository.findById(id).orElse(null);
    }

    public void rmOne(DepotDepotList dp) {
        depotRepository.delete(dp);
    }

    public DepotDepotList uptOne(DepotDepotList dp) {
        return  depotRepository.save(dp);
    }

    public List<DepotDepotList> findAll() {
        return depotRepository.findAll();
    }

    public List<DepotDepotList> findByName(String depotName) {
        return depotRepository.findAllByDepotName(depotName);
    }
}
