package com.prj.cosm.equipment.equip.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipVO { 
	// 설비+설비점검+가동시간+실시간측정+공정+(고장)
	// 부품, 공사내역은 따로해요
	
	//설비
	private Integer equipNo;
	private String equipName;
	private Integer equipProcess; // 적용공정
	private String equipType;
	private String equipPurpose;
	private Integer equipCheckCycle;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date equipDate;
	
	private Integer equipRate;
	private Integer equipStdVibe;
	private Integer equipStdTemp;
	private Integer equipState;
	private Integer unitCode;
	
	// 설비별 가동 시간
	private Integer timeEquipNo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date timeStartDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date timeEndDate;
	
	// 실시간 측정
	private Integer rtcNo;
	private Integer rtcEquipNo;
	private Integer rtcVibe;
	private Integer rtcTemp;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date rtcDate;
	
	// 공정
	private Integer processNo;
	private String processName;
	private String processContent;
	private Integer processSeq;
	
	// 점검관련
	
	private Integer testNo;
	private Integer testEquipNo;
	private String testEquipName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date testDate;
	private String testReason;
	private String testContent;
	private String testYn;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date testDueDate;
	private String testCode;
	
	// 고장관련
	private String failRepairYn;
	private Integer failNo;
	private Integer failEquipNo;
	private String failEquipName;
	private String failContent; // 고장내역
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date failDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date failRepairDate;
	
	private String failRepairContent; // 수리내역
	private String failEffect;
	private String failCode;
	
	
	// 공통코드
	
	private String codeNo;
	private String codeName;
	private String codeAdno;

	
	
	
}
