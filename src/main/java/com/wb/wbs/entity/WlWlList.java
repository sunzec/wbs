package com.wb.wbs.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name="WL_WLList")
@Entity
@Data
public class WlWlList {
  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  private Long wlKeyId; //主键
  private String wlId;//物料ID
  private String wlName;//物料名
  private String wlType;//物料类别
  private Double curCount;//当前数量
  private Double sumInRoadCount;//在途量
  private Double sumLockCount;//锁定量
  private Double price;//单价
  private Double costPrice;//费用价格
  private String unit;//单位
  private String wlBarCode;//商品代码
  private Double minStock;//最小库存
  private String stockLocate;//货位
  private String strField2;
  private String strField3;
  private String strField4;
  private String strField5;
  private Double maxStock;//最大库存
  private String remark;//备注
  private String isBreakDown;//是否报废
  private Double baseNum;//基础数量
  @Column(name = "wlisSerial")
  private String wlIsSerial;//是否输入序列号
  private String adaptType;//适配类型
  private Double realCount;//当前数量
  private Long warranty;//质保期限
}
