package com.wb.wbs.dao;

import com.wb.wbs.entity.DepotDepotList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DepotRepository extends JpaRepository<DepotDepotList,Long>, JpaSpecificationExecutor<DepotDepotList> {

    List<DepotDepotList> findAllByDepotName(String depotName);
}
