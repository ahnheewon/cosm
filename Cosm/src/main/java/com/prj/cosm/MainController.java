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
