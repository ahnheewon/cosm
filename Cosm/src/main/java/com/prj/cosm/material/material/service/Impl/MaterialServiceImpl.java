package com.prj.cosm.material.material.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.material.material.mapper.MaterialMapper;
import com.prj.cosm.material.material.service.MaterialService;
import com.prj.cosm.material.material.service.MaterialVO;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialMapper mMapper;

	@Override
	public List<MaterialVO> mList() {
		// 자재정보 전체조회
		return mMapper.mList();
	}

	@Override
	public MaterialVO selectInfo(MaterialVO mVO) {
		// 자재정보 단건조회 (상세조회)
		return mMapper.selectInfo(mVO);
	}
	
	@Override
	public MaterialVO selectInfoMat(MaterialVO mVO) {
		//  자재정보 단건조회 (상세조회)_업데이트용
		return mMapper.selectInfoMat(mVO);
	}

	@Override
	public int insertMatarialInfo(MaterialVO mVO) {
		// 신규 자재 정보 등록
		return mMapper.insertMatarialInfo(mVO);
	}

	@Override
	public int updateMatrailInfo(MaterialVO mVO) {
		// 자재 정보 수정
		return mMapper.updateMatrailInfo(mVO);
	}

	@Override
	public int deleteMatrailInfo(List<String> mNo) {
		// 자재 정보 삭제 - 재고 수량도 삭제됨
		int result = 0;
		for (String no : mNo) {
			result += mMapper.deleteMatrailInfo(no);
		}
		return result;
	}

	@Override
	public List<MaterialVO> mioList() {
		// 자재 변동 리스트 전체 조회
		return mMapper.mioList();
	}

	@Override
	public List<MaterialVO> findComNm() {
		// 거래처 명 찾기
		return mMapper.findComNm();
	}



	@Override
	public int registerMCompany(MaterialVO mVO) {
		// 신규거래처 등록
		return mMapper.registerMCompany(mVO);
	}

	@Override
	public MaterialVO getComId() {
		// 거래처 번호 조회
		return mMapper.getComId();
	}


	@Override
	public List<MaterialVO> getUnitList() {
		// 단위 코드 조회(select option)
		return mMapper.getUnitList();
	}

	@Override
	public List<MaterialVO> getCategoryList() {
		// 자재 분류 조회(select option)
		return mMapper.getCategoryList();
	}

	@Override
	public List<MaterialVO> mOrderList() {
		// 발주 현황 리스트
		return mMapper.mOrderList();
	}

	@Override
	public List<MaterialVO> mCartList() {
		// 발주 대기 리스트
		return mMapper.mCartList();
	}

	@Override
	public int insertMCart(List<String> mNo) {
		// 발주 대기 등록(카트)
		int result = 0;
		for (String no : mNo) {
			result += mMapper.insertMcart(no);
		}
		return result;		
	}


	
}
