package com.prj.cosm.produce.plan.mapper;

import java.util.List;


import com.prj.cosm.produce.plan.service.PlanVO;

public interface PlanMapper {
	
		// 생산계획 전체조회 
		public List<PlanVO> getPlanList();
		
		// 생산계획 단건조회
		public PlanVO getPlanInfo(String planNo); 
		
		//상세조회
		public PlanVO getPlanNo();
		
		//등록
		public int insertPlan(PlanVO planVO);
		
		//수정
		public int updatePlan(PlanVO planVO);
		
		//삭제
		public int deletePlan(String planNo);
		
		//제품번호 리스트
		public List<PlanVO> getGoodsNoList();
		
		//BOM번호 리스트
		public List<PlanVO> getBomNoList();
		
		//생산지시 시 페이지 빠지기
		public int updatePlay(PlanVO planVO);
}
