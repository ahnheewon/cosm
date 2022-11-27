package com.prj.cosm.sales.salesIo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SalesIoService {

	// 완료번호순 정렬
	public int getSalesNo();

	// 전체조회
	public List<SalesIoVO> getSalesIoList();

	// 단건조회
	public SalesIoVO selectSalesInfo(String salesNo);

	// 등록
	public int insertSalesInfo(SalesIoVO vo);

	// 수정
	public int updateSales(SalesIoVO vo);

	// 삭제
	public int deleteSales(@Param("salesNo") int salesNo);
	
	
}
