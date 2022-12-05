package com.prj.cosm.equipment.equip.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String equipProcessName; // 적용공정명 

	private String equipType;
	private String equipPurpose;
	private Integer equipCheckCycle;
	
	@JsonFormat(pattern="yyyy-MM-dd a", timezone = "Asia/Seoul",locale="EN_US")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date equipDate;
	
	private String eFile;
	
	private Integer equipRate;
	private Integer equipStdVibe;
	private Integer equipStdTemp;
	private String equipState; // ON/OFF 유무 CODE
	private Integer unitCode;
	
	private int state;
	private int targetAmt;
	private int nowAmt;
	
	// 설비별 가동 시간
	private Integer timeEquipNo;
	
	@JsonFormat(pattern = "yyyy-MM-dd a", timezone = "Asia/Seoul",locale="EN_US")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date timeStartDate;
	
	private Integer equipTime;
	// 실시간 측정
	private Integer rtcNo;
	private Integer rtcEquipNo;
	private Integer rtcVibe;
	private Integer rtcTemp;
	
	@JsonFormat(pattern = "yyyy-MM-dd a", timezone = "Asia/Seoul",locale="EN_US")
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm a", timezone = "Asia/Seoul",locale="EN_US")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date testDate;
	private String testReason;
	private String testContent;
	private String testYn;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm a", timezone = "Asia/Seoul",locale="EN_US")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date testDueDate;
	private String testCode;
	
	private String testCodeName; // 코드진행상황 업데이트용 변수
	private String tCode; // 코드진행상황 업데이트용 변수
	
	// 고장관련
	private String failRepairYn;
	private Integer failNo;
	private Integer failEquipNo;
	private String failEquipName;
	private String failContent; // 고장내역
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm a", timezone = "Asia/Seoul",locale="EN_US")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date failDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm a", timezone = "Asia/Seoul",locale="EN_US")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date failRepairDate;
	
	private String failRepairContent; // 수리내역
	private String failEffect; //안쓸예정
	private String failCode;

	
	// 공통코드
	
	private String codeNo;
	private String codeName;
	private String codeAdno;

	//pagination

	@JsonIgnore
	private int perPage = 12;
	@JsonIgnore
	private int page = 1;
	
	
}
