package com.wb.wbs.dao;

import com.wb.wbs.entity.WbManLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface WbManLocationRepository extends JpaRepository<WbManLocation,Long>, JpaSpecificationExecutor {

    List<WbManLocation> findAllByWbDanIdOrderByCreateTimeDesc(Long wbDanId);
}
