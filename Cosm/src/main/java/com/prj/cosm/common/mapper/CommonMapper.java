package com.prj.cosm.common.mapper;

import java.util.List;

import com.prj.cosm.common.service.CodeVO;

public interface CommonMapper {

	public List<CodeVO> getCodeList(String cd); 
}
