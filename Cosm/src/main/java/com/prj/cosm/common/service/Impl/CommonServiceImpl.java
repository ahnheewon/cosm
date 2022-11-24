package com.prj.cosm.common.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.common.mapper.CommonMapper;
import com.prj.cosm.common.service.CodeVO;
import com.prj.cosm.common.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	CommonMapper cdMapper;
	
	@Override
	public List<CodeVO> getCodeList(String cd) {
		// 코드 리스트 찾아오기
		return cdMapper.getCodeList(cd);
	}

}
