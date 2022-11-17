package com.prj.cosm.produce.plan.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlanVO {
	private int planNo;
	private int planQuantity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date planStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date planEnd;
	private String planEx;
	private int planProductNo;
	private int planBomNo;
	private int planOrderNo;
}
