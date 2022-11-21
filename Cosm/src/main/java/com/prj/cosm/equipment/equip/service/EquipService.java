package com.prj.cosm.equipment.equip.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EquipService {

	// 설비 
	
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
				
				// 설비 삭제 시 설비별 가동 시간 데이터 삭제
				public int deleteEquipTime(@Param("equipNo")int equipNo); 
				
				//삭제 시 번호 정렬 update문
				public int updateDeleteEquipNo(@Param("equipNo")int equipNo);
				
				//삭제 시 설비별 가동 시간 설비 번호 정렬 update문 
				public int updateDeleteTimeEquipNo(@Param("equipNo")int equipNo); 
				
				// 입력될 번호를 조회
				public EquipVO getEquipNo();
				
				// 이용중인 공정 번호 조회
				public List<EquipVO> getEquipProcess();
				
//===================================================================================================
	// 공정 
	
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
				
				// 공정 삭제 시 번호 정렬 update문
				public int updateDeleteProcessNo(@Param("processNo")int processNo);
				
				// 공정 삭제 시 적용공정 정렬 update문
				public int updateDeleteEquipProcess(@Param("equipProcess")int equipProcess);
				
				// 입력될 번호를 조회
					public EquipVO getProcessNo();

//=====================================================================================
		
	// 점검		
				
				// 전체조회
				public List<EquipVO> getTestList();
				
				// 단건조회
				public EquipVO getTestInfo(int testNo);

				// 등록
				public int insertTest(EquipVO vo);
							
				// 수정
				public int updateTest(EquipVO vo);
				
				// 삭제
				public int deleteTest(@Param("testNo")int testNo); 
				
				// 삭제 시 설비 번호 정렬 update문
				public int updateDeleteTestNo(@Param("testNo")int testNo);
				
				// 입력될 번호를 조회
				public EquipVO getTestNo();		
						
				
//=====================================================================================	
				
	//고장
				
				// 전체조회
				public List<EquipVO> getFailList();
				
				// 단건조회
				public EquipVO getFailInfo(int failNo);

				// 등록
				public int insertFail(EquipVO vo);
				
				// 수정
				public int updateFail(EquipVO vo);
				
				// 삭제
				public int deleteFail(@Param("failNo")int failNo); 
				
				// 삭제 시 설비 번호 정렬 update문
				public int updateDeleteFailNo(@Param("failNo")int failNo);
				
				// 입력될 번호를 조회
				public EquipVO getFailNo();
	
}
