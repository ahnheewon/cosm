package com.prj.cosm.sales.client.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class ClientVO {
//고객 정보
	 private int clientNo; //거래처번호
	 private String clientName; //거래처명
	 private String clientManager; //담당자명
	 private String clientTel; //연락처
	 private String clientBusinessNo; //사업자번호
	 private String clientAddress; //거래처주소
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date clientRegisterDate; //등록일자
	 private String clientLicenseImg; //사업자 등록증
	 private int clientUserNo; //회원번호
	 
}
