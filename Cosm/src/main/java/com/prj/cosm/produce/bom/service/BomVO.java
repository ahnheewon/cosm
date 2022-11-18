package com.prj.cosm.produce.bom.service;

import lombok.Data;

@Data
public class BomVO {
	private int bomNo;
	private int bomQuantity;
	private int bomProductNo;
	private String bomMaterialNo;
	
	private String mNo;
	private String mName;
	private String mInfo;
	private String mStock;
	private String mUnitCode;
	
	private int goodsNo;
	private String goodsName;
	private int goodsStandard;
	private String goodsContents;
	private String unitCode;
	
}
