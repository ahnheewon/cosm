package com.prj.cosm.produce.instruct.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private String instructMNob;
	private int instructMaterialNumb;
	//자재번호 리스트
	private String mNo;
	private String mName;
	
	//진행상황 리스트
	public String codeName;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	private String planNo;
	private String mioNo;
	private Date mioDate;
	private int mioQuantity;
	private String mioProgress;
	
}
