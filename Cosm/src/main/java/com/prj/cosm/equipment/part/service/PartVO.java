package com.prj.cosm.equipment.part.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	// 자재
	
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
	
	private Integer totalAmount; // 현재 필요한 재고수량
	private String orderProgress; // 발주 진행 여부
	private Long shortage; // 부족 수량
	private Long totalMoNum; // 발주 수량 합계

}
