package com.prj.cosm.produce.plan.service.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.produce.plan.mapper.PlanMapper;
import com.prj.cosm.produce.plan.service.PlanService;
import com.prj.cosm.produce.plan.service.PlanVO;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanMapper mapper;

	@Override
	public List<PlanVO> selectPlanList() {
		return mapper.getPlanList();
	}

	@Override
	public PlanVO selectPlanNo() {
		return mapper.getPlanNo();
	}

	@Override
	public int insertPlanInfo(PlanVO planVO) {
		return mapper.insertPlan(planVO);
	}

	@Override
	public int updatePlanInfo(PlanVO planVO) {
		return mapper.updatePlan(planVO);
	}

	@Override
	public int deletePlanInfo(String planNo) {
		return mapper.deletePlan(planNo);
		
	}

	@Override
	public PlanVO getPlanInfo(String planNo) {

		return mapper.getPlanInfo(planNo);
	}

	@Override
	public List<PlanVO> getGoodsNoList() {
		// 제품번호 리스트
		return mapper.getGoodsNoList();
	}

	@Override
	public List<PlanVO> getBomNoList() {
		// BOM 리스트
		return mapper.getBomNoList();
	}

	@Override
	public int updatePlay(PlanVO planVO) {
		//생산지시 시 페이지 빠지기
		return mapper.updatePlay(planVO);
	}

	

}
