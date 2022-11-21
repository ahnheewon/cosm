package com.prj.cosm.equipment.part.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prj.cosm.equipment.part.service.PartVO;

public interface PartMapper {

	// 부품

	// 전체조회
	public List<PartVO> getPartList();

	// 단건조회
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

	// 등록할 때 설비명 조회
	public List<PartVO> getPartEquip();
	
//===================================================================================================

	// 부품 변동
			
	// 전체조회
	public List<PartVO> getPartIOList();
	
	// 부품 등록
	public int insertPartIO(PartVO vo);
	
	
}
