package com.wb.wbs.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "CL_CLList")
@Entity
@Data
public class ClClList implements Serializable {

  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  private Long clKeyId;//客户主键
  private String clId;//客户编号
  private String clName;//客户名
  private String wheelMan;//联系人
  private String email;//邮件
  private String address;//单位地址
  private String web;//税号
  private String tel;//电话
  private String fax;//传真
  private String postCode;//邮编
  private String kind;//客户类型
  private String area;//所在地区
  private String shortName;//简称
  private String isActive;//是否联系
  private String opMan;//业务员
  private String remark;//备注
  private String salesLimit;//销货上限
  private String discount;//折扣
  private String newZlid;
  private String newDmid;
  private Long alertDays;//交货提醒天数
  private Long depotKeyId;//仓库ID
  private String depotName;//仓库名
  private String bank;//银行账号
}
