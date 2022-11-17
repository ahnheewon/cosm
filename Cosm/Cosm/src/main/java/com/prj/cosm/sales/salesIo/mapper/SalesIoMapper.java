package com.prj.cosm.sales.salesIo.mapper;

import java.util.List;

import com.prj.cosm.sales.salesIo.service.SalesIoVO;

public interface SalesIoMapper {
//완제품 출납관리
	
	//진행완료순? 정렬
	
	//전체조회
	public List<SalesIoVO> inoutList();
	
	//등록
	public SalesIoVO insertInfo(SalesIoVO vo);	
}
