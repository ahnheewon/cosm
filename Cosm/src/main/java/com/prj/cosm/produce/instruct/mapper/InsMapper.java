package com.prj.cosm.produce.instruct.mapper;

import java.util.List;
import java.util.Map;

import com.prj.cosm.produce.instruct.service.InsVO;

public interface InsMapper {
	
	public List<Map<String, Object>> getInsList();
	
	public InsVO getInsNo();
	
	public int insertIns(InsVO insVO);
	
	public int updateIns(InsVO insVO);
	
	public int deleteIns(int instructNo);
}
