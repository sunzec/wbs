package com.wb.wbs.dao;

import com.wb.wbs.entity.WbManDistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WbManDistanceRepository extends JpaRepository<WbManDistance,Long>, JpaSpecificationExecutor {
}
