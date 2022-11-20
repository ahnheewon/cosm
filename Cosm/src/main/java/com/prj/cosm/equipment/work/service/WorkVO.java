package com.prj.cosm.equipment.work.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkVO {
	// 공사 내역

	// 공사

	private int workNo;
	private int workEquipNo;
	private String workName;
	private String workContent;
	private String workCompany;
	private int workPay;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workEndDate;
	private String workPs;
	private String workCode;
	
	
	// 결재 정보
	
	private int signWorkNo;
	private int signEmpNo;
	private int signSeq;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date signDate;
	private String signCode;
	
	// 공통코드
	
	private String codeNo;
	private String codeName;
	private String codeAdno;
	
	// 회원
	private int usersNo;
	private String usersName;
	private String usersId;
	private String usersPassword;
	private String usersSign; // 결재정보
	private String usersTel;
	private String usersAuthor; // 권한코드
	
	// 설비
	private int equipNo;
	private String equipName;
	private int equipProcess; // 적용공정
	private String equipType;
	private String equipPurpose;
	private int equipCheckCycle;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date equipDate;

	private int equipRate;
	private int equipStdVibe;
	private int equipStdTemp;
	private int equipState;
	private int unitCode;

	// 설비별 가동 시간
	private int timeEquipNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date timeStartDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date timeEndDate;

	// 실시간 측정
	private int rtcNo;
	private int rtcEquipNo;
	private int rtcVibe;
	private int rtcTemp;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rtcDate;

}
