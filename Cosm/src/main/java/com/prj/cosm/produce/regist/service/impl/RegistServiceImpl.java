package com.prj.cosm.produce.regist.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.produce.instruct.mapper.InsMapper;
import com.prj.cosm.produce.regist.mapper.RegistMapper;
import com.prj.cosm.produce.regist.service.RegistService;
import com.prj.cosm.produce.regist.service.RegistVO;
import com.prj.cosm.user.alert.mapper.AlertMapper;
import com.prj.cosm.user.alert.service.AlertService;
import com.prj.cosm.user.alert.service.AlertVO;
import com.prj.cosm.user.emp.mapper.EmpMapper;
import com.prj.cosm.user.emp.service.EmpService;
import com.prj.cosm.user.emp.service.EmpVO;

@Service
public class RegistServiceImpl implements RegistService {

	@Autowired
	RegistMapper mapper;

	@Autowired
	AlertMapper aMapper;

	@Autowired
	EmpMapper eMapper;

	@Override
	public List<Map<String, Object>> selectRegistList() {

		return mapper.getRegistList();
	}

	@Override
	public RegistVO selectRegistLOT() {
		// TODO Auto-generated method stub
		return mapper.getRegistLOT();
	}

	@Override
	public int insertRegistInfo(RegistVO registVO) { //검수완료 INSERT -> 출고쪽으로 알림
		List<EmpVO> eList = new ArrayList<>();
		eList = eMapper.getReceiveUsers("D0109"); //받는사람
		for (EmpVO eVO : eList) {
			AlertVO aVO = new AlertVO();
			aVO.setAlertContent("검수 완료된 제품이 있습니다.");
			aVO.setAlertReceive(eVO.getUsersNo());
			aMapper.insertAlert(aVO);
		}
		return mapper.insertRegist(registVO);
	}

	@Override
	public int deleteRegistInfo(String registLOT) {
		// TODO Auto-generated method stub
		return mapper.deleteRegist(registLOT);
	}

	@Override
	public RegistVO selectRegistLabel() {
		// TODO Auto-generated method stub
		return mapper.getRegistLabel();
	}

	@Override
	public List<RegistVO> getPlayList() {
		// TODO Auto-generated method stub
		return mapper.getPlayList();
	}

	@Override
	public List<RegistVO> getUnitList() {
		// TODO Auto-generated method stub
		return mapper.getUnitList();
	}

	@Override
	public List<Map<String, Object>> completeList(RegistVO vo) {
		// TODO Auto-generated method stub
		return mapper.completeList(vo);
	}

	@Override
	public List<Map<String, Object>> errorList(RegistVO vo) {
		// TODO Auto-generated method stub
		return mapper.errorList(vo);
	}

}
