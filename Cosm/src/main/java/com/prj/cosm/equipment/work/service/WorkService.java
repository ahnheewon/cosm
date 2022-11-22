package com.prj.cosm.equipment.work.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WorkService {

	// 공사
	
				// 전체조회
				public List<WorkVO> getWorkList();
				
				// 단건조회
				public WorkVO getWorkInfo(int workNo);

				// 등록
				public int insertWork(WorkVO vo);
				
					// 공사 결재정보 등록
					public int insertWorkSign(WorkVO vo);
				
				// 공사 수정
				public int updateWork(WorkVO vo);
				
					// 공사 결재정보 수정
					public int updateWorkSign(WorkVO vo);
				
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


	// ===================================================================================================

}
