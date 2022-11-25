package com.prj.cosm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prj.cosm.sales.client.service.ClientService;
import com.prj.cosm.sales.client.service.ClientVO;
import com.prj.cosm.user.alert.service.AlertService;
import com.prj.cosm.user.alert.service.AlertVO;
import com.prj.cosm.user.emp.service.EmpService;
import com.prj.cosm.user.emp.service.EmpVO;

@Controller
@CrossOrigin("*")
public class UserController {
//	여기서부터 진정욱
	@Autowired
	EmpService service;

	@Autowired
	ClientService cService;
	
	@Autowired
	AlertService aService;

	// 첫 화면
	@GetMapping("/main")
	public String main(Model model) {
		return "/index";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	//고객가입 폼
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

	@PostMapping("/userInsert")
	public String empInsert(EmpVO empVO) {
		service.userInsert(empVO);
		return "redirect:userList";
	}

	//고객가입 데이터
	@Transactional
	@RequestMapping("/clientInsert")
	public String clientInsert(EmpVO empVO, ClientVO cVO) {
		System.out.println(empVO);
		System.out.println(cVO);
		int result = service.userInsert(empVO);
		if (result == 1) {
			cVO.setUserNo(service.empSelect(empVO.getUsersId()).getUsersNo());
			cService.clientIn(cVO);
		}
		System.out.println(result + "--------------------------------------------");
		return "redirect:login";
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

	@PostMapping("/userConfirm")
	@ResponseBody
	public int userConfirm(@RequestBody EmpVO vo) {
		System.out.println("--------------------------------");
		System.out.println(vo);
		return service.userConfirm(vo);
	}

	@PostMapping("/getAlertList")
	@ResponseBody
	public List<AlertVO> getAlertList(String usersNo){
		return aService.getAlertList(usersNo);
	}
	
	@PostMapping("/getAlert")
	@ResponseBody
	public AlertVO getAlert(AlertVO aVO){
		return aService.getAlert(aVO);
	}
	
	@PostMapping("/insertAlert")
	@ResponseBody
	public int insertAlert(AlertVO aVO){
		return aService.insertAlert(aVO);
	}
	
	@PostMapping("/updateAlert")
	@ResponseBody
	public int updateAlert(AlertVO aVO){
		return aService.updateAlert(aVO);
	}
	
//	여기까지 진정욱
}
