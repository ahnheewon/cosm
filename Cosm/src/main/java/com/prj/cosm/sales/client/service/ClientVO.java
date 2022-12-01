package com.prj.cosm.sales.client.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ClientVO {
	// 고객 정보
	/*
	 * CLIENT_NO, NAME, MANAGER, BUSINESS_NO, REG_DATE, LICENSE_IMG, USER_NO
	 * 
	 * VARCHAR2(200 BYTE) VARCHAR2(200 BYTE) VARCHAR2(200 BYTE) VARCHAR2(200 BYTE)
	 * DATE VARCHAR2(200 BYTE) NUMBER
	 */

	private String clientNo; // 거래처번호
	private String clientName; // 거래처명
	private String manager; // 담당자명
	private String businessNo; // 사업자번호
	private Date regDate; // 등록일자
	private String licenseImg; // 사업자 등록증 -> api로 확인
	private String userNo; // 회원번호
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date openDate;

	//고객가입시 유저에서 no 받아옴
	
	
	// 주문관련 필드 - sql에서 조인할 떄 씀
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate; // 주문일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate; // 예상수령일자
	private String productName; // 제품명
	private Integer totalNum; // 수량
	private Integer totalPrice; // 총금액
	private String note; // 비고(요청사항) / note
	private String deliveryInfo; // 배송상황
	private String ioCode; // 출납상황

	/*
	 * private String clientNo; // 거래처번호 private String name; // 거래처명 private String
	 * manager; // 담당자명 private String tel; // 거래처연락처 private String businessNo; //
	 * 사업자번호 private String address; // 거래처주소 private Date regDate; // 등록일자 private
	 * String licenseImg; // 사업자 등록증 -> api로 확인 private Integer userNo; // 회원번호
	 * private Integer orderNo; // 주문번호
	 */
}
