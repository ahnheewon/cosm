package com.prj.cosm.produce.instruct.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InsVO {
	private String instructNo;
	private int instructQuantity;
	private String instructEx;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date instructDate;
	private String instructPlanNo;
	private String instructMNo;
	private String instructProgressCode;
	private int instructMaterialNum;
	
	//자재번호 리스트
	private String mNo;
	
	//진행상황 리스트
	public String codeName;
	
	public Date planStart;
	public Date planEnd;
}
