package com.prj.cosm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prj.cosm.material.material.service.MaterialService;
import com.prj.cosm.material.material.service.MaterialVO;
import com.prj.cosm.material.morder.service.MorderService;
import com.prj.cosm.material.morder.service.MorderVO;

import lombok.extern.log4j.Log4j2;

@Controller
@CrossOrigin("*")
@Log4j2
public class MaterialController {

	// 자재 정보, 재고 변동
	// 발주 대기 등록, 발주 현황
	@Autowired
	MaterialService mService;

	// 입, 출고 리스트
	@Autowired
	MorderService moSerivce;

	/*
	 * =============================================================================
	 * ==================
	 */

	// 자재 정보 등록폼 (이동)
	@GetMapping("minsert")
	public String mInsertForm(MaterialVO mVO, Model model) {
		model.addAttribute("category", mService.getCategoryList());
		model.addAttribute("unit", mService.getUnitList());
		// MaterialVO mno =mService.getMno();
		// model.addAttribute("mno", mno.getMNo());

		// System.out.println("자재번호 값이 맞나여?" + mno.getMNo());
		return "material/mInfoInsert";
	}

	// 자재 정보 등록창 (실행)
	@PostMapping("minsert")
	public String mInsert(MaterialVO mVO, Model model) {
		mService.insertMatarialInfo(mVO);

		return "material/material"; // 목록으로 돌아가기
	}

	// 거래처 이름 찾기
	@ResponseBody
	@GetMapping("/ajax/minsert")
	public List<MaterialVO> findComNm() {
		return mService.findComNm();
	}

	// 신규거래처 등록폼
	@GetMapping("mregcom")
	public String mRegComForm(Model model) {
		model.addAttribute("comId", mService.getComId().getMCompanyId());
		System.out.println("넘기는 값" + model.addAttribute("comId", mService.getComId().getMCompanyId()));
		return "material/mRegCom";

	}

	// 신규거래처 등록 실행
	@PostMapping("mregcom")
	public String mRegCom(MaterialVO mvo, Model model) {
		mService.registerMCompany(mvo);

		return "redirect:minsert";

	}

	// 자재 정보 리스트, 재고 변동현황
	@ResponseBody
	@GetMapping("/ajax/minfo")
	public Map mInfoList() {
		Map<String, Object> map = new HashMap();
		map.put("list1", mService.mList()); // 자재정보리스트
		map.put("list2", mService.mioList()); // 재고 변동 현황

		return map;
	}

	@GetMapping("minfo")
	public String mInfoPage(MaterialVO vo, Model model) {
		return "material/material";
	}

	// 자재 정보 상세조회(단건)
	@ResponseBody
	@GetMapping("/ajax/mInfoView")
	public MaterialVO selectInfo(MaterialVO vo) {
		return mService.selectInfo(vo); // ajax의 데이터를 보여줘야기때문에 데이터로 return
	}

	// 자재 정보 수정(이동)
	@GetMapping("/mUpdate")
	public String modifyMatForm(MaterialVO vo, Model model) {
		model.addAttribute("category", mService.getCategoryList());
		model.addAttribute("unit", mService.getUnitList());
		model.addAttribute("vo", mService.selectInfoMat(vo));
		return "material/mInfoUpdate"; // redirect:mUpdate 시, model 값을 가져가지않음 (*)
	}

	// 자재 정보 수정(처리)
	@PostMapping("/mUpdate")
	public String modifyMat(MaterialVO vo) {
		mService.updateMatrailInfo(vo);
		return "material/material";

	}

	// 자재 정보 삭제 => 동시에 삭제됨
	@ResponseBody
	@PostMapping("/ajax/mdelinfo") // requestBody 는 웬만한 값 다 넘겨줄수 있음.(여기서는 배열 넘길때 씀)
	public int mDeleteInfo(@RequestBody MaterialVO vo) {

		return mService.deleteMatrailInfo(vo.getDelmno());

	}

	// 입고, 출고 리스트
	@ResponseBody
	@GetMapping("/ajax/miolist")
	public Map mioList() {
		Map<String, Object> map = new HashMap();
		map.put("list1", moSerivce.mioInputList()); // 입고리스트
		map.put("list2", moSerivce.mioOutputList()); // 출고리스트

		return map;
	}

	@GetMapping("miolist")
	public String mioPage(MorderVO mvo, Model model) {
		return "material/mioList";
	}

	/*
	 * =============================================================================
	 * 
	 */



	// 발주 대기 리스트 조회, 발주 현황 리스트 조회

	@ResponseBody
	@GetMapping("/ajax/mOrder")
	public Map mCartList() {
		Map<String, Object> map = new HashMap();
		map.put("list1", mService.mCartList()); // 발주 대기 리스트
		map.put("list2", mService.mOrderList()); // 발주 현황 리스트

		return map;
	}

	
	// 발주 대기 등록 ajax
	@ResponseBody
	@PostMapping("/ajax/mOrder")
	public int mCartList(@RequestBody MaterialVO mvo) {
		return mService.insertMCart(mvo.getOdMno());
	}

	

}
