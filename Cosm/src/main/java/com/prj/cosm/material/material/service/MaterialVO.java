package com.prj.cosm.material.material.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class MaterialVO {
	
	
	
//	public void setmUnitCode(String mUnitCode) {
//		this.mUnitCode = mUnitCode;
//	}
//	public void setmNo(String mNo) {
//		this.mNo = mNo; 
//	}
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
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date mDate; // 최종수정일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date mRegDate; // 등록일자
	
	private Integer totalPlanedQntt; // 생산계획 하 필요 자재수량 합계
	private String orderProgress; // 발주 진행 여부
	private Long shortage; // 부족 수량
	private Long totalMoNum; // 현재 발주 진행중인 수량 합계
	
	

	// 2. 자재 변동 내역
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date mioDate;// 입출고 변동일자
	
	private Long mioQntt; // 입고, 출고 변동수량
	private String mioCompanyId; // 자재 거래처번호
	private String mioCompanyNm; // 자재 거래처이름

	
	private String mioNo; //  자재번호
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
	private List<String> moi;
	private Long moTtPrice;// 총금액
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date moDate;// 신청일자

	private Integer moUnitPrice;// 발주단가
	private Long moNum;// 발주수량
	private Long sumMoNum; // 발주수량합계
	private String moProgCode; // 진행코드
	
	private List<String> odMno; // 발주시 매치되는 자재번호...들	
	//private List<String> moGrNo; // 개별 발주오더 묶는 번호
	private String moGrNo; // 개별 발주오더 묶는 번호
	

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date StartDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	private String planPlayCode; // 생산 지시 상태코드 
	String mFile; //첨부파일, html 파일 name 과 이름 다르게 해야함(타입이 다르므로)
	

	@JsonIgnore
	private int perpage = 10;
	@JsonIgnore
	private int page = 1;
	
}
