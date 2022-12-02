package com.prj.cosm.material.morder.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MorderVO {

	// 1. 자재 입출고 - 입,출고된 자재 리스트

	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date mioDate;// 일자
	
	private String mioComId;// 거래처번호
	private String mioComNm;// 거래처이름

	private int mioQntt; // 입고수량
	private int mStock; // 현재재고
	private String mNo; // 현재재고

	private String mioProgress; // 진행코드

	// 2. 발주관리
	private String mioName; // 자재명
	private String mioNo; // 자재번호
	private String mOrderId; // 발주번호

	
	
	// 3. 품질관리
	private String mioQuality; // 품질상태
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date startDate; // 시작일(날짜조회)
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date endDate; // 마지막일(날짜조회)
	
	// 4. 입고대기
	private String moOrderId; // 주문번호
	private String moMaterialId; // 자재 번호(=mNo)
	private Integer moUnitPrice;// 발주단가
	private Integer moNum;// 발주수량
	private String moGrNo; // 개별 발주오더 묶는 번호
	private String moProgCode; // 진행코드
	private String moComId; // 거래처코드
	private String moComNm; // 거래처이름
	private String moName; // 자재 이름(m_name)
	private Integer moTtPrice;// 총금액
	
	private List<MorderVO> stanby; // 입고 대기 중인 오더 

}
