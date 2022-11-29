package com.prj.cosm.produce.bom.service;

import java.util.Date;

import lombok.Data;

@Data
public class BomVO {
	private String bomNo;
	private int bomQuantity;
	private String bomProductNo;
	private String bomMaterialNo;
	private int bomQuantityb;
	private String bomMaterialNob;
	
	private String mNo;
	private String mName;
	private String mCategory;
	private String mInfo;
	private String mStock;
	private String mUnitCode;
	
	private String goodsNo;
	private String goodsName;
	private int goodsStandard;
	private String goodsContents;
	private String unitCode;
	
	private String planProductNo;
	private int planQuantity;
	private String planBomNo;
	
	private String mioNo;
	private Date mioDate;
	private int mioQuantity;
	private String mioProgress;
	
}
