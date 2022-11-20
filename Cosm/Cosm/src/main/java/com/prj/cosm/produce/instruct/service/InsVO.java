package com.prj.cosm.produce.instruct.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InsVO {
	private int instructNo;
	private int instructQuantity;
	private String instructEx;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date instructDate;
	private int instructPlanNo;
	private int instructMNo;
	private String instructProgressCode;
	
	
}
