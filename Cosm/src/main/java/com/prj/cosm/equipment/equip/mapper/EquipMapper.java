package com.prj.cosm.equipment.equip.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.prj.cosm.equipment.equip.service.EquipVO;

public interface EquipMapper {

		// 설비
	
			//전체조회
			public List<EquipVO> getEquipList();
			
			//단건조회
			public EquipVO getEquipInfo(int equipNo);

			//등록
			public int insertEquip(EquipVO vo);
			
			// 설비 시간테이블 등록
			public int insertEquipTime(EquipVO vo);
			
			//수정
			public int updateEquip(EquipVO vo);
			
			//삭제
			public int deleteEquip(@Param("equipNo")int equipNo); // 컬럼을 넘길 때는 bno

			//입력될 번호를 조회
			public EquipVO getEquipNo();
			
//=====================================================================================			
		// 공정 
			
			// 전체조회
			public List<EquipVO> getProcessList();
			
			// 단건조회
			public EquipVO getProcessInfo(int equipNo);

			// 등록
			public int insertProcess(EquipVO vo);
			
			// 수정
			public int updateProcess(EquipVO vo);
			
			// 삭제
			public int deleteProcess(@Param("processNo")int processNo); 

			// 입력될 번호를 조회
			public EquipVO getProcessNo();
	
}
