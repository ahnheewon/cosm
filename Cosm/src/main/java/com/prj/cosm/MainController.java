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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.equipment.equip.service.equipService;
import com.prj.cosm.equipment.equip.service.equipVO;
import com.prj.cosm.material.material.service.MaterialService;
import com.prj.cosm.material.material.service.MaterialVO;
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
	OrdersService ser;

	@Autowired
	equipService eService;
	
	@Autowired
	MaterialService mService;
		
		// 첫 화면
		@RequestMapping("/")
		public String main() {
			return "index";
		}
		
		//
		@RequestMapping("/equipment/main")
		public String equipmentMain() {
			return "/equipment/main";
		}
		
		// pno, eno 값뿌리기.
		@RequestMapping("/equipment/process")
		public String equipmentProgress(Model model) {
			
			model.addAttribute("pno",eService.getProcessNo().getProcessNo());
			model.addAttribute("eno",eService.getEquipNo().getEquipNo());
			model.addAttribute("ep",eService.getProcessList());
			
		return "/equipment/process";
		}
				
		// 공정 전체 리스트 조회 데이터
		@GetMapping("/equipment/processList")
		@ResponseBody
		public List<equipVO> progress(){
		
		return eService.getProcessList();
		}
		
		// 공정 등록
		@PostMapping("/equipment/insertProcess")
		public String insertProcess(equipVO vo, RedirectAttributes ratt) {
				Map<String, Object> result = eService.insertProcess(vo);
				ratt.addFlashAttribute("msg",result.get("result")+"건이 등록되었습니다.");
				return "redirect:/equipment/process"; 
		}
				
		
		// 설비 전체 리스트 조회 데이터
		@GetMapping("/equipment/equipList")
		@ResponseBody
		public List<equipVO> equip(){
		
		return eService.getEquipList();
		}
		
		// 설비 등록
		@PostMapping("/equipment/insertEquip")
		public String insertEquip(equipVO vo, RedirectAttributes ratt) {
				Map<String, Object> result = eService.insertEquip(vo);
				ratt.addFlashAttribute("msg",result.get("result")+"건이 등록되었습니다.");
				return "redirect:/equipment/process";
		}
		
		// 설비 단건 조회
		@GetMapping("/equipment/getEquipInfo")
		@ResponseBody
		public String getEquipInfo(equipVO vo,Model model) {
			model.addAttribute("equipInfo",eService.getEquipInfo(vo).getEquipName());
			return "equipment/process";
			
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

	@GetMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("authorList", service.getAuthorList());
		return "/users/emp/empList";
	}

	@GetMapping("/clientList")
	public String clientList(Model model) {
		model.addAttribute("authorList", service.getAuthorList());
		return "/users/emp/empList";
	}

	@GetMapping("/getEmpList")
	@ResponseBody
	public List<EmpVO> getEmpList() {
		return service.empSelectList();
	}

	@GetMapping("/userSelect")
	@ResponseBody
	public EmpVO userSelect(String usersNo) {
		return service.empSelect(usersNo);
	}

	@PostMapping("empInsert")
	public String empInsert(EmpVO empVO) {
		service.empInsert(empVO);
		return "redirect:empList";
	}

//	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	@GetMapping("/empCheckId")
	@ResponseBody
	public int empCheckId(String usersId) {
		return service.checkId(usersId);
	}

	// 고객 --------------------------------
	// 첫 화면
	@RequestMapping("/main")
	public List<OrdersVO> client(Model model) {
		return ser.salesOrderList();
	}

	// 고객 주문목록 관리 메인
	@RequestMapping("/order")
	public String cilentorder(Model model) {
		return "client/order";
	}

	// 고객 - 주문목록데이터
	@RequestMapping("/orderList")
	@ResponseBody
	public List<OrdersVO> clientorderList(Model model) {
		model.addAttribute("id", ser.getOrderNo());
		return ser.salesOrderList();
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
	@GetMapping("/ajax/orders")
	public List<OrdersVO> ajaxOrder(Model model) {
		return ser.salesOrderList();
	}

	// 메인페이지 - 주문관리
	@RequestMapping("/test")
	public String test(Model model) {
		return "sales/dtest";
	}

	@GetMapping("/orders")
	public String salesorder(Model model) {
		return "sales/orders";
	}

	// 사원 - 주문목록데이터
	@GetMapping("/ordersList")
	@ResponseBody
	public List<OrdersVO> salesorderList(Model model) {
		model.addAttribute("id", ser.getOrderNo());
		return ser.salesOrderList();
	}

	/* main - 주문목록조회 = ajax, get */
	
	// 자재팀 영역
	
	// 자재 정보 등록폼
		@GetMapping("minsert")
		public String mInsertForm(Model model) {
			model.addAttribute("mno",mService.getMno().getMNo());
			return "material/mInfoInsert";
		}	

				
		// 자재 정보 등록창	
		@PostMapping("minsert")
		public String mInsert(MaterialVO mVO, RedirectAttributes ratt) {
			mService.insertMatarialInfo(mVO);
			return "redirect:minfo"; // 목록으로 돌아가기
		}
		
		// 거래처 이름 찾기
		@ResponseBody
		@GetMapping("/ajax/minsert")
		public List<MaterialVO> findComNm() {
		 return mService.findComNm();
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
		
		// 자재 정보 수정
		

		// 자재 정보 삭제 => 동시에 삭제됨
		@ResponseBody
		@PostMapping("/ajax/mdelinfo") //requestBody 는 웬만한 값 다 넘겨줄수 있음.(여기서는 배열 넘길때 씀)
		public int mDeleteInfo(@RequestBody MaterialVO vo) {	
			//System.out.println(vo.getDelmno()+"=================>>>>>>>>>>>>>>");
			return mService.deleteMatrailInfo(vo.getDelmno());
		}
}
