package com.wb.wbs.dao;

import com.wb.wbs.entity.WbManDan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface WbManDanRepository extends JpaRepository<WbManDan,Long>, JpaSpecificationExecutor<WbManDan> {

    List<WbManDan> findAllByPhoneLike(String phone);

    WbManDan findByWbManId(Long wbManId);

    WbManDan findByMacNum(String macNum);

    WbManDan findByPhone(String phone);
}
