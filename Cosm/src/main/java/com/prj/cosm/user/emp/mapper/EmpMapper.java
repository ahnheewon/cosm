package com.prj.cosm.user.emp.mapper;

import java.util.List;

import com.prj.cosm.user.emp.service.EmpVO;

public interface EmpMapper {
	// 전체조회
	public List<EmpVO> empSelectList();

	// 조회(로그인)
	public EmpVO empSelect(EmpVO vo);

	// 가입(직원 가입)
	public EmpVO empInsert(EmpVO vo);

	// 수정
	public EmpVO empUpdate(EmpVO vo);

	// 탈퇴
	public EmpVO empDelete(EmpVO vo);

}
