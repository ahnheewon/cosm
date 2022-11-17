package com.prj.cosm.material.material.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.material.material.mapper.MaterialMapper;
import com.prj.cosm.material.material.service.MaterialService;
import com.prj.cosm.material.material.service.MaterialVO;

@Service
public class MaterailServiceImpl implements MaterialService {

	@Autowired
	MaterialMapper mMapper;

	@Override
	public List<MaterialVO> mList() {
		// 자재정보 전체조회
		return mMapper.mList();
	}

	@Override
	public MaterialVO selectInfo(String mno) {
		// 자재정보 단건조회 (상세조회)
		return mMapper.selectInfo(getComId());
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

	/*@Override
	public MaterialVO getMno() {
		// 자재번호 조회하기
		return mMapper.getMno();
	}
*/
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

	
}
