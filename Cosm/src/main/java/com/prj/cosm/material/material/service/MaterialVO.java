package com.prj.cosm.material.material.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data

public class MaterialVO {
	// 1. 자재 정보, 재고 관리
	private String mNo; // 자재번호
	private String mName; // 자재명
	
	private String mCategory; // 분류
	
	private int mPrice; // 가격
	private int mStock; // 현재 재고
	
	private String mUnitCode; // 단위코드
	private String mUnitNm; // 단위이름(L,Kg...)
	private String mInfo; // 상세정보
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mDate; // 최종수정일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mRegDate; // 등록일자

	// 2. 자재 변동 내역
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mioInputDate;// 입고일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mioOutputDate;// 출고일자

	private int mioInQntt; // 입고수량
	private int mioOutQntt; // 출고수량
	
	private String mioInId; // 입고번호
	private String mioOutId; // 출고번호

	private String mioLOT; // LOT_NO

	private String mioMrgNm; // 담당자명
	private int mioOrderId; // 발주번호
	private String mioProgress; // 진행코드

	private List<String> delmno; // 삭제시 매치되는 자재번호
	private int increase; // 증감 
	
	//3. 자재 거래처 정보
	private int mCompanyId; // 자재 거래처번호
	private String mCompanyNm; // 자재 거래처이름
	private String mCompanyTel; // 자재 거래처 번호
	private String mMngNm; // 자재 거래처 담당자 이름
	private String mCompanyAdd; //자재 거래처 주소
}
