package com.prj.cosm.produce.goods.service;

import lombok.Data;

@Data
public class GoodsVO {
	private String goodsNo;
	private String goodsName;
	private int goodsStandard;
	private String goodsContents;
	private String goodsCheck;
	private String goodsDate;
	private String unitCode;
	
	//code
	private String codeNo;
	private String codeName;
}
