package com.prj.cosm;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.equipment.equip.service.equipService;
import com.prj.cosm.equipment.equip.service.equipVO;

@Controller
@CrossOrigin ("*")
public class MainController {
	

	@Autowired
	equipService eService;
		
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
		
		
}
