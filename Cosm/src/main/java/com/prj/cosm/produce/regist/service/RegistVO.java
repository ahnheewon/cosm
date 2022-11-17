package com.prj.cosm.produce.regist.service;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegistVO {
	
	private String registLOT;
	private String registLabel;
	private int registQuantity;
	private int registError;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private int registDate;
	private int registProductNo;
	private int registInstructNo;
	private String codeNo;
	private String inspection;
}
