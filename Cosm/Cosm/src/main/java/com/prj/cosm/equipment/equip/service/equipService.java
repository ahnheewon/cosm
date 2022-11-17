package com.prj.cosm.equipment.equip.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface equipService {

	//설비 
	
	// 전체조회
	public List<equipVO> getEquipList();
	
	// 단건조회
	public equipVO getEquipInfo(equipVO vo);

	// 등록
	public Map insertEquip(equipVO vo);
	
	// 수정
	public int updateEquip(equipVO vo);
	
	// 삭제
	public int deleteEquip(@Param("equipNo")int equipNo); // 컬럼을 넘길 때는 bno
	
	// 입력될 번호를 조회
	public equipVO getProcessNo();
	
//===================================================================================================
	//공정 
	
	// 전체조회
	public List<equipVO> getProcessList();
	
	// 단건조회
	public equipVO getProcessInfo(equipVO vo);

	// 등록
	public Map insertProcess(equipVO vo);
	
	// 수정
	public int updateProcess(equipVO vo);
	
	// 삭제
	public int deleteProcess(@Param("processNo")int processNo); 

	// 입력될 번호를 조회
	public equipVO getEquipNo();
	
}
