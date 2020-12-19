package com.wb.wbs.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name="Depot_InOutList")
@Entity
@Data
public class DepotInOutList implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long inOutId;
  private Long inOutDanId;
  private String danOrder;
  private Long wlKeyId;
  private String wlBarCode;
  private String wlName;
  private String wlType;
  private Double inCount;
  private Double outCount;
  private Double pdCount;
  private String price;
  private String pay;
  private String unit;
  private Timestamp inOutDate;
  private Long srcId;
  private Long destId;
  private Long warranty;
  private Timestamp batch;
  private Long labelCount;
  private String strField5;
  private Double numField2;
  private Double numField3;
  private String remark;
  private String isBreakDown;
  private Double baseNum;
  private String serial;
  private String wlisSerial;
  private String stockLocate;
  private Long listKeyId;
}
