package com.prj.cosm.equipment.work.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WorkService {

	// 공사

	// 전체조회
	public List<WorkVO> getWorkList();

	// 단건조회
	public WorkVO getWorkInfo(int equipNo);

	// 등록
	public int insertWork(WorkVO vo);

	// 공사 시간테이블 등록
	public int insertWorkTime(WorkVO vo);

	// 수정
	public int updateWork(WorkVO vo);

	// 삭제
	public int deleteWork(@Param("equipNo") int equipNo);

	// 공사 삭제 시 공사별 가동 시간 데이터 삭제
	public int deleteWorkTime(@Param("equipNo") int equipNo);

	// 삭제 시 공사 번호 정렬 update문
	public int updateDeleteWorkNo(@Param("equipNo") int equipNo);

	// 삭제 시 공사별 가동 시간 공사 번호 정렬 update문
	public int updateDeleteTimeWorkNo(@Param("equipNo") int equipNo); // 공사 테이블이랑 연동되어 있다.

	// 입력될 번호를 조회
	public WorkVO getWorkNo();

	// 이용중인 번호 조회
	// public List<WorkVO> getWorkProcess();

	// ===================================================================================================

}
