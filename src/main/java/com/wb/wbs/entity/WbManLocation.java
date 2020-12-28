package com.wb.wbs.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * 维保人员位置信息表
 */
@Entity
@Table(name=  "WbMan_Location")
@Data
public class WbManLocation {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long wbManLocationId;//主键
    private  Long wbManId;  //维保人员ID
    private  Long wbDanId; //维保单号
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private Double lng; //经度
    private Double lat;//纬度

}
