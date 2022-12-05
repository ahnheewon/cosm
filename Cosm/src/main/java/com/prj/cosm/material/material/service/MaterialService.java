package com.prj.cosm.material.material.service;

import java.util.List;
import java.util.Map;


public interface MaterialService {

	// 자재정보 전체조회
	public List<MaterialVO> mList();

	// 자재정보 단건조회 (상세조회)
	public MaterialVO selectInfo(MaterialVO mVO);

	// 신규 자재 정보 등록
	public int insertMatarialInfo(MaterialVO mVO);

	// 자재 정보 조회
	public MaterialVO selectInfoMat(MaterialVO mVO);

	// 자재 정보 수정
	public int updateMatrailInfo(MaterialVO mVO);

	// 자재 정보 삭제 - 재고 수량도 삭제됨
	public int deleteMatrailInfo(List<String> mNo);

	// 자재 변동 리스트 전체 조회 (메인)
	public List<MaterialVO> mioListMain(MaterialVO mVO);
	
	// 자재 변동 리스트 전체 조회
	public List<MaterialVO>mioList (MaterialVO mVO);
	
	
	// 자재 변동 리스트 전체조회_카운트
    public int mioListCount(MaterialVO mVO);	
    

	// 거래처 명 찾기
	public List<MaterialVO> findComNm();

	// 신규 거래처 등록
	public int registerMCompany(MaterialVO mVO);

	// 거래처번호 조회
	public MaterialVO getComId();

	// 단위 코드 조회
	public List<MaterialVO> getUnitList();

	// 자재분류 코드 조회
	public List<MaterialVO> getCategoryList();

	// 발주 현황 리스트 전체조회
	public List<MaterialVO> mOrderList();

	// 발주 대기 리스트 전체조회
	public List<MaterialVO> mCartList();

	// 발주 대기 등록 (카트)
	public int insertMCart(List<MaterialVO> mNo);

	// 발주 수량 수정
	public int updateOrderNum(List<MaterialVO> mVO);

	// 발주 대기 -> 발주 등록 실행 (다건 그룹화)
	public int updateOrderGo(List<MaterialVO> mVO);

	// 그룹번호 찾기
	public MaterialVO getGrId();

	// 발주 대기 삭제
	public int deleteCartOrder(List<MaterialVO> mVo);

	// 발주 진행 현황 찾기
	public List<MaterialVO> getOrderProgress(MaterialVO vo);
	
	// 발주 현황 삭제
	public int deleteOrder(List<MaterialVO> mVo);
	
	// 발주 확정(실행)
	public int orderStart(List<MaterialVO> mVO);

}
