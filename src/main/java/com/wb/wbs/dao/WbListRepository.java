package com.wb.wbs.dao;

import com.wb.wbs.entity.WbList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WbListRepository extends JpaRepository<WbList,Long> {

    List<WbList> findAllByWbWlBarCodeLikeAndWbWlNameLike(String wbWlBarCode, String wbWlName);

    List<WbList> findALlByWbWlBarCodeLike(String wbWlBarCode);

    List<WbList> findAllByWbWlNameLike(String wbWlName);
}
