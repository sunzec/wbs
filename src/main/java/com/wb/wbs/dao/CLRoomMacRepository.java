package com.wb.wbs.dao;


import com.wb.wbs.entity.ClRoomMac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CLRoomMacRepository extends JpaRepository<ClRoomMac,Long>, JpaSpecificationExecutor<ClRoomMac> {


   List<ClRoomMac> findAllByClKeyId(Long clKeyId);

}
