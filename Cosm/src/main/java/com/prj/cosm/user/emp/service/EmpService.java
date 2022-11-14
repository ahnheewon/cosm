package com.prj.cosm.user.emp.service;

import java.util.List;

public interface EmpService {
	// 전체조회
	public List<EmpVO> empSelectList();

	// 조회(로그인)
	public EmpVO empSelect(EmpVO vo);

	// 가입(직원)
	public EmpVO empInsert(EmpVO vo);

	// 수정
	public EmpVO empUpdate(EmpVO vo);

	// 탈퇴
	public EmpVO empDelete(EmpVO vo);

}
