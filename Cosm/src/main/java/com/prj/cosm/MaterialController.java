package com.prj.cosm;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.prj.cosm.common.service.CommonService;
import com.prj.cosm.common.service.FileRenamePolicy;
import com.prj.cosm.common.service.FileUtil;
import com.prj.cosm.material.material.service.MaterialService;
import com.prj.cosm.material.material.service.MaterialVO;
import com.prj.cosm.material.morder.service.MorderService;
import com.prj.cosm.material.morder.service.MorderVO;

import lombok.extern.log4j.Log4j2;

@Controller
@CrossOrigin("*")
@Log4j2
public class MaterialController {

	/*---------------------------
	// 자재 정보, 재고 변동
	// 발주 대기 등록, 발주 현황
	----------------------------*/
	@Autowired
	MaterialService mService;

	/*--------------------
	// 입, 출고 리스트
	---------------------*/
	@Autowired
	MorderService moSerivce;

	/*--------------------
	// 공통코드 
	---------------------*/
	@Autowired
	CommonService coService;

	
	// 파일 업로드 경로
	@Value("${file.path}") // application.properties에 선언해놓고 가져올 수 있음. 나중에 여기서 경로 변경하기
	String path;
	 
	
	 
	// 첫 화면
	@RequestMapping("/material/main") 
	public String main() {
		return "/material/main";
	}

	// 자재 정보 등록폼 (이동)
	@GetMapping("/material/minsert")
	public String mInsertForm(MaterialVO mVO, Model model) {
		model.addAttribute("category", coService.getCodeList("H01"));
		model.addAttribute("unit", coService.getCodeList("F01"));

		return "material/mInfoInsert";
	}

	// 자재 정보 등록창 (실행)_multipart (파일업로드)

	@PostMapping("/material/minsert")
	public String mInsert(MaterialVO mVO, Model model, MultipartFile imageFile) throws IllegalStateException, IOException {
		
		if(imageFile != null && imageFile.getSize() >0) {
			//첨부파일 처리
			
			String fName = imageFile.getOriginalFilename(); // 이미지 실제 이름
			
			File file = new File(path, fName);			
			file = FileRenamePolicy.rename(file); // 파일 중복 검사
			
			imageFile.transferTo(file); // 파일을 폴더로 옮겨줌
			mVO.setMFile(file.getName());
		}
		
		mService.insertMatarialInfo(mVO);
		//  
		return "redirect:/material/minfo"; // 목록으로 돌아가기
	}

	// 파일 다운
	@GetMapping("/material/filedown")
	public void fileDown (String fname, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FileUtil.fileDownload(path + fname, request, response); // path는 application.properties에 선언되어있음
	}
	
	
	// 거래처 이름 찾기
	@ResponseBody
	@GetMapping("/material/ajax/getComNm")
	public List<MaterialVO> findComNm() {
		return mService.findComNm();
	}

	// 신규거래처 등록 페이지 이동
	@GetMapping("/material/mregcom")
	public String mRegComForm(Model model) {
		// 등록할 거래처 시퀀스 조회
		model.addAttribute("comId", mService.getComId().getMCompanyId());	
		return "material/mRegCom";

	}

	// 신규거래처 등록 실행
	@PostMapping("/material/mregcom")
	public void mRegCom(MaterialVO mvo, Model model, HttpServletResponse resp) throws IOException {
		// 팝업창 닫기
		try {
			mService.registerMCompany(mvo);
			resp.setContentType("text/html");
			resp.getWriter().append("<script>\r\n" + "	window.close() \r\n" + "</script>");
			
		} catch (IOException e) {
			resp.sendRedirect("minsert"); // 모달용 에러페이지 만들어서 그 페이지로 이동

			e.printStackTrace();
		}

	}

	// 자재 정보 리스트, 재고 변동현황
	
	@ResponseBody
	@GetMapping("/material/ajax/minfo")
	public Map<String, Object> mInfoList(MaterialVO mVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list1", mService.mList()); // 자재정보리스트
		
		return map;
	}
	
	@ResponseBody
	@GetMapping("/material/mioMain")
	public Map<String, Object> mioMain(MaterialVO mvo){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("main", mService.mioListMain(mvo));
		
		return map;
	}
	
	
	
	// 페이지네이션
	@ResponseBody
	@RequestMapping(value="/material/ajax/mioList")
	public Map<String, Object> mioPageMap(MaterialVO mVO) {
		Map<String, Object> pagination = new HashMap<String, Object>();
		pagination.put("page", mVO.getPage());
		pagination.put("totalCount", mService.mioListCount(mVO)); // 데이터 갯수 세는 쿼리
		
		Map<String, Object>  gridData = new HashMap<String, Object>();
		gridData.put("pagination", pagination); 
		gridData.put("contents", mService.mioList(mVO));
		
		Map<String, Object>  result = new HashMap<String, Object>();
		result.put("result", true);
		result.put("data", gridData);
		
		return result;
	}
	
	
	
	

	@GetMapping("/material/minfo")
	public String mInfoPage(MaterialVO vo, Model model) {
		return "material/material";
	}

