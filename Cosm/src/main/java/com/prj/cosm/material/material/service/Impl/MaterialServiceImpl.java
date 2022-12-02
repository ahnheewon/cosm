package com.prj.cosm.material.material.service.Impl;

import java.util.ArrayList;
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
		// 자재정보 단건조회 (상세조회)_업데이트용
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
		// if(사용여부 == null)
		int result = 0;
		for (String no : mNo) {
			result += mMapper.deleteMatrailInfo(no);
		}
		return result;
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
	public int insertMCart(List<MaterialVO> mNo) {
		// 발주 대기 등록(카트)
		int result = 0;
		for (MaterialVO no : mNo) {
			no.setMoNum(no.getTotalPlanedQntt() - (no.getMStock() + no.getTotalMoNum()));
			result += mMapper.insertMcart(no);
		}
		return result;
	}

	@Override
	public int updateOrderNum(List<MaterialVO> mVO) {
		// 발주 수량 수정
		int result = 0;
		for (MaterialVO vo : mVO) {
			result += mMapper.updateOrderNum(vo);
		}
		return result;
	}

	@Override
	public MaterialVO getGrId() {
		// 그룹번호 찾기
		return mMapper.getGrId();
	}

	@Override
	public int updateOrderGo(List<MaterialVO> mVO) {
		// 발주 대기 -> 발주 등록(그룹)

		int result = 0;
		MaterialVO mvo = new MaterialVO();
		String GrNo = mMapper.getGrId().getMoGrNo();
		List<String> strary = new ArrayList<String>();

		for (MaterialVO vo : mVO) {
			strary.add(vo.getMOrderId());
		}

		mvo.setMoGrNo(GrNo);
		mvo.setMoi(strary);
		result = mMapper.updateOrderGo(mvo);
		System.out.println(result + "=====================");
		return result;
	}

	@Override
	public int deleteCartOrder(List<MaterialVO> mVo) {
		// 발주 대기 삭제하기
		// 자재 정보 삭제 - 재고 수량도 삭제됨
		int result = 0;
		for (MaterialVO vo : mVo) {
			result += mMapper.deleteCartOrder(vo);
		}
		return result;
	}

	@Override
	public List<MaterialVO> getOrderProgress(MaterialVO vo) {
		// 발주 진행 현황 찾기
		return mMapper.getOrderProgress(vo);
	}

	@Override
	public int deleteOrder(List<MaterialVO> mVo) {
		// 발주현황 삭제하기
		int result = 0;
		for (MaterialVO vo : mVo) {
			result += mMapper.deleteOrder(vo);
		}
		return result;
	}

	@Override
	public int orderStart(List<MaterialVO> mVO) {
		// 발주 확정하기
		int result = 0;
		for(MaterialVO vo : mVO) {
		result += mMapper.orderStart(vo);
		}
		return result;
	}

	@Override
	public  List<MaterialVO> mioList(MaterialVO mVO) {
		// 자재변동 내역 전체 조회
		return mMapper.mioList(mVO);
	}


	@Override
	public int mioListCount(MaterialVO mVO) {
		// 자재변동 내역 전체 조회_카운트
		return mMapper.mioListCount(mVO);
	}
}
