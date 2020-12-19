package com.wb.wbs.dao;

import com.wb.wbs.entity.ClClList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClClListRespository extends JpaRepository<ClClList,Long>, JpaSpecificationExecutor<ClClList> {


}
