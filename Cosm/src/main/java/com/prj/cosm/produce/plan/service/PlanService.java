package com.prj.cosm.produce.plan.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PlanService {
	//생산계획 전체조회 
	public List<PlanVO> selectPlanList();
	
	//생산계획 단건조회
	public PlanVO getPlanInfo(@Param("planNo")String planNo);
	
	//생산계획 번호
	public PlanVO selectPlanNo();
	
	//등록
	public int insertPlanInfo(PlanVO planVO);
	
	//수정
	public int updatePlanInfo(PlanVO planVO);
	
	//삭제
	public int deletePlanInfo(String planNo);
	
	//제품번호 리스트
	public List<PlanVO> getGoodsNoList();
	
	//BOM번호 리스트
	public List<PlanVO> getBomNoList();
	
	//생산지시 시 페이지 빠지기
	public int updatePlay(PlanVO planVO);

}
