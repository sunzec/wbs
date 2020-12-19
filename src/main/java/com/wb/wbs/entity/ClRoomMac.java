package com.wb.wbs.entity;


import lombok.Data;

import javax.persistence.*;

@Table(name = "CL_RoomMac")
@Entity
@Data
public class ClRoomMac {
  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  private Long clRoomMacKeyId; //主键
  private Long clKeyId;//客户ID
  private String roomName;//科室名
  private String macName;//机型
}
