package com.prj.cosm.material.material.service;

import java.util.List;


public interface MaterialService {
	
	// 자재정보 전체조회
	public List<MaterialVO> mList(); 
	// 자재정보 단건조회 (상세조회) 
	public MaterialVO selectInfo(String mno);
	
	// 신규 자재 정보 등록
	public int insertMatarialInfo(MaterialVO mVO);
	// 자재 정보 수정 
	public int updateMatrailInfo(MaterialVO mVO);
	// 자재 정보 삭제 - 재고 수량도 삭제됨
	public int deleteMatrailInfo(List<String> mNo);
	
	// 날짜로 자재 검색
	
	// 자재명으로 자재 검색
	
	// 최종 수정일로 자재 변동 검색
	
	// 자재 변동 리스트 전체 조회
	public List<MaterialVO> mioList(); 
	
	// 거래처 명 찾기
	public List<MaterialVO> findComNm();
	
	// 신규 거래처 등록
	public int registerMCompany(MaterialVO mVO); 
	
	// 거래처번호 조회
	public MaterialVO getComId();
		
		
	
}
