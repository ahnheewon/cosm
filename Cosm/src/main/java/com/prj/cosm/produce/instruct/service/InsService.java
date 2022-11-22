package com.prj.cosm.produce.instruct.service;

import java.util.List;
import java.util.Map;

public interface InsService {
	
	//생산지시 전체조회
	public List<Map<String, Object>> selectInsList();
	//생산지시 번호
	public InsVO selectInsNo();
	//등록
	public int insertInsInfo(InsVO insVO);
	//수정
	public int updateInsInfo(InsVO insVO);
	//삭제
	public int deleteInsInfo(String instructNo);
	
	//자재번호 리스트
	public List<InsVO> getMaterialNoList();
	
	//진행상황 리스트
	public List<InsVO> getPlayList();
	
	//생산완료된 생산지시 리스트
	public List<Map<String, Object>> completeList();
}
