package com.prj.cosm.user.alert.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AlertVO {
	private int alertNo;
	private String alertSend;
	private String alertReceive;
	private String alertContent;
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date alertDate;
	private String codeNo;
}
