package com.prj.cosm.equipment.part.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PartService {

	// 부품

	// 전체 조회
	public List<PartVO> getPartList();

	// 단건 조회
	public PartVO getPartInfo(int partNo);

	// 등록
	public int insertPart(PartVO vo);

	// 수정
	public int updatePart(PartVO vo);

	// 삭제
	public int deletePart(@Param("partNo") int partNo);

	// 삭제 시 부품 번호 정렬 update문
	public int updateDeletePartNo(@Param("partNo") int partNo);

	// 입력될 번호를 조회
	public PartVO getPartNo();

// ===================================================================================================
	// 부품 변동
	
	// 전체조회
	public List<PartVO> getPartIOList();

	// 부품 등록
	public int insertPartIO(PartVO vo);

}
