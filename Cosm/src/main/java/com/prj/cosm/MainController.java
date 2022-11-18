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
import com.prj.cosm.sales.orders.service.OrdersService;
import com.prj.cosm.sales.orders.service.OrdersVO;
import com.prj.cosm.user.emp.service.EmpService;
import com.prj.cosm.user.emp.service.EmpVO;

@Controller
@CrossOrigin("*")
public class MainController {

	@Autowired
	EmpService service;

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

	// 첫 화면
	@GetMapping("/main")
	public String main(Model model) {
		return "/index";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "/users/client/joinForm";
	}

	@GetMapping("/top")
	public String top() {
		return "/top";
	}

	@GetMapping("/userList")
	public String empList(Model model) {
		model.addAttribute("authorList", service.getAuthorList());
		return "/users/emp/empList";
	}

	@GetMapping("/clientList")
	public String clientList(Model model) {
		model.addAttribute("authorList", service.getAuthorList());
		return "/users/emp/empList";
	}

	@GetMapping("/getUserList")
	@ResponseBody
	public List<EmpVO> getUserList() {
		return service.empSelectList();
	}

	@PostMapping("/userSelect")
	@ResponseBody
	public EmpVO userSelect(String usersNo) {
		return service.userInfoSelect(usersNo);
	}

	@PostMapping("userInsert")
	public String empInsert(EmpVO empVO) {
		service.userInsert(empVO);
		return "redirect:userList";
	}

	@PostMapping("userUpdate")
	public String empUpdate(EmpVO empVO) {
		service.userUpdate(empVO);
		return "redirect:userList";
	}

	@PostMapping("userDelete")
	@ResponseBody
	public int userDelete(EmpVO empVO) {
		return service.userDelete(empVO);
	}

	@GetMapping("/userInfo")
	public String userInfo() {
		return "/users/userInfo";
	}

//	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	@GetMapping("/userCheckId")
	@ResponseBody
	public int userCheckId(String usersId) {
		return service.checkId(usersId);
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

	// =============================생산관리=======================
	// 생산계획 list에 ajax주는 것
	@GetMapping("/plan")
	@ResponseBody
	public List<PlanVO> plan() {
		return planService.selectPlanList();
	}

	// 생산계획 list 화면페이지 plan_no값 넘겨줌
	@GetMapping("/planList")
	public String planList(Model model) {
		model.addAttribute("info", planService.selectPlanNo());
		return "produce/planList";
	}

	// 생산계획 등록
	@PostMapping("planInsert")
	public String insertPlanInfo(PlanVO planVO) {
		planService.insertPlanInfo(planVO);
		return "redirect:planList";
	}

	// 생산계획 수정
	@PostMapping("planUpdate")
	public String updatePlanInfo(PlanVO planVO, RedirectAttributes ratt) {
		int result = planService.updatePlanInfo(planVO);

		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:planList";
	}

	// 생산계획 삭제
	@GetMapping("planDelete")
	public String deletePlanInfo(int planNo, RedirectAttributes ratt) {
		int result = planService.deletePlanInfo(planNo);

		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 삭제되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 삭제되지 않았습니다.");
		}
		return "redirect:planList";
	}

	// 생산지시 list에 ajax주는 것
	@GetMapping("/instruct")
	@ResponseBody
	public List<Map<String, Object>> instruct() {
		return insService.selectInsList();
	}

	// 생산지시 페이지이동
	@GetMapping("/instructList")
	public String instructList(Model model) {
		model.addAttribute("info", insService.selectInsNo());
		return "produce/instructList";
	}

	// 생산지시 등록
	@PostMapping("insInsert")
	public String insertInsInfo(InsVO insVO) {
		insService.insertInsInfo(insVO);
		return "redirect:instructList";
	}

	// 생산지시 수정
	@PostMapping("insUpdate")
	public String updateInsInfo(InsVO insVO, RedirectAttributes ratt) {
		int result = insService.updateInsInfo(insVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:instructList";
	}

	// 생산지시 삭제
	@GetMapping("insDelete")
	@ResponseBody
	public int deleteInsInfo(int instructNo, RedirectAttributes ratt) {
		return insService.deleteInsInfo(instructNo);
	}

	// 완제품 페이지 이동
	@GetMapping("/regist")
	public String regist(Model model) {
		model.addAttribute("info", registService.selectRegistLOT());
		model.addAttribute("label", registService.selectRegistLabel());
		return "/produce/regist";
	}

	// 완제품 list에 ajax주는 것
	@GetMapping("/registList")
	@ResponseBody
	public List<Map<String, Object>> regist() {
		return registService.selectRegistList();
	}

	// 완제품 등록
	@PostMapping("registInsert")
	public String insertRegistInfo(RegistVO registVO) {
		registService.insertRegistInfo(registVO);
		return "redirect:regist";
	}

	// 완제품 삭제
	@GetMapping("produce/registDelete")
	@ResponseBody
	public int deleteRegistInfo(String registLOT, RedirectAttributes ratt) {
		return registService.deleteRegistInfo(registLOT);
	}

	// BOM 페이지 이동
	@GetMapping("/bom")
	public String bom(Model model) {
		model.addAttribute("info", bomService.selectBomNo());
		return "produce/bom";
	}

	// BOM list에 ajax
	@GetMapping("produce/bomList")
	@ResponseBody
	public List<BomVO> bomList() {
		return bomService.selectBomList();
	}

	// BOM 등록
	@PostMapping("bomInsert")
	public String insertBomInfo(BomVO bomVO) {
		bomService.insertBomInfo(bomVO);
		return "redirect:bom";
	}

	// BOM 수정
	@PostMapping("bomUpdate")
	public String updateBomInfo(BomVO bomVO, RedirectAttributes ratt) {
		int result = bomService.updateBomInfo(bomVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:bom";
	}

	// BOM 삭제
	@GetMapping("produce/bomDelete")
	@ResponseBody
	public int deleteBomInfo(int bomNo, RedirectAttributes ratt) {
		return bomService.deleteBomInfo(bomNo);
	}

	// 제품 페이지 이동
	@GetMapping("/goods")
	public String Goods(Model model) {
		model.addAttribute("info", goodsService.selectGoodNo());
		return "produce/goods";
	}

	// 제품 list에 ajax
	@GetMapping("produce/goodsList")
	@ResponseBody
	public List<GoodsVO> goodsList() {
		return goodsService.selectGoodList();
	}

	// 제품 등록
	@PostMapping("goodsInsert")
	public String insertgoodsInfo(GoodsVO goodsVO) {
		goodsService.insertGoodInfo(goodsVO);
		return "redirect:goods";
	}

	// 제품정보 수정
	@PostMapping("goodsUpdate")
	public String updateGoodsInfo(GoodsVO goodsVO, RedirectAttributes ratt) {
		int result = goodsService.updateGoodInfo(goodsVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:goods";
	}
	
	// 제품정보 삭제
		@GetMapping("produce/goodsDelete")
		@ResponseBody
		public int deleteGoodsInfo(int goodsNo, RedirectAttributes ratt) {
			return goodsService.deleteGoodInfo(goodsNo);
		}

	// 불량관리 페이지 이동
	@GetMapping("/proError")
	public String proError(Model model) {

		return "produce/proError";
	}

	// ===========================================================

}
