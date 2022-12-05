package com.prj.cosm.sales.salesIo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prj.cosm.sales.salesIo.service.SalesIoVO;

public interface SalesIoMapper {
//완제품 출납관리

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

	// 출고 - 수정
	public int updateOutInfo(List<SalesIoVO> list);

	// 삭제 - 체크박스, 여러조건 일때 vo로 받아야하는지?
	public int delOutOrder(List<SalesIoVO> vo);

	// 출고내역 리스트 인데 .. 안쓸거같음
	// 1.update 2.resetdata 3.resetdate = 정보는 1개 update됨, update된걸 따로 보겠다.
	public int outList(List<SalesIoVO> vo);

}
