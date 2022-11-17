package com.prj.cosm.equipment.equip.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class equipVO { 
	// 설비+설비점검+가동시간+실시간측정+공정+(고장)
	// 부품, 공사내역은 따로해요
	
	//설비
	private int equipNo;
	private String equipName;
	private int equipProcess; // 적용공정
	private String equipType;
	private String equipPurpose;
	private int equipCheckCycle;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date equipDate;
	
	private int equipRate;
	private int equipStdVibe;
	private int equipStdTemp;
	private int equipState;
	private int unitCode;
	
	// 설비별 가동 시간
	private int timeEquipNo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date timeStartDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date timeEndDate;
	
	// 실시간 측정
	private int rtcNo;
	private int rtcEquipNo;
	private int rtcVibe;
	private int rtcTemp;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date rtcDate;
	
	// 공정
	private int processNo;
	private String processName;
	private String processContent;
	private int processSeq;
	
	// 고장관련
	private int failNo;
	private int failEquipNo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date failDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date failRepairDate;
	
	private String failRepairContent;
	private String failEffect;
	private String failCode;
	
	
	
}
