package com.prj.cosm.produce.regist.service;

import java.util.List;
import java.util.Map;

public interface RegistService {

	//완제품 전체조회(오늘자)
	public List<Map<String, Object>> selectRegistList();
	
	//완제품 전체조회(모두)
	public List<Map<String, Object>> completeList();
	
	//LOT_NO
	public RegistVO selectRegistLOT();
	
	//바코드
	public RegistVO selectRegistLabel();
	
	//등록
	public int insertRegistInfo(RegistVO registVO);
	
	//삭제
	public int deleteRegistInfo(String registLOT);
	
	//진행, 단위코드 리스트
	public List<RegistVO> getPlayList();
	
	public List<RegistVO> getUnitList();
}
