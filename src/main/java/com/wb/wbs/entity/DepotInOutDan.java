package com.wb.wbs.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name="Depot_InOutDan")
@Entity
@Data
public class DepotInOutDan implements Serializable {
  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  private Long inOutDanId;
  private String danOrder;
  private Timestamp inOutDate;
  private String inOutStyle;
  private String passport;
  private String pName;
  private Long srcId;
  private String srcName;
  private Long destId;
  private String destName;
  private String wheelMan;
  private String inOutKind;
  private String allDanId;
  private String totalPay;

}
