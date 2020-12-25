package com.wb.wbs.controller;


import com.wb.wbs.dao.WbManDistanceRepository;
import com.wb.wbs.dao.WbManLocationRepository;
import com.wb.wbs.entity.WbDan;
import com.wb.wbs.service.*;
import com.wb.wbs.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: shiroDemo
 * @ClassName BaseCOntroller
 * @description:
 * @author: SZW
 * @create: 2020-09-02 15:41
 * @Version 1.0
 **/

public class BaseController {

    public static ResponseUtils responseUtils  = new ResponseUtils();

    @Autowired
    public ClClListService clClListService;
    @Autowired
    public ClRoomMacService clRoomMacService;
    @Autowired
    public PrvListService prvListService;
    @Autowired
    public DepotService depotService;
    @Autowired
    public WbListService wbListService;
    @Autowired
    public WlListService wlListService;
    @Autowired
    WbManService wbManService;
    @Autowired
    public WbService wbService;
    @Autowired
    public WbManLocationRepository wbManLocationRepository;
    @Autowired
    public WbManDistanceRepository wbManDistanceRepository;
}