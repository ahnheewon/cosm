package com.prj.cosm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.equipment.equip.service.EquipService;
import com.prj.cosm.equipment.equip.service.EquipVO;
import com.prj.cosm.material.material.service.MaterialService;
import com.prj.cosm.material.material.service.MaterialVO;
import com.prj.cosm.produce.bom.service.BomService;
import com.prj.cosm.produce.bom.service.BomVO;
import com.prj.cosm.produce.goods.service.GoodsService;
import com.prj.cosm.produce.goods.service.GoodsVO;
import com.prj.cosm.produce.instruct.service.InsService;
import com.prj.cosm.produce.instruct.service.InsVO;
import com.prj.cosm.produce.plan.service.PlanService;
import com.prj.cosm.produce.plan.service.PlanVO;
import com.prj.cosm.produce.regist.service.RegistService;
import com.prj.cosm.produce.regist.service.RegistVO;
import com.prj.cosm.sales.client.service.ClientService;
import com.prj.cosm.sales.orders.service.OrdersService;
import com.prj.cosm.sales.orders.service.OrdersVO;

@Controller
@CrossOrigin("*")
public class MainController {

	

	@Autowired
	OrdersService oService;

	@Autowired
	EquipService eService;

	@Autowired
	MaterialService mService;

	@Autowired
	PlanService planService;

	@Autowired
	InsService insService;

	@Autowired
	RegistService registService;

	@Autowired
	ClientService cService;

	@Autowired
	BomService bomService;

	@Autowired
	GoodsService goodsService;

	// 첫 화면
	@RequestMapping("/")
	public String main() {
		return "/equipment/main";
	}

	//
	@RequestMapping("/equipment/main")
	public String equipmentMain() {
		return "/equipment/main";
	}

	// pno, eno 값뿌리기.
	@RequestMapping("/equipment/process")
	public String equipmentProgress(Model model) {

		model.addAttribute("pno", eService.getProcessNo().getProcessNo());
		model.addAttribute("eno", eService.getEquipNo().getEquipNo());
		model.addAttribute("ep", eService.getProcessList());
		model.addAttribute("epFirst", eService.getProcessList());

		return "/equipment/process";
	}

	// 공정 전체 리스트 조회 데이터
	@GetMapping("/equipment/processList")
	@ResponseBody
	public List<EquipVO> progress() {

		return eService.getProcessList();
	}

	// 공정 등록
	@PostMapping("/equipment/insertProcess")
	public String insertProcess(EquipVO vo, RedirectAttributes ratt) {
		Map<String, Object> result = eService.insertProcess(vo);
		ratt.addFlashAttribute("msg", result.get("result") + "건이 등록되었습니다.");
		return "redirect:/equipment/process";
	}

	// 설비 전체 리스트 조회 데이터
	@GetMapping("/equipment/equipList")
	@ResponseBody
	public List<EquipVO> equip() {

		return eService.getEquipList();
	}

	// 설비 등록 (설비별 가동시간도 함께 등록이 돼요!)
	@PostMapping("/equipment/insertEquip")
	public String insertEquip(EquipVO vo) {
		eService.insertEquip(vo);
		return "redirect:/equipment/process";
	}

	// 설비 단건 조회
	@GetMapping("/equipment/getEquipInfo")
	@ResponseBody
	public EquipVO getEquipInfo(Model model, int equipNo) {
		return eService.getEquipInfo(equipNo);

	}

	// 설비 수정!!!
	@PostMapping("/equipment/updateEquip")
	@ResponseBody
	public String updateEquip(EquipVO vo) {
		eService.updateEquip(vo);
		return "redirect:/equipment/process";
	}

	// 공정 단건 조회
	@GetMapping("/equipment/getProcessInfo")
	@ResponseBody
	public EquipVO getProcessInfo(Model model, int processNo) {
		return eService.getProcessInfo(processNo);

	}


	// 영업 start =======================================================
	// 고객 주문목록 페이지
	@RequestMapping("/coder")
	public List<OrdersVO> client(Model model) {
		return oService.salesOrderList();
	}

	// 고객 - 첫 화면
	@RequestMapping("/cmain")
	public String cilentorder(Model model) {
		return "client/order";
	}

