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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.equipment.equip.service.EquipService;
import com.prj.cosm.equipment.equip.service.EquipVO;
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

import lombok.extern.log4j.Log4j2;

@Controller
@CrossOrigin("*")
@Log4j2
public class MainController {

	@Autowired
	EquipService eService;

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

	// 영업팀 -----------------------------------
	// 영업 - 주문조회 리스트

	/* main - 주문목록조회 = ajax, get */

	// 영업 end =======================================================

}
