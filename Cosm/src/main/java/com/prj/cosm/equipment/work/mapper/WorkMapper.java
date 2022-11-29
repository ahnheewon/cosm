package com.prj.cosm.equipment.work.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prj.cosm.equipment.work.service.WorkVO;

public interface WorkMapper {

	// 공사
	
			// 전체조회
			public List<WorkVO> getWorkAllList();
			
				// 미완조회
				public List<WorkVO> getIncompleteWorkList();
				// 미완 1조회
				public List<WorkVO> getIncompleteWork1();
				// 미완 2조회
				public List<WorkVO> getIncompleteWork2();
				// 미완 3조회
				public List<WorkVO> getIncompleteWork3();
				
				// 완료조회
				public List<WorkVO> getCompleteWorkList();
			
			// 단건조회
			public WorkVO getWorkInfo(int workNo, int workEquipNo);

			// 등록
			public int insertWork(WorkVO vo);
			
				// 공사 결재정보 등록
				public int insertWorkSign(WorkVO vo);
			
			// 공사 수정
			public int updateWork(WorkVO vo);
			
				// 공사 결재정보 수정
				public int updateSignSeq(WorkVO vo);
				
				// 공사 결재승인에 따른 공사코드 수정
				public int updateWorkCode(WorkVO vo);
			
			// 삭제
			public int deleteWork(@Param("workNo")int workNo); 
			
				// 공사 삭제 시 결재정보 데이터 삭제
				public int deleteSign(@Param("workNo")int workNo); 
	
				// 공사 번호 정렬 update문
				public int updateDeleteWorkNo(@Param("workNo")int workNo);
				
				// 결재정보 공사 번호 정렬 update문 
				public int updateDeleteSignNo(@Param("workNo")int workNo); // 공사 테이블이랑 연동되어 있다.
				
	// 입력될 번호를 조회
	public WorkVO getWorkNo();
	
	// 공사 품의 등록한 사람의 회원번호로 그 사람 권한 조회하기
	public WorkVO getSignEmpNo(@Param("signEmpNo")int signEmpNo);

			
//===================================================================================================
	
	
	// 부품

	// 전체조회
	public List<WorkVO> getPartList();

	// 단건조회
	public WorkVO getPartInfo(int partNo);

}
