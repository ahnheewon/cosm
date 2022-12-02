package com.prj.cosm.equipment.equip.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.prj.cosm.equipment.equip.mapper.EquipMapper;
import com.prj.cosm.equipment.equip.service.EquipService;
import com.prj.cosm.equipment.equip.service.EquipVO;
import com.prj.cosm.produce.instruct.mapper.InsMapper;
import com.prj.cosm.produce.instruct.service.InsVO;
import com.prj.cosm.user.alert.mapper.AlertMapper;
import com.prj.cosm.user.alert.service.AlertVO;
import com.prj.cosm.user.emp.mapper.EmpMapper;
import com.prj.cosm.user.emp.service.EmpVO;

@Service
public class EquipServiceImpl implements EquipService {

	@Autowired
	EquipMapper mapper;

	@Autowired
	AlertMapper aMapper;

	@Autowired
	InsMapper insMapper;

	@Autowired
	EmpMapper eMapper;
//============================================================================================================================

	// 설비

	@Override
	public List<EquipVO> getEquipList() {

		return mapper.getEquipList();
	}

	@Override
	public EquipVO getEquipInfo(int equipNo) {
		EquipVO eVO = mapper.getEquipInfo(equipNo);
		eVO.setEquipTime(mapper.getEquipTime(equipNo).getEquipTime());
		return eVO;
	}

	@Override
	public int insertEquip(EquipVO vo) {

		return mapper.insertEquip(vo);
	}

	@Override
	public int updateEquip(EquipVO vo) {
		return mapper.updateEquip(vo);
	}

	@Override
	public int deleteEquip(int equipNo) {
		return mapper.deleteEquip(equipNo);
	}

	@Override
	public int deleteEquipTime(int equipNo) {
		return mapper.deleteEquipTime(equipNo);
	}

	@Override
	public int updateDeleteEquipNo(int equipNo) {
		return mapper.updateDeleteEquipNo(equipNo);
	}

	@Override
	public int updateDeleteTimeEquipNo(int equipNo) {

		return mapper.updateDeleteTimeEquipNo(equipNo);
	}

	@Override
	public EquipVO getEquipNo() {
		return mapper.getEquipNo();
	}

	@Override
	public List<EquipVO> getEquipProcess() {

		return mapper.getEquipProcess();
	}

//============================================================================================================================

	// 공정

	@Override
	public EquipVO getProcessNo() {

		return mapper.getProcessNo();
	}

	@Override
	public List<EquipVO> getProcessList() {
		return mapper.getProcessList();
	}

	@Override
	public EquipVO getProcessInfo(int processNo) {
		return mapper.getProcessInfo(processNo);
	}

	@Override
	public Map insertProcess(EquipVO vo) {
		int count = mapper.insertProcess(vo);
		return getResult(count, vo);
	}

	@Override
	public int updateProcess(EquipVO vo) {
		return mapper.updateProcess(vo);
	}

	@Override
	public int deleteProcess(int processNo) {
		return mapper.deleteProcess(processNo);
	}

	public Map getResult(int count, EquipVO vo) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", count);
		result.put("data", vo);
		return result;

	}

	@Override
	public int updateDeleteProcessNo(int processNo) {
		return mapper.updateDeleteProcessNo(processNo);
	}

	@Override
	public int updateDeleteEquipProcess(int equipProcess) {

		return mapper.updateDeleteEquipProcess(equipProcess);
	}

	@Override
	public EquipVO getMaxEquipNum(int equipProcess) {

		return mapper.getMaxEquipNum(equipProcess);
	}

