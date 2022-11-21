package com.prj.cosm.equipment.part.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartVO {
	

	// 부품

	private Integer partNo; // 부품번호
	private Integer partEquipNo; // 설비번호
	private String partName; // 부품이름
	private String partContent; // 부품정보
	private Integer partAmount; //수량

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date partDate; // 수정일자
	
	private String partCode; // 부품 코드
	private Integer partUpdateNum; // 부품 변동량
	
	// 부품 발주
	
	private Integer buyNo; // 구매번호
	private Integer buyPartNo; // 부품번호
	private Integer buyPartAmount; //발주수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date buyDate; // 신청일자
	
	// 부품 변동 내역
	
	private Integer ioPartNo; // 부품번호
	private Integer ioAmount; // 변동수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ioDate; // 출납일자
	private String ioCode;
	
	// 설비
	
	private Integer equipNo;
	private String equipName;

}
