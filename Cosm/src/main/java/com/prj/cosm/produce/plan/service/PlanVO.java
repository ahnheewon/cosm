package com.prj.cosm.produce.plan.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlanVO {
	private String planNo;
	private int planQuantity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date planStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date planEnd;
	private String planEx;
	private String planProductNo;
	private String planBomNo;
	private String planOrderNo;
	private String planPlayCode;
	
	//bom
	private String bomNo;
	private int bomQuantity;
	
	//제품
	private String goodsNo;
	private String goodsName;
	private int goodsStandard;
	private String goodsContents;
	private String goodsCheck;
	private String goodsDate;
}
