package com.prj.cosm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	// 첫 화면
		@RequestMapping("/main")
		public String main(Model model) {
			return "index";
		}
}
