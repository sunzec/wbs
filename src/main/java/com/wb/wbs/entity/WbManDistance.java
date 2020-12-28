package com.wb.wbs.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WbMan_Distance")
@Data
public class WbManDistance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long wbManDistanceId;//主键
    private  Long wbManId;  //维保人员ID
    private  Long wbDanId; //维保单号
    private  Double distance;//距离
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
}
