package com.prj.cosm.produce.plan.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.produce.bom.mapper.BomMapper;
import com.prj.cosm.produce.instruct.mapper.InsMapper;
import com.prj.cosm.produce.plan.mapper.PlanMapper;
import com.prj.cosm.produce.plan.service.PlanService;
import com.prj.cosm.produce.plan.service.PlanVO;
import com.prj.cosm.user.alert.mapper.AlertMapper;
import com.prj.cosm.user.alert.service.AlertVO;
import com.prj.cosm.user.emp.mapper.EmpMapper;
import com.prj.cosm.user.emp.service.EmpVO;



@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	AlertMapper aMapper;

	@Autowired
	EmpMapper eMapper;
	
	@Autowired
	BomMapper bomMapper;
	
	@Autowired
	PlanMapper mapper;
	
	@Autowired
	InsMapper insMapper;

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
		PlanVO vo = new PlanVO();
		int result = mapper.insertPlan(planVO);
		vo = mapper.selectMaterialSum(planVO);
		List<EmpVO> eList = new ArrayList<>();
		eList = eMapper.getReceiveUsers("D0103");
		if(vo.getYn1() == 1) {
			for (EmpVO eVO : eList) {
				AlertVO aVO = new AlertVO();
				aVO.setAlertContent(vo.getBom1() + "의 자재재고가 부족합니다. 확인바랍니다.");
				aVO.setAlertReceive(eVO.getUsersNo());
				aMapper.insertAlert(aVO);
			}
		} else if (vo.getYn2() == 1) {
			for (EmpVO eVO : eList) {
				AlertVO aVO = new AlertVO();
				aVO.setAlertContent(vo.getBom2() + "의 자재재고가 부족합니다. 확인바랍니다.");
				aVO.setAlertReceive(eVO.getUsersNo());
				aMapper.insertAlert(aVO);
			}
		} else {
			for (EmpVO eVO : eList) {
				AlertVO aVO = new AlertVO();
				aVO.setAlertContent("생산 1건이 계획되었습니다.");
				aVO.setAlertReceive(eVO.getUsersNo());
				aMapper.insertAlert(aVO);
			}
		}	
		
		return result;
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
		
		//자재출고완료 테이블 insert
		bomMapper.insertMaterialInfo(planVO);
		bomMapper.insertMaterialInfo2(planVO);
		//자재재고량 업데이트
		mapper.updateMaterialInfo(planVO);
		mapper.updateMaterialInfo2(planVO);
		
		
		//생산지시 시 페이지 빠지기
		return mapper.updatePlay(planVO);
	}

	@Override
	public List<PlanVO> completePlanList() {
		// TODO Auto-generated method stub
		return mapper.completePlanList();
	}

	@Override
	public List<PlanVO> selectOrderList() {
		// TODO Auto-generated method stub
		return mapper.selectOrderList();
	}

	@Override
	public int updateOrderInfo(PlanVO planVO) {
		// TODO Auto-generated method stub
		return mapper.updateOrderInfo(planVO);
	}

	@Override
	public void updateMaterialInfo(PlanVO planVO) {
		mapper.updateMaterialInfo(planVO);
		
	}

	@Override
	public void updateMaterialInfo2(PlanVO planVO) {
		mapper.updateMaterialInfo2(planVO);
		
	}

	@Override
	public PlanVO selectMaterialSum(PlanVO planVO) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
