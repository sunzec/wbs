package com.wb.wbs.entity;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "WBDan")
@Data
@Entity
public class WbDan {

  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  private Long wbDanId;//维保单ID
  private String danId;//维保单号
  private Timestamp wbDate;//开单日期
  private Long clKeyId;//客户表关联主键
  private String clid;//客户编号
  private String clName;//客户名称
  private String address;//地址
  private Timestamp inStallDate;//安装日期
  private String fax;//传真
  private Long wlKeyId;//物料表外键
  private String wlType;//机型
  private String warranty;//保修期
  private String anyTime;//随时
  private String random;//随机附件
  private String payWay;//收费方式
  private String fyCount;//复印计数器
  private String zbCount;//制版计数器
  private String hcyl;//耗材余量
  private String problemDate;//问题发生日期
  private String visitWay;//拜访方式
  private Long wbManKeyId;//维保人员ID
  private String wbManName;//维保人员姓名
  private Timestamp clCallTime;//客户来电时间
  private Timestamp wbOutTime;//出发时间
  private Timestamp wbReachTime;//到达时间
  private Timestamp wbLeaveTime;//离开时间
  private String phenomenon;//现象
  private String rate;//发生频率
  private String description;//现状描述
  private String reason;//原因
  private String measure;//措施
  private String result;//结果
  private String yj;//验机
  private String outCome;//结果
  private String suggest;//建议
  private String opinion;//用户建议
  private String satisfaction;//满意程度
  private String tel;//联系人电话
  private String wheelMan;//联系人
  private String wlMoney;//物料费
  private String wbMoney;//维保费
  private String totalPay;//总费用
  private Timestamp xyTime;//
  private Timestamp rtTime;//路途时间
  private Timestamp wokeTime;//工作时间
  private String wlBarCode;//机号
  private String issh;//是否审核
  private Integer status;
}