//	@Override
//	public void doWork(InsVO insVO) {
//		EquipVO vo = new EquipVO();
//		List<EquipVO> list = new ArrayList<>();
//		vo = mapper.getDoEquipNo(1);
//		if (vo == null || vo.getEquipNo() == null) {
//			return;
//		}
//		mapper.doWork(vo);
//		mapper.insertEquipTime(vo.getEquipNo());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		vo = mapper.getDoEquipNo(2);
//		mapper.doWork(vo);
//		mapper.insertEquipTime(vo.getEquipNo());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		vo = mapper.getDoEquipNo(3);
//		mapper.doWork(vo);
//		mapper.insertEquipTime(vo.getEquipNo());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		vo = mapper.getDoEquipNo(4);
//		mapper.doWork(vo);
//		mapper.insertEquipTime(vo.getEquipNo());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		vo = mapper.getDoEquipNo(5);
//		mapper.doWork(vo);
//		mapper.insertEquipTime(vo.getEquipNo());
//		try {
//			Thread.sleep(insVO.getInstructQuantity() / 20);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		list = mapper.getStopEquipNo(1);
//		for (EquipVO evo : list) {
//			mapper.stopWork(evo);
//			mapper.updateEquipTime(evo.getEquipNo());
//		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		list = mapper.getStopEquipNo(2);
//		for (EquipVO evo : list) {
//			mapper.stopWork(evo);
//			mapper.updateEquipTime(evo.getEquipNo());
//		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		list = mapper.getStopEquipNo(3);
//		for (EquipVO evo : list) {
//			mapper.stopWork(evo);
//			mapper.updateEquipTime(evo.getEquipNo());
//		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		list = mapper.getStopEquipNo(4);
//		for (EquipVO evo : list) {
//			mapper.stopWork(evo);
//			mapper.updateEquipTime(evo.getEquipNo());
//		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		list = mapper.getStopEquipNo(5);
//		for (EquipVO evo : list) {
//			mapper.stopWork(evo);
//			mapper.updateEquipTime(evo.getEquipNo());
//		}
//
//		List<EmpVO> eList = new ArrayList<>();
//		eList = eMapper.getReceiveUsers("D0105");
//		for (EmpVO eVO : eList) {
//			AlertVO aVO = new AlertVO();
//			aVO.setAlertContent("생산이 완료되었습니다");
//			aVO.setAlertReceive(eVO.getUsersNo());
//			aMapper.insertAlert(aVO);
//		}
//		insMapper.updateInsPlay(insVO);
//	}
	@Scheduled(fixedDelay = 1000)
	public void updateState() {
		mapper.setProState();
	}

	@Scheduled(fixedDelay = 1000)
	public void doWork() {
		InsVO ivo = insMapper.getRecentQntt();
		EquipVO evo = mapper.getRTPState();
		int state = evo.getState();
		int targetAmt = evo.getTargetAmt();
		if (targetAmt == 0) {
			if (state == 1) {
				List<EquipVO> list = new ArrayList<>();
				list = mapper.getStopEquipNo(1);
				for (EquipVO vo : list) {
					mapper.stopWork(vo);
					mapper.updateEquipTime(vo.getEquipNo());
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				list = mapper.getStopEquipNo(2);
				for (EquipVO vo : list) {
					mapper.stopWork(vo);
					mapper.updateEquipTime(vo.getEquipNo());
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				list = mapper.getStopEquipNo(3);
				for (EquipVO vo : list) {
					mapper.stopWork(vo);
					mapper.updateEquipTime(vo.getEquipNo());
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				list = mapper.getStopEquipNo(4);
				for (EquipVO vo : list) {
					mapper.stopWork(vo);
					mapper.updateEquipTime(vo.getEquipNo());
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				list = mapper.getStopEquipNo(5);
				for (EquipVO vo : list) {
					mapper.stopWork(vo);
					mapper.updateEquipTime(vo.getEquipNo());
				}
			}
		} else {
			if (state == 0) {
//				ProcessOn
				EquipVO vo = new EquipVO();
				vo = mapper.getDoEquipNo(1);
				if (vo == null || vo.getEquipNo() == null) {
					return;
				}
				mapper.doWork(vo);
				mapper.insertEquipTime(vo.getEquipNo());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				vo = mapper.getDoEquipNo(2);
				mapper.doWork(vo);
				mapper.insertEquipTime(vo.getEquipNo());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				vo = mapper.getDoEquipNo(3);
				mapper.doWork(vo);
				mapper.insertEquipTime(vo.getEquipNo());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				vo = mapper.getDoEquipNo(4);
				mapper.doWork(vo);
				mapper.insertEquipTime(vo.getEquipNo());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				vo = mapper.getDoEquipNo(5);
				mapper.doWork(vo);
				mapper.insertEquipTime(vo.getEquipNo());
			} else if (state == 1) {
				if (ivo.getInstructQuantity() <= evo.getNowAmt()) {
					insMapper.updateDoneRTP(ivo);
					insMapper.updateEndIns(ivo);
					List<EmpVO> eList = new ArrayList<>();
					eList = eMapper.getReceiveUsers("D0105");
					for (EmpVO eVO : eList) {
						AlertVO aVO = new AlertVO();
						aVO.setAlertContent("/produce/regist"+"^"+ivo.getInstructNo()+" 건 생산이 완료되었습니다");
						aVO.setAlertReceive(eVO.getUsersNo());
						aMapper.insertAlert(aVO);
					}
				}
				if (evo.getTargetAmt() != evo.getNowAmt()) {
					mapper.updateRTPup();
				}
			}
		}
	}

	public EquipVO getProAmt() {
		return mapper.getProAmt();
	}
//===================================================================================================

	// 점검

	@Override
	public List<EquipVO> getTestList() {
		return mapper.getTestList();
	}

	@Override
	public EquipVO getTestInfo(int testNo, int testEquipNo) {
		return mapper.getTestInfo(testNo, testEquipNo);
	}

	@Override
	public int insertTest(EquipVO vo) {
		return mapper.insertTest(vo);
	}

	@Override
	public int updateTestComplete(EquipVO vo) {
		return mapper.updateTestComplete(vo);
	}

	@Override
	public int updateTestIncomplete(EquipVO vo) {
		return mapper.updateTestIncomplete(vo);
	}

	@Override
	public int deleteTest(int testNo) {
		return mapper.deleteTest(testNo);
	}

	@Override
	public int updateDeleteTestNo(int testNo) {
		return mapper.updateDeleteTestNo(testNo);
	}

	@Override
	public EquipVO getTestNo() {
		return mapper.getTestNo();
	}

//===================================================================================================

	// 고장

	@Override
	public List<EquipVO> getFailList() {
		return mapper.getFailList();
	}

	@Override
	public List<EquipVO> getIncompleteFailList() {
		return mapper.getIncompleteFailList();
	}

	@Override
	public List<EquipVO> getCompleteFailList() {
		return mapper.getCompleteFailList();
	}

	@Override
	public EquipVO getFailInfo(int failNo, int failEquipNo) {
		return mapper.getFailInfo(failNo, failEquipNo);
	}

	@Override
	public int insertFail(EquipVO vo) {
		return mapper.insertFail(vo);
	}

	@Override
	public int updateFail(EquipVO vo) {
		return mapper.updateFail(vo);
	}

	@Override
	public int deleteFail(int failNo) {
		return mapper.deleteFail(failNo);
	}

	@Override
	public int updateDeleteFailNo(int failNo) {
		return mapper.updateDeleteFailNo(failNo);
	}

	@Override
	public EquipVO getFailNo() {
		return mapper.getFailNo();
	}

	@Override
	public int updateEquipState(int equipNo) {
		return mapper.updateEquipState(equipNo);
	}

	@Override
	public int controlEquipTime(int equipNo, String type) {
		int result = 0;
		if (type.equals("중단")) {
			result = mapper.updateEquipTime(equipNo);
		} else if (type.equals("가동")) {
			result = mapper.insertEquipTime(equipNo);
		}
		return result;
	}

	@Override
	public List<EquipVO> getIncompleteTestList() {

		return mapper.getIncompleteTestList();
	}

	@Override
	public List<EquipVO> getCompleteTestList() {

		return mapper.getCompleteTestList();
	}

	@Override
	public EquipVO getEquipTime(int equipNo) {

		return mapper.getEquipTime(equipNo);
	}

}
