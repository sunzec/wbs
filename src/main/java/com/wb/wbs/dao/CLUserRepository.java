package com.wb.wbs.dao;
import com.wb.wbs.entity.ClUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface CLUserRepository extends JpaRepository<ClUser,Long>, JpaSpecificationExecutor<ClUser> {


             
   ClUser findByUserName(String name);

    List<ClUser> findAll(Specification<ClUser> specification);
    Page<ClUser> findAll(Specification<ClUser> specification, Pageable pageable);
}
