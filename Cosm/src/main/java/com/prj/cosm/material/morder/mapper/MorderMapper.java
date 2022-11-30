package com.prj.cosm.material.morder.mapper;

import java.util.List;

import com.prj.cosm.material.material.service.MaterialVO;
import com.prj.cosm.material.morder.service.MorderVO;

public interface MorderMapper {

	// 입고 리스트 전체조회
	public List<MorderVO> mioInputList(MorderVO vo);

	// 출고 리스트 전체조회
	public List<MorderVO> mioOutputList(MorderVO vo);

	// 입고 대기 리스트 전체 조회
	public List<MorderVO> getStandbyList();

	// 입고 대기 -> 입고 목록으로 이동
	public int insertInputOrder(MorderVO stanby);
	
	// 입고 대기 시 코드 상태 변경
	public int updateCode(MorderVO vo);

	
	// 입고 대기 시 현재 재고로 수량 업데이트
	public int updateMStock(MorderVO vo);
	
	// 입고 확정 시 생산지시 코드 업데이트
	public int updatePlanCode(MorderVO vo);

	
}
