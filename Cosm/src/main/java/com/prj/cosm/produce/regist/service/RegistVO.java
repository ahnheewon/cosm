package com.prj.cosm.produce.regist.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RegistVO {
	
	private String registLOT;
	private String registLabel;
	private int registQuantity;
	private int registError;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date registDate;
	private String registProductNo;
	private String registInstructNo;
	private String codeNo;
	private String inspection;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date endDate;
	//진행상황,단위코드 리스트
	public String codeName;
	
	private String orderNo;
	private String orderCode;
}
