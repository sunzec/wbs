package com.wb.wbs.service;

import com.wb.wbs.dao.WbListRepository;
import com.wb.wbs.entity.WbList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WbListService {

    @Autowired
    WbListRepository wbListRepository;

    public List<WbList> list() {
        return  wbListRepository.findAll();
    }

    public List<WbList> get(String wbWlBarCode, String wbWlName) {

        if(wbWlBarCode !=null)
        {
            wbWlBarCode = "%"+wbWlBarCode+"%";
            if(wbWlName != null)
            {
                wbWlName = "%"+wbWlName+"%";
                return wbListRepository.findAllByWbWlBarCodeLikeAndWbWlNameLike(wbWlBarCode,wbWlName);
            }
            else
            {
                return wbListRepository.findALlByWbWlBarCodeLike(wbWlBarCode);

            }
        }
        else
        {
            if(wbWlName != null)
            {
                wbWlName = "%"+wbWlName+"%";
                return wbListRepository.findAllByWbWlNameLike(wbWlName);
            }
            else
            {
                return wbListRepository.findAllByWbWlBarCodeLikeAndWbWlNameLike(wbWlBarCode,wbWlName);
            }

        }
    }

    public WbList addOne(WbList wbList) {

    return  wbListRepository.saveAndFlush(wbList);
    }

    public WbList findById(Long wbId) {
        return wbListRepository.getOne(wbId);
    }

    public WbList uptOne(WbList wb) {
        return wbListRepository.save(wb);
    }

    public void rmOne(WbList wb) {
        wbListRepository.delete(wb);

    }
}
