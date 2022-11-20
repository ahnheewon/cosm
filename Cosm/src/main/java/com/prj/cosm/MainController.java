package com.prj.cosm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.equipment.equip.service.EquipService;
import com.prj.cosm.equipment.equip.service.EquipVO;
import com.prj.cosm.equipment.work.service.WorkService;
import com.prj.cosm.equipment.work.service.WorkVO;
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
	EquipService eService;
	
	@Autowired
	WorkService wService;
		
		// 첫 화면
		@RequestMapping("/equipment/main")
		public String main() {
			return "/equipment/main";
		}
		
		// 공정관리 페이지 이동, // 매개변수 pno, eno, ep 데이터 뿌리기.
		@RequestMapping("/equipment/process")
		public String equipmentProcess(Model model) {
			
			model.addAttribute("pno",eService.getProcessNo().getProcessNo());
			model.addAttribute("eno",eService.getEquipNo().getEquipNo()); // 다음 설비 번호 조회
			model.addAttribute("epl",eService.getProcessList()); // 현재 사용가능한 공정 번호 조회
			model.addAttribute("ep",eService.getEquipProcess()); // 설비에서 이용중인 공정 번호 조회
	
		return "/equipment/process";
		}	
		
		// 설비 전체 리스트 조회 데이터
		@GetMapping("/equipment/equipList")
		@ResponseBody
		public List<EquipVO> equip(){
		
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
		
		// 설비 수정
		@PostMapping("/equipment/updateEquip")
		@ResponseBody
		public EquipVO updateEquip(EquipVO vo) {
			eService.updateEquip(vo);
		return vo; //"{re:true}"
		}
		
		// 설비 삭제, 설비별 가동시간도 함께 삭제
		@DeleteMapping("/equipment/deleteEquip/{equipNo}")
		@ResponseBody
		public int deleteEquip(@PathVariable int equipNo) {
			int result = eService.deleteEquip(equipNo);
			result = result + eService.deleteEquipTime(equipNo);
		return result;
		}
		
		// 설비 삭제시 번호 정렬, 설비별 가동시간도 함께 update문 
		@PostMapping("/equipment/updateDeleteEquipNo/{equipNo}")
		@ResponseBody
		public int updateDeleteEquipNo(@PathVariable int equipNo) {
			int result= eService.updateDeleteEquipNo(equipNo);
			result = result + eService.updateDeleteTimeEquipNo(equipNo);
		return result; 
		}
		
//================================================================================================================================	
		// 공정 전체 리스트 조회 데이터
		@GetMapping("/equipment/processList")
		@ResponseBody
		public List<EquipVO> process(){
				
		return eService.getProcessList();
		}
				
		// 공정 등록
		@PostMapping("/equipment/insertProcess")
		public String insertProcess(EquipVO vo, RedirectAttributes ratt) {
				eService.insertProcess(vo);
		return "redirect:/equipment/process"; 
		}
		
		// 공정 단건 조회
		@GetMapping("/equipment/getProcessInfo")
		@ResponseBody
		public EquipVO getProcessInfo(Model model, int processNo) {
		return eService.getProcessInfo(processNo);
					
				}
				
		// 공정 수정
		@PostMapping("/equipment/updateProcess")
		@ResponseBody
		public EquipVO updateProcess(EquipVO vo) {
		eService.updateProcess(vo);
		return vo; //"{re:true}"
		}
				
		// 공정 삭제
		@DeleteMapping("/equipment/deleteProcess/{processNo}")
		@ResponseBody
		public int deleteProcess(@PathVariable int processNo) {
			int result= eService.deleteProcess(processNo);
			return result;
		}
				
		// 공정 삭제시 번호 정렬, 적용공정 update문
		@PostMapping("/equipment/updateDeleteProcessNo/{processNo}")
		@ResponseBody
		public int updateDeleteProcessNo(@PathVariable int processNo) {
			int result= eService.updateDeleteProcessNo(processNo);
			result = result + eService.updateDeleteEquipProcess(processNo);
			return result; 
		}		

//================================================================================================================================	

		// 유지 관리 페이지 이동화면
		@RequestMapping("/equipment/maintenance")
		public String equipmentMaintenance(Model model) {
			return "/equipment/maintenance";
		}
		
		// 점검 전체 리스트 조회
		@GetMapping("/equipment/testList")
		@ResponseBody
		public List<EquipVO> test(){
						
		return eService.getTestList();
		}
			
		// 고장 전체 리스트 조회
		@GetMapping("/equipment/failList")
		@ResponseBody
		public List<EquipVO> fail(){
						
		return eService.getFailList();
		}
		
		// 공사 전체 리스트 조회
		@GetMapping("/equipment/workList")
		@ResponseBody
		public List<WorkVO> work(){
								
		return wService.getWorkList();
		}
	
//================================================================================================================================

		// 부품 관리 페이지 이동화면
		@RequestMapping("/equipment/part")
		public String equipmentPart(Model model) {
			return "/equipment/part";
		}

		
//================================================================================================================================	
		
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
}
