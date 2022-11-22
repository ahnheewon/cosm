package com.prj.cosm.produce.bom.service;

import lombok.Data;

@Data
public class BomVO {
	private String bomNo;
	private int bomQuantity;
	private String bomProductNo;
	private String bomMaterialNo;
	
	private String mNo;
	private String mName;
	private String mInfo;
	private String mStock;
	private String mUnitCode;
	
	private String goodsNo;
	private String goodsName;
	private int goodsStandard;
	private String goodsContents;
	private String unitCode;
	
}
