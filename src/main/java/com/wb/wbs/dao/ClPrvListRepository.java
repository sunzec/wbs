package com.wb.wbs.dao;

import com.wb.wbs.entity.ClPrvList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClPrvListRepository extends JpaRepository<ClPrvList,Long>, JpaSpecificationExecutor<ClPrvList> {

}
