package com.wb.wbs.service;

import com.wb.wbs.dao.CLRoomMacRepository;
import com.wb.wbs.entity.ClRoomMac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClRoomMacService {

    @Autowired

    CLRoomMacRepository clRoomMacRepository;

    public ClRoomMac addOne(ClRoomMac clRoomMac)
    {
        return clRoomMacRepository.save(clRoomMac);
    }

    public ClRoomMac getById(Long id) {
        return  clRoomMacRepository.getOne(id);
    }

    public void removeOne(ClRoomMac clRoomMac) {
        clRoomMacRepository.delete(clRoomMac);
    }

    public List<ClRoomMac> findBYClId(Long clId) {

        return clRoomMacRepository.findAllByClKeyId(clId);
    }

    public ClRoomMac updateOne(ClRoomMac clRoomMac) {
    return  clRoomMacRepository.save(clRoomMac);
    }

}
