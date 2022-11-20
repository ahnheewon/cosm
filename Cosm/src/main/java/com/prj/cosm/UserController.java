package com.prj.cosm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prj.cosm.sales.client.service.ClientVO;
import com.prj.cosm.user.emp.service.EmpService;
import com.prj.cosm.user.emp.service.EmpVO;

@Controller
@CrossOrigin("*")
public class UserController {
//	여기서부터 진정욱
	@Autowired
	EmpService service;

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

	@PostMapping("clientInsert")
	public String clientInsert(EmpVO empVO, ClientVO cVO) {
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

	@PostMapping("/userConfirm")
	@ResponseBody
	public int userConfirm(@RequestBody EmpVO vo) {
		System.out.println("--------------------------------");
		System.out.println(vo);
		return service.userConfirm(vo);
	}

//	여기까지 진정욱
}
