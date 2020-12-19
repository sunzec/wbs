package com.wb.wbs.dao;

import com.wb.wbs.entity.WlWlList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WlListRepository extends JpaRepository<WlWlList,Long>, JpaSpecificationExecutor {

}
