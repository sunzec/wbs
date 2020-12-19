package com.wb.wbs.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="WBList")
@Data
public class WbList {
  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  private Long wbId; //主键
  private Long wbDanId;//维保单ID
  private Long wbWlKeyId;//维保物料ID
  private String wbWlBarCode;//维保物料编号
  @Column(name="wbwlName")
  private String wbWlName;//维保物料信息
  private String wbWlType;//类型
  private Double wbNumber;//数量
  private Double wbPrice;//单价
  private Double wbPay;//总费用
  private String unit;//单位
  private Double dzPrice;//对账金额
}
