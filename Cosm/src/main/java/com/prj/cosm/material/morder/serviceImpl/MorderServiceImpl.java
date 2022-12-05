package com.prj.cosm.material.morder.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.material.material.mapper.MaterialMapper;
import com.prj.cosm.material.material.service.MaterialVO;
import com.prj.cosm.material.morder.mapper.MorderMapper;
import com.prj.cosm.material.morder.service.MorderService;
import com.prj.cosm.material.morder.service.MorderVO;
import com.prj.cosm.produce.plan.mapper.PlanMapper;
import com.prj.cosm.produce.plan.service.PlanVO;
import com.prj.cosm.user.alert.mapper.AlertMapper;
import com.prj.cosm.user.alert.service.AlertVO;
import com.prj.cosm.user.emp.mapper.EmpMapper;
import com.prj.cosm.user.emp.service.EmpVO;

@Service
public class MorderServiceImpl implements MorderService {

	@Autowired
	MorderMapper moMapper;

	@Autowired
	AlertMapper aMapper;

	@Autowired
	EmpMapper eMapper;

	@Autowired
	MaterialMapper maMapper;

	@Autowired
	PlanMapper pMapper;

	@Override
	public List<MorderVO> mioInputList(MorderVO vo) {
		// 자재 입고 리스트 조회
		return moMapper.mioInputList(vo);
	}

	@Override
	public List<MorderVO> mioOutputList(MorderVO vo) {
		// 자재 출고 리스트 조회
		return moMapper.mioOutputList(vo);
	}

	@Override
	public List<MorderVO> getStandbyList() {
		// 입고 대기 리스트 조회
		return moMapper.getStandbyList();
	}

	@Override
	public int insertInputOrder(List<MorderVO> mvo) {
		// 입고대기 리스트 -> 입고 리스트(입고완료)
		int result = 0;
		for (MorderVO vo : mvo) {
			result += moMapper.insertInputOrder(vo);
			moMapper.updateCode(vo);
			vo.setMNo(vo.getMoMaterialId());
			moMapper.updateMStock(vo);

			List<EmpVO> eList = new ArrayList<>();
			eList = eMapper.getReceiveUsers("D0105");
			AlertVO aVO = new AlertVO();
			for (EmpVO eVO : eList) {
				aVO.setAlertContent("/produce/instructList" + "^" + vo.getMoName() + " 필요 자재가 입고되었습니다.");
				aVO.setAlertReceive(eVO.getUsersNo());
				aMapper.insertAlert(aVO);
			}

		}

		// 현재 재고 들고오는 매퍼
		List<MaterialVO> mList = maMapper.mList();
		List<PlanVO> pList = pMapper.getPlanCompute();
		List<PlanVO> resultList = new ArrayList<>();
		for (PlanVO pVO : pList) {
			pVO.setCheck(0);
			for (MaterialVO mVO : mList) {
				int compute = mVO.getMStock();
				if (mVO.getMNo().equals(pVO.getBomMaterialNo())) {
					if (compute >= pVO.getBomQuantity()) {
						compute -= pVO.getBomQuantity();
						if (pVO.getCheck() == 1) {
							pVO.setCheck(2);
						} else {
							pVO.setCheck(1);
						}
					}
				}
				if (mVO.getMNo().equals(pVO.getBomMaterialNob())) {
					if (compute >= pVO.getBomQuantityb()) {
						compute -= pVO.getBomQuantityb();
						if (pVO.getCheck() == 1) {
							pVO.setCheck(2);
						} else {
							pVO.setCheck(1);
						}
					}
				}
			}
			if (pVO.getCheck() == 2) {
				resultList.add(pVO);
			}
		}
		if (resultList != null && resultList.size() != 0) {
			pMapper.updateCanIns(resultList);
		}

		return result;

	}

	@Override
	public int updateCode(MorderVO vo) {
		// 입고 확정시 발주 코드 업데이트
		return moMapper.updateCode(vo);
	}

	@Override
	public int updateMStock(MorderVO vo) {
		// 입고 확정시 현재재고 업데이트
		return moMapper.updateMStock(vo);
	}

	@Override
	public int updatePlanCode(MorderVO vo) {
		// 입고 확정시 생산지시 코드 업데이트
		return moMapper.updateCode(vo);
	}

}
