package com.prj.cosm.produce.goods.service;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GoodsVO {
	private String goodsNo;
	private String goodsName;
	private int goodsStandard;
	private String goodsContents;
	private String goodsCheck;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private String goodsDate;
	private String unitCode;
	
	//code
	private String codeNo;
	private String codeName;
}
