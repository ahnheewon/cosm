package com.prj.cosm.equipment.work.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prj.cosm.equipment.work.service.WorkVO;

public interface WorkMapper {

	// 공사
	
			// 전체조회
			public List<WorkVO> getWorkList();
			
			// 단건조회
			public WorkVO getWorkInfo(int equipNo);

			// 등록
			public int insertEquip(WorkVO vo);
			
			// 공사 시간테이블 등록
			public int insertEquipTime(WorkVO vo);
			
			// 수정
			public int updateEquip(WorkVO vo);
			
			
			// 삭제
			public int deleteEquip(@Param("equipNo")int equipNo); 
			
			// 공사 삭제 시 공사별 가동 시간 데이터 삭제
			public int deleteEquipTime(@Param("equipNo")int equipNo); 

			// 삭제 시 공사 번호 정렬 update문
			public int updateDeleteEquipNo(@Param("equipNo")int equipNo);
			
			// 삭제 시 공사별 가동 시간 공사 번호 정렬 update문 
			public int updateDeleteTimeEquipNo(@Param("equipNo")int equipNo); // 공사 테이블이랑 연동되어 있다.
			
			// 입력될 번호를 조회
			public WorkVO getWorkNo();
			
			// 등록할 때 설비명 조회
			public List<WorkVO> getEquipName();
			
//===================================================================================================
	
}
