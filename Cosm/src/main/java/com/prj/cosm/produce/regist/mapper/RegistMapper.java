package com.prj.cosm.produce.regist.mapper;

import java.util.List;
import java.util.Map;

import com.prj.cosm.produce.regist.service.RegistVO;

public interface RegistMapper {
	
	public List<Map<String, Object>> getRegistList();
	
	public RegistVO getRegistLOT();
	
	public RegistVO getRegistLabel();
	
	public int insertRegist(RegistVO registVO);
	
	public int deleteRegist(String registLOT);
}
