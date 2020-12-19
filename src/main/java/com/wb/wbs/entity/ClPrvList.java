package com.wb.wbs.entity;


import lombok.Data;

import javax.persistence.*;

@Table(name="CL_PRVList")
@Entity
@Data
public class ClPrvList {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long prvKeyId;
  private Long prvId;
  private String prvName;
  private String wheelMan;
  private String email;
  private String address;
  private String web;
  private String telPhone;
  private String fax;
  private String remark;
  private String postalCode;
  private String kind;
  private String area;
  private String shortName;
  private Boolean isActive;
  private Long depotKeyId;
  private String depotName;
  @Column(name="isdz")
  private String isDz;
  private String bank;
}
