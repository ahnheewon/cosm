package com.prj.cosm.produce.regist.mapper;

import java.util.List;
import java.util.Map;

import com.prj.cosm.produce.instruct.service.InsVO;
import com.prj.cosm.produce.regist.service.RegistVO;

public interface RegistMapper {

	public List<Map<String, Object>> getRegistList();

	// 완제품 전체조회(모두)
	public List<Map<String, Object>> completeList(RegistVO vo);

	// 불량품 조회
	public List<Map<String, Object>> errorList(RegistVO vo);

	public RegistVO getRegistLOT();

	public RegistVO getRegistLabel();

	public int insertRegist(RegistVO registVO);

	public int deleteRegist(String registLOT);

	// 진행, 단위코드 리스트
	public List<RegistVO> getPlayList();

	public List<RegistVO> getUnitList();

	// 주문서 상태 업데이트
	public void updateOrderInfo(InsVO insVO);

	// 메인페이지 생산량
	public List<RegistVO> getQuantity();
}
