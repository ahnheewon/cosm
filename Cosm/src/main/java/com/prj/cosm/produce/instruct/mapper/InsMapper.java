package com.prj.cosm.produce.instruct.mapper;

import java.util.List;
import java.util.Map;

import com.prj.cosm.produce.instruct.service.InsVO;

public interface InsMapper {

	public List<Map<String, Object>> getInsList();

	public InsVO getInsNo();

	public int insertIns(InsVO insVO);

	public int updateIns(InsVO insVO);

	public int deleteIns(String instructNo);

	// 자재번호 리스트
	public List<InsVO> getMaterialNoList();

	// 진행상황 리스트
	public List<InsVO> getPlayList();

	// 생산완료된 생산지시 리스트
	public List<Map<String, Object>> completeList();

	// 생산지시 완료되게 업데이트
	public int updateInsPlay(InsVO InsVO);

	// 생산지시 완료되게 업데이트
	public int updateInsPlay2(InsVO InsVO);

	// 모든 생산지시 전체조회
	public List<Map<String, Object>> allInsList(InsVO vo);
	
	public void updateRTP(InsVO vo);
	
	public InsVO getRecentQntt();
	
	public void updateDoneRTP(InsVO vo);
	
	public void updateEndIns(InsVO vo);
}
