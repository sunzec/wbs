package com.wb.wbs.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cl_user")
@Data
public class ClUser {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  private Long userId;
  @Column
  private String userName;
  @Column
  private String userPsd;
  @Column
  private String userToken;

}
