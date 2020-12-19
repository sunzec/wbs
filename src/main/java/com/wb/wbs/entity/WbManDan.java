package com.wb.wbs.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "WBManDan")
@Data
public class WbManDan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long wbManKeyId;//主键
    private Long wbManId;//维保人员ID
    private Long depotKeyId;//部门ID
    private String wbManName;//维保人员姓名
    private String depotName;//部门名
    private String wbManTel;//维保人员联系方式
    private String phone;//电话 全号
    private Double Lng;//经度
    private Double Lat;//纬度
    private String status;//状态
    //维保人员唯一手机标识码
    private String macNum;
}