	// 자재 정보 상세조회(단건)
	@ResponseBody
	@GetMapping("/material/mInfoView")
	public MaterialVO selectInfo(MaterialVO vo) {
		return mService.selectInfo(vo); // ajax의 데이터를 보여줘야기때문에 데이터로 return
	}

	// 자재 정보 수정(이동)
	@GetMapping("/material/mUpdate")
	public String modifyMatForm(MaterialVO vo, Model model) {
		model.addAttribute("category", mService.getCategoryList());
		model.addAttribute("unit", mService.getUnitList());
		model.addAttribute("vo", mService.selectInfoMat(vo));
		return "material/mInfoUpdate"; // redirect:mUpdate 시, model 값을 가져가지않음 (*)
	}

	// 자재 정보 수정(처리)
	@PostMapping("/material/mUpdate")
	public String modifyMat(MaterialVO vo, MultipartFile imageFile) throws IllegalStateException, IOException {
		
		if(imageFile != null && imageFile.getSize() >0) {
			//첨부파일 처리
			
			String fName = imageFile.getOriginalFilename(); // 이미지 실제 이름
			
			File file = new File(path, fName);			
			file = FileRenamePolicy.rename(file); // 파일 중복 검사
			
			imageFile.transferTo(file); // 파일을 폴더로 옮겨줌
			vo.setMFile(fName);
		}
		
		mService.updateMatrailInfo(vo);
		return "redirect:/material/minfo";

	}

	// 자재 정보 삭제 => 동시에 삭제됨
	@ResponseBody
	@PostMapping("/material/mdelinfo") // requestBody 는 웬만한 값 다 넘겨줄수 있음.(여기서는 배열 넘길때 씀)
	public int mDeleteInfo(@RequestBody MaterialVO vo) {

		return mService.deleteMatrailInfo(vo.getDelmno());

	}

	/*------------------------------------------------------*/

	// 발주 대기 리스트 조회, 발주 현황 리스트 조회

	@ResponseBody
	@GetMapping("/material/ajax/morder")
	public Map<String, Object> mCartListAjax(MaterialVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list1", mService.mCartList()); // 발주 대기 리스트
		map.put("list2", mService.getOrderProgress(vo)); // 발주 현황 리스트

		return map;
	}

	// 발주 대기 등록 ajax
	@ResponseBody
	@PostMapping("/material/ajax/mcart")
	public int mCartinsert(@RequestBody List<MaterialVO> mvo) {
		return mService.insertMCart(mvo);
	}

	// 발주 대기 페이지 이동
	@GetMapping("/material/mcart")
	public String mCartList(MaterialVO vo, Model model) {
		return "material/mOrder";
	}

	/* 발주 수량 업데이트 ajax */
	@ResponseBody
	@PostMapping("/material/updateMoNum")
	public int updateMnum(@RequestBody List<MaterialVO> mvo) {
		return mService.updateOrderNum(mvo);
	}

	/* 발주 대기 -> 발주 현황으로 이동 ajax */
	@ResponseBody
	@PostMapping("/material/updateOrder")
	public int updateOrderGo(@RequestBody List<MaterialVO> mvo) {
		return mService.updateOrderGo(mvo);
	}

	// 발주 대기 삭제 ajax
	@ResponseBody
	@PostMapping("/material/ajax/delcart") // requestBody 는 웬만한 값 다 넘겨줄수 있음.(여기서는 배열 넘길때 씀)
	public int mDeleteCart(@RequestBody List<MaterialVO> vo) {

		return mService.deleteCartOrder(vo);

	}

	// 발주 확정 ajax
	@ResponseBody
	@PostMapping("/material/orderStart")
	public int orderStart(@RequestBody List<MaterialVO> vo) {
		return mService.orderStart(vo);

	}

	// 발주현황 삭제
	@ResponseBody
	@PostMapping("/material/delorder")
	public int delOrderCheck(@RequestBody List<MaterialVO> vo) {
		return mService.deleteOrder(vo);

	}

	/* ======================================================= */

	// 입고, 출고 리스트
	@ResponseBody
	@GetMapping("/material/ajax/miolist")
	public Map<String, Object> mioList(MorderVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list1", moSerivce.mioInputList(vo)); // 입고리스트
		map.put("list2", moSerivce.mioOutputList(vo)); // 출고리스트

		return map;
	}

	// 입고, 출고 리스트 페이지
	@GetMapping("/material/miolist")
	public String mioPage(MorderVO mvo, Model model) {
		return "material/mioList";
	}

	// 입고 대기 리스트
	@ResponseBody
	@GetMapping("/material/ajax/stanby")
	public List<MorderVO> stanbyList() {
		return moSerivce.getStandbyList();
	}

	// 입고 확정 ajax

	/* 입고 대기 -> 입고 목록으로 이동 ajax */
	@ResponseBody
	@PostMapping("/material/updateInput")
	public int updateinputOrder(@RequestBody List<MorderVO> mvo) {

		return moSerivce.insertInputOrder(mvo);

	}

	// 입고 확정 시 현재 수량 변경
	@ResponseBody
	@PostMapping("/material/updateMStock")
	public int updateMStock(@RequestBody MorderVO mvo) {
		return moSerivce.updateMStock(mvo);
	}

}