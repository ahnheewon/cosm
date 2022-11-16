package com.prj.cosm.sales.salesIo.service;

import java.util.List;

public interface SalesIoService {

	//전체조회
		public List<SalesIoVO> inoutList();
		
		//등록
		public SalesIoVO insertInfo(SalesIoVO vo);	
}
