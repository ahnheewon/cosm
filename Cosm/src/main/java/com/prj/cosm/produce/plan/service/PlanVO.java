package com.prj.cosm.produce.plan.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PlanVO {
	private String planNo;
	private int planQuantity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date planStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date planEnd;
	private String planEx;
	private String planProductNo;
	private String planBomNo;
	private String planOrderNo;
	private String planPlayCode;
	
	//bom
	private String bomNo;
	private int bomQuantity;
	private String bomMaterialNo;
	private String bomMaterialNob;
	private int bomQuantityb;
	
	//제품
	private String goodsNo;
	private String goodsName;
	private int goodsStandard;
	private String goodsContents;
	private String goodsCheck;
	private String goodsDate;
	
	//주문
	private String orderNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date orderDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date deliveryDate;
	private int totalNum;
	private String note;
	private String codeName;
	private String orderProgressCode;
	private String orderCode;
	
	private String mioNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date mioDate;
	private int mioQuantity;
	private String mioProgress;
	
	private String mNo;
	private int mStock;
	
	private int yn1;
	private int yn2;
	private String bom1;
	private String bom2;
	
	private int check;
}
