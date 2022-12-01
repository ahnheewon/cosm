package com.prj.cosm.equipment.equip.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.prj.cosm.produce.instruct.service.InsVO;

public interface EquipService {

	// 설비 
	
				// 전체조회
				public List<EquipVO> getEquipList();
				
					// 미완조회
					public List<EquipVO> getIncompleteTestList();
					
					// 완료조회
					public List<EquipVO> getCompleteTestList();
				
				// 단건조회
				public EquipVO getEquipInfo(@Param("equipNo")int equipNo);
			
				// 등록
				public int insertEquip(EquipVO vo);
				
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
				
				// 설비 등록하기 전에 현재 적용 공정에 달려있는 설비 갯수 조회
				public EquipVO getMaxEquipNum(@Param("equipProcess")int equipProcess);
				
//				public void doWork(InsVO insVO);
				public void doWork();
				
				public EquipVO getProAmt();
				
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
				public EquipVO getTestInfo(@Param("testNo")int testNo, @Param("testEquipNo")int testEquipNo);

				// 등록
				public int insertTest(EquipVO vo);
							
				// 수정
				public int updateTestComplete(EquipVO vo);
				public int updateTestIncomplete(EquipVO vo);
				
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
				
					// 미완조회
					public List<EquipVO> getIncompleteFailList();
					
					// 완료조회
					public List<EquipVO> getCompleteFailList();
		
				
				// 단건조회
				public EquipVO getFailInfo(@Param("failNo")int failNo, @Param("failEquipNo")int failEquipNo);

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
	
				public int updateEquipState(int equipNo);
				
				public EquipVO getEquipTime(int equipNo);
				public int controlEquipTime(int equipNo, String type);
}
