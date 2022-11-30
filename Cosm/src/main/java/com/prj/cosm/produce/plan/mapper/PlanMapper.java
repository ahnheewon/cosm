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
		
		//생산계획 미완료된것만 보이기
		public List<PlanVO> completePlanList();
		
		//주문서 전체조회
		public List<PlanVO> selectOrderList();
		
		//주문서 상태 업데이트
		public int updateOrderInfo(PlanVO planVO);
		
		//생산지시시 재고 업데이트
		public void updateMaterialInfo(PlanVO planVO);
		
		// 생산지시시 재고 업데이트2
		public void updateMaterialInfo2(PlanVO planVO);
		
		//생산계획 시 자재부족 select
		public PlanVO selectMaterialSum(PlanVO planVO);
		
		public List<PlanVO> getPlanCompute();
		
		public int updateCanIns(List<PlanVO> resultList);
}
