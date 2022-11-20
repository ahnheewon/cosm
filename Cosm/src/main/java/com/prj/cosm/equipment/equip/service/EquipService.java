package com.prj.cosm.equipment.equip.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EquipService {

	//설비 
	
	// 전체조회
	public List<EquipVO> getEquipList();
	
	// 단건조회
	public EquipVO getEquipInfo(@Param("equipNo")int equipNo);

	// 등록
	public void insertEquip(EquipVO vo);
	
	// 수정
	public int updateEquip(EquipVO vo);
	
	// 삭제
	public int deleteEquip(@Param("equipNo")int equipNo); // 컬럼을 넘길 때는 bno
	
	// 입력될 번호를 조회
	public EquipVO getProcessNo();
	
//===================================================================================================
	//공정 
	
	// 전체조회
	public List<EquipVO> getProcessList();
	
	// 단건조회
	public EquipVO getProcessInfo(@Param("processNo")int processNo);

	// 등록
	public Map insertProcess(EquipVO vo);
	
	// 수정
	public int updateProcess(EquipVO vo);
	
	// 삭제
	public int deleteProcess(@Param("processNo")int processNo); 

	// 입력될 번호를 조회
	public EquipVO getEquipNo();
	
}
