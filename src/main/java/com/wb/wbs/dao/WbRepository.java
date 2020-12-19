package com.wb.wbs.dao;

import com.wb.wbs.entity.WbDan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface WbRepository extends JpaRepository<WbDan, Long>, JpaSpecificationExecutor<WbDan> {

    List<WbDan> findAllByClName(String clName);

    List<WbDan> findAllByStatus(Integer status);

}
