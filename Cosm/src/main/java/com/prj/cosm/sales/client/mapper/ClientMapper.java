package com.prj.cosm.sales.client.mapper;

import java.util.List;

import com.prj.cosm.sales.client.service.ClientVO;

public interface ClientMapper {
	// 고객
	// 고객 - 등록(회원가입)
	public int clientIn(ClientVO cvo);

	// 마이페이지 - 조회
	public List<ClientVO> myInfo(ClientVO cvo);

	// 마이페이지 - 수정
	public int updateMy(ClientVO cvo);

	// 마이페이지 - 삭제 = 탈퇴
	public int deleteMy(ClientVO cvo);

	// 주문조회
	public List<ClientVO> getOrderList(ClientVO cvo);

	// 주문등록
	public int insertOrder(ClientVO cvo);
}
