package com.prj.cosm.user.emp.service;

import java.util.List;

public interface EmpService {
	// 전체조회
	public List<EmpVO> empSelectList();

	// 조회(로그인)
	public EmpVO empSelect(String usersId);

	// 상세조회
	public EmpVO userInfoSelect(String usersNo);

	// 가입(직원)
	public int userInsert(EmpVO vo);

	// 수정
	public int userUpdate(EmpVO vo);

	// 탈퇴
	public int userDelete(EmpVO vo);

	// 사원 권한 리스트
	public List<String> getAuthorList();

	// 아이디 중복 조회
	public int checkId(String id);
}
