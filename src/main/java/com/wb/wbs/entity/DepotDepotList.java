package com.wb.wbs.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name="Depot_DepotList")
@Entity
@Data
public class DepotDepotList {

  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  private Long depotKeyId;//主键
  private String depotId;//编号
  private String depotName;//仓库名
  private Long depotOrder;//仓库编号
  private String wheelMan;//联系人
  private String remark;//备注
  private String depotKind;//仓库类型

}