	// 주문 등록창
	@PostMapping("insert")
	public String cinsert(OrdersVO vo, RedirectAttributes ratt) {
		oService.insertOrder(vo);
		return "client/insert"; // 목록으로 돌아가기
	}

	// 고객 - 주문목록데이터
	@RequestMapping("/orderList")
	@ResponseBody
	public List<OrdersVO> clientorderList(Model model) {
		model.addAttribute("id", oService.getOrderNo());
		return oService.salesOrderList();
	}

	// 고객 주문관리 메인
	@RequestMapping("/insert")
	public String clientOrder(Model model) {
		return "client/insert";
	}

	// 마이페이지
	@RequestMapping("/my")
	public String clientMypage(Model model) {
		return "client/myPage";
	}

	// 영업팀 -----------------------------------
	// 영업 - 주문조회 리스트
	@ResponseBody
	@GetMapping("/ajax/orders") // url
	public List<OrdersVO> ajaxOrder(Model model) {
		return oService.salesOrderList();
	}

	// 체크박스 단건 삭제 - 영업
	@ResponseBody
	@PostMapping("/ajax/delcheckOrder") // requestBody 는 웬만한 값 다 넘겨줄수 있음.(여기서는 배열 넘길때 씀)
	public int delCheckOrder(@RequestBody OrdersVO vo) {
		// System.out.println(vo.getDelmno()+"=================>>>>>>>>>>>>>>");
		return oService.deleteCheck(vo.getNoList());
	}

	// 체크박스 -> 생산요청 상태변경
	@ResponseBody
	@PostMapping("a/upPro")

	@RequestMapping("/test")
	public String test(Model model) {
		return "sales/test";
	}

	// 메인페이지 - 주문관리
	@GetMapping("/orders")
	public String salesorder(Model model) {
		return "sales/orders";
	}

	// 사원 - 주문목록데이터
	@GetMapping("/ordersList")
	@ResponseBody
	public List<OrdersVO> salesorderList(Model model) {
		model.addAttribute("id", oService.getOrderNo());
		return oService.salesOrderList();
	}

	/* main - 주문목록조회 = ajax, get */

	// 영업 end =======================================================

	// 자재팀 영역

	// 자재 정보 등록폼
	@GetMapping("minsert")
	public String mInsertForm(Model model) {
		// model.addAttribute("mno",mService.getMno().getMNo());
		return "material/mInfoInsert";
	}


	// 자재 정보 등록창
	@PostMapping("minsert")
	public String mInsert(MaterialVO mVO, RedirectAttributes ratt) {
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

	// 신규거래처 등록창
	@PostMapping("mregcom")
	public String mRegCom(MaterialVO mvo) {
		System.out.println("거래처번호 : " + mvo);
		mService.registerMCompany(mvo);
		return "material/mInfoInsert";
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
	public String mInfoPage() {
		return "material/material";
	}

	// 자재 정보 상세 조회(단건)
//		@ResponseBody
//		@GetMapping("/ajax/mInfoView")
//		public String selectInfo(@RequestParam String mno, Model model) {
//			model.addAttribute("mInfo", mService.selectInfo(mno));
//			return "material/mInfoView";			
//		
//		}
//		
	@ResponseBody
	@GetMapping("/ajax/mInfoView")
	public MaterialVO selectInfo(@RequestBody MaterialVO vo) {
		return mService.selectInfo(vo.getMNo());
	}

	// 자재 정보 수정
	@GetMapping("/mupdate/{mno}")
	public String edit(@PathVariable("mno") String mno, Model model) {
		MaterialVO mvo = mService.selectInfo(mno);
		model.addAttribute("material", mvo);
		return "material/mInfoUpdate";
	}

	// 자재 정보 삭제 => 동시에 삭제됨
	@ResponseBody
	@PostMapping("/ajax/mdelinfo") // requestBody 는 웬만한 값 다 넘겨줄수 있음.(여기서는 배열 넘길때 씀)
	public int mDeleteInfo(@RequestBody MaterialVO vo) {
		return mService.deleteMatrailInfo(vo.getDelmno());
	}

	
}
