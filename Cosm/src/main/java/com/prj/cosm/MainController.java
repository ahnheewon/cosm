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

import com.prj.cosm.user.emp.service.EmpService;
import com.prj.cosm.user.emp.service.EmpVO;

@Controller
@CrossOrigin("*")
public class MainController {

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
}
