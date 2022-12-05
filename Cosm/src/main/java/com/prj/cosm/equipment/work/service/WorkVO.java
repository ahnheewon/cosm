package com.prj.cosm.equipment.work.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkVO {
	// 공사 내역

	// 공사
	
	private Integer workNo;
	private Integer workEquipNo;
	private String workName;
	private String workContent;
	private String workCompany;
	private Integer workPay;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul") // date picker
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workDate;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workEndDate;
	private String workPs;
	private String workCode;

	private String workEquipName;  //임시방편 그릇
	
	// 결재 정보
	
	private Integer signWorkNo;
	private String signEmpNo;
	private Integer signSeq;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date signDate;
	private String signCode;
	
	private String position; // 직급 때문에 임시 변수추가
	
	// 공통코드
	
	private String codeNo;
	private String codeName;
	private String codeAdno;
	
	// 회원
	private Integer usersNo;
	private String usersName;
	private String usersId;
	private String usersPassword;
	private String usersSign; // 결재정보
	private String usersTel;
	private String usersAuthor; // 권한코드
	
	// 설비
	private Integer equipNo;
	private String equipName;
	private Integer equipProcess; // 적용공정
	private String equipType;
	private String equipPurpose;
	private Integer equipCheckCycle;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date equipDate;

	private Integer equipRate;
	private Integer equipStdVibe;
	private Integer equipStdTemp;
	private Integer equipState;
	private Integer unitCode;
//==============================================================================================
	
	// 부품

		private String partNo; // 부품번호
		private Integer partEquipNo; // 설비번호
		private String partName; // 부품이름
		private String partEquipName;

		
		private String partInfo; // 부품정보
		private int partStock; //수량
		
		@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date partDate; // 수정일자
		
		private String partCode; // 부품 코드
		private int partUpdateNum; // 부품 변동량
		private String partFile; //첨부파일, html 파일 name 과 이름 다르게 해야함(타입이 다르므로)
		
		/*
		 * // 자재 private String mNo; // 자재번호 private String mName; // 자재명 private String
		 * mCategory; // 분류 private Integer mPrice; // 가격 private Integer mStock; // 현재
		 * 재고 private String mUnitCode; // 단위코드 private String mInfo; // 상세정보
		 * 
		 * @DateTimeFormat(pattern = "yyyy-MM-dd")
		 * 
		 * @JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Seoul") private Date
		 * mDate; // 최종수정일
		 * 
		 * private String mFile; //첨부파일, html 파일 name 과 이름 다르게 해야함(타입이 다르므로)
		 */}
