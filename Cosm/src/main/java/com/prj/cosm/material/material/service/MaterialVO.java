package com.prj.cosm.material.material.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date mDate; // 최종수정일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date mRegDate; // 등록일자

	// 2. 자재 변동 내역
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date mioInputDate;// 입고일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date mioOutputDate;// 출고일자

	private int mioInQntt; // 입고수량
	private int mioOutQntt; // 출고수량

	private String mioInId; // 입고번호
	private String mioOutId; // 출고번호

	private String mioLOT; // LOT_NO

	private String mioMrgNm; // 담당자명
	private int mioOrderId; // 발주번호
	private String mioProgress; // 진행코드

	private List<String> delmno; // 삭제시 매치되는 자재번호...들
	
	private int increase; // 증감

	// 3. 자재 거래처 정보
	private String mCompanyId; // 자재 거래처번호
	private String mCompanyNm; // 자재 거래처이름
	private String mCompanyTel; // 자재 거래처 번호
	private String mMngNm; // 자재 거래처 담당자 이름
	private String mZipCode; // 거래처 우편번호
	private String mCompanyAdd; // 자재 거래처 주소
	private String mAddrDetail; // 자재 거래처 주소(상세)

	// 4. code, search
	private String codeName; // 단위코드 이름
	private String keyword; // 검색시 키워드

	// 5. 발주 관리
	private String mOrderId; // 발주번호

	private Integer moTtPrice;// 총금액
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date moDate;// 신청일자

	private Integer moUnitPrice;// 발주단가
	private Integer moNum;// 발주수량

	private String moProgcode; // 진행코드
	
	private List<String> odMno; // 발주시 매치되는 자재번호...들
	

}
