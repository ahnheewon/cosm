package com.prj.cosm.equipment.equip.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.prj.cosm.equipment.equip.service.EquipVO;
import com.prj.cosm.material.material.service.MaterialVO;

public interface EquipMapper {

	// 설비
	
			// 전체조회
			public List<EquipVO> getEquipList();
			
			// 단건조회
			public EquipVO getEquipInfo(int equipNo);
			

			// 등록
			public int insertEquip(EquipVO vo);
			
			// 수정
			public int updateEquip(EquipVO vo);
			
			
			// 삭제
			public int deleteEquip(@Param("equipNo")int equipNo); 
			
			// 설비 삭제 시 설비별 가동 시간 데이터 삭제
			public int deleteEquipTime(@Param("equipNo")int equipNo); 

			// 삭제 시 설비 번호 정렬 update문
			public int updateDeleteEquipNo(@Param("equipNo")int equipNo);
			
			// 삭제 시 설비별 가동 시간 설비 번호 정렬 update문 
			public int updateDeleteTimeEquipNo(@Param("equipNo")int equipNo); // 설비 테이블이랑 연동되어 있다.
			
			// 입력될 번호를 조회
			public EquipVO getEquipNo();
			
			// 이용중인 공정 번호 조회
			public List<EquipVO> getEquipProcess();

			// 현재 적용 공정에 달려있는 설비 갯수 조회
			public EquipVO getMaxEquipNum(@Param("equipProcess")int equipProcess);
			
			public EquipVO getRTPState();
			
//===================================================================================================
	
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
			
			// 삭제 시 번호 정렬 update문
			public int updateDeleteProcessNo(@Param("processNo")int processNo); // 설비 테이블이랑 연동되어 있다
			
			// 공정 삭제 시 적용공정 정렬 update문
			public int updateDeleteEquipProcess(@Param("equipProcess")int equipProcess);
			
			// 입력될 번호를 조회
			public EquipVO getProcessNo();
			
			public void doWork(EquipVO vo);
			
			public void setProState();
			
			public void updateRTPup();
			
			public EquipVO getProAmt();
			
			public void stopWork(EquipVO vo);
			
			public EquipVO getDoEquipNo(int proNo);
			
			public List<EquipVO> getStopEquipNo(int proNo);
			

//===================================================================================================
			
	// 점검		
			
			// 전체조회
			public List<EquipVO> getTestList();
			
				// 미완조회
				public List<EquipVO> getIncompleteTestList();
				
				// 완료조회
				public List<EquipVO> getCompleteTestList();
			
				// 전체조회 페이지네이션
				public List<EquipVO> getTestListPage(int page, int perPage);
					
				// 전체조회_카운트 페이지네이션용
				public int testListCount(EquipVO vo);
				
				// 선택조회
				public EquipVO getTestSearch(EquipVO vo);
				
			// 단건조회
			public EquipVO getTestInfo(int testNo, int testEquipNo);

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
			
//=====================================================================================	
			
			public int updateEquipState(int equipNo);
			
			public int insertEquipTime(int equipNo);
			
			public int updateEquipTime(int equipNo);
			
			public EquipVO getEquipTime(int equipNo);
}
