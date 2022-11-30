package com.prj.cosm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.equipment.equip.service.EquipService;
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

@Controller
@CrossOrigin("*")
public class ProduceController {
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
	
	@Autowired
	EquipService equipService;
	

	// =============================생산관리=======================
	// 생산계획 list에 ajax주는 것
	@GetMapping("/produce/plan")
	@ResponseBody
	public List<PlanVO> plan() {
		return planService.selectPlanList();
	}

	// 생산계획 list 화면페이지 plan_no값 넘겨줌
	@GetMapping("/produce/planList")
	public String planList(Model model) {
		model.addAttribute("info", planService.selectPlanNo());
		model.addAttribute("goodsNo", planService.getGoodsNoList());
		model.addAttribute("bomNo", planService.getBomNoList());
		return "/produce/planList";
	}

	// 생산계획 단건 조회
	@GetMapping("/produce/getPlanInfo")
	@ResponseBody
	public PlanVO getPlanInfo(Model model, String planNo) {
		return planService.getPlanInfo(planNo);
	}

	// 생산계획 등록
	@PostMapping("/produce/planInsert")
	public String insertPlanInfo(PlanVO planVO) {
		planService.insertPlanInfo(planVO);
		
		return "redirect:/produce/planList";
	}

	// 생산계획시 bom단건조회
	@GetMapping("/produce/getBomInfo")
	@ResponseBody
	public BomVO getBomInfo(Model model, String bomProductNo) {
		return bomService.getBomInfo(bomProductNo);
	}

	// 생산계획 수정
	@PostMapping("/produce/planUpdate")
	public String updatePlanInfo(PlanVO planVO, RedirectAttributes ratt) {
		int result = planService.updatePlanInfo(planVO);

		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:/produce/planList";
	}

	// 생산계획 삭제
	@GetMapping("/produce/planDelete")
	public String deletePlanInfo(String planNo, RedirectAttributes ratt) {
		int result = planService.deletePlanInfo(planNo);

		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 삭제되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 삭제되지 않았습니다.");
		}
		return "redirect:/produce/planList";
	}

	// 미완료된 생산계획 리스트
	@GetMapping("/produce/completePlan")
	@ResponseBody
	public List<PlanVO> completePlan() {
		return planService.completePlanList();
	}

	// 주문서 리스트
	@GetMapping("/produce/selectOrderList")
	@ResponseBody
	public List<PlanVO> selectOrderList() {
		return planService.selectOrderList();
	}

	// 생산계획시 주문서 업데이트
	@PostMapping("/produce/updateOrderInfo")
	public String updateOrderInfo(PlanVO planVO, RedirectAttributes ratt) {
		int result = planService.updateOrderInfo(planVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:/produce/planList";
	}
	// 생산지시 list에 ajax주는 것
	@GetMapping("/produce/instruct")
	@ResponseBody
	public List<Map<String, Object>> instruct() {
		return insService.selectInsList();
	}

	// 생산지시 페이지이동
	@GetMapping("/produce/instructList")
	public String instructList(Model model) {
		model.addAttribute("info", insService.selectInsNo());
		model.addAttribute("mNo", insService.getMaterialNoList());
		model.addAttribute("playNo", insService.getPlayList());
		return "/produce/instructList";
	}

	// 모든 생산지시 리스트
	@GetMapping("/produce/allInsList")
	@ResponseBody
	public List<Map<String, Object>> allInsList(InsVO vo) {
		return insService.allInsList(vo);
	}

	// 생산지시 등록시 생산계획 리스트 업데이트
	@PostMapping("/produce/insPlay")
	public String updatePlanPlay(PlanVO planVO, RedirectAttributes ratt) {
		int result = planService.updatePlay(planVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:/produce/instructList";
	}
	
	
	// 생산지시 등록
	@PostMapping("/produce/insInsert")
	public String insertInsInfo(InsVO insVO) {
		insService.insertInsInfo(insVO);
		return "redirect:/produce/instructList";
	}

	// 생산지시 수정
	@PostMapping("/produce/insUpdate")
	public String updateInsInfo(InsVO insVO, RedirectAttributes ratt) {
		int result = insService.updateInsInfo(insVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:/produce/instructList";
	}

	// 생산지시 삭제
	@GetMapping("/produce/insDelete")
	@ResponseBody
	public int deleteInsInfo(String instructNo, RedirectAttributes ratt) {
		return insService.deleteInsInfo(instructNo);
	}

	// 완제품 페이지 이동
	@GetMapping("/produce/regist")
	public String regist(Model model) {
		model.addAttribute("info", registService.selectRegistLOT());
		model.addAttribute("label", registService.selectRegistLabel());
		model.addAttribute("playNo", registService.getPlayList());
		model.addAttribute("unit", registService.getUnitList());
		return "/produce/regist";
	}

	// 생산완료된 생산지시 list ajax
	@GetMapping("/produce/complete")
	@ResponseBody
	public List<Map<String, Object>> completeList() {
		return insService.completeList();
	}

	// 완제품 list에 ajax주는 것
	@GetMapping("/produce/registList")
	@ResponseBody
	public List<Map<String, Object>> regist() {
		return registService.selectRegistList();
	}

	// 완제품 등록
	@PostMapping("/produce/registInsert")
	public String insertRegistInfo(RegistVO registVO) {
		registService.insertRegistInfo(registVO);
		return "redirect:/produce/regist";
	}

	// 완제품 삭제
	@GetMapping("/produce/registDelete")
	@ResponseBody
	public int deleteRegistInfo(String registLOT, RedirectAttributes ratt) {
		return registService.deleteRegistInfo(registLOT);
	}

	// BOM 페이지 이동
	@GetMapping("/produce/bom")
	public String bom(Model model) {
		model.addAttribute("info", bomService.selectBomNo());
		model.addAttribute("mNo", bomService.getMaterialNoList());
		model.addAttribute("goodsNo", bomService.getGoodsNoList());
		return "/produce/bom";
	}

	// BOM list에 ajax
	@GetMapping("/produce/bomList")
	@ResponseBody
	public List<BomVO> bomList() {
		return bomService.selectBomList();
	}

	// BOM 등록
	@PostMapping("/produce/bomInsert")
	public String insertBomInfo(BomVO bomVO) {
		bomService.insertBomInfo(bomVO);
		return "redirect:/produce/bom";
	}

	// BOM 수정
	@PostMapping("/produce/bomUpdate")
	public String updateBomInfo(BomVO bomVO, RedirectAttributes ratt) {
		int result = bomService.updateBomInfo(bomVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:/produce/bom";
	}

	// BOM 삭제
	@GetMapping("/produce/bomDelete")
	@ResponseBody
	public int deleteBomInfo(String bomNo, RedirectAttributes ratt) {
		return bomService.deleteBomInfo(bomNo);
	}

	// 제품 페이지 이동
	@GetMapping("/produce/goods")
	public String Goods(Model model) {
		model.addAttribute("info", goodsService.selectGoodNo());
		model.addAttribute("unit", goodsService.getUnitList());
		return "/produce/goods";
	}

	// 제품 list에 ajax
	@GetMapping("/produce/goodsList")
	@ResponseBody
	public List<GoodsVO> goodsList() {
		return goodsService.selectGoodList();
	}

	// 제품 등록
	@PostMapping("/produce/goodsInsert")
	public String insertgoodsInfo(GoodsVO goodsVO) {
		goodsService.insertGoodInfo(goodsVO);
		return "redirect:/produce/goods";
	}

	// 제품정보 수정
	@PostMapping("/produce/goodsUpdate")
	public String updateGoodsInfo(GoodsVO goodsVO, RedirectAttributes ratt) {
		int result = goodsService.updateGoodInfo(goodsVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:/produce/goods";
	}

	// 제품정보 삭제
	@GetMapping("/produce/goodsDelete")
	@ResponseBody
	public int deleteGoodsInfo(String goodsNo, RedirectAttributes ratt) {
		return goodsService.deleteGoodInfo(goodsNo);
	}

	// 생산 완료 페이지 이동
	@GetMapping("/produce/proError")
	public String proError(Model model) {

		return "/produce/proError";
	}

	// 생산지시 진행중 완료로 전환
	@PostMapping("/produce/updateInsPlay")
	public String updateInsPlay(InsVO insVO, RedirectAttributes ratt) {
		int result = insService.updateInsPlay(insVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:/produce/proError";
	}

	// 생산지시 완료 보관으로 전환
	@PostMapping("/produce/updateInsPlay2")
	public String updateInsPlay2(InsVO insVO, RedirectAttributes ratt) {
		int result = insService.updateInsPlay2(insVO);
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 수정되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 수정되지 않았습니다.");
		}
		return "redirect:/produce/regist";
	}

	// 생산 메인 페이지 이동
	@GetMapping("/produce/main")
	public String produceMain(Model model) {

		return "/produce/main";
	}

	// 완제품 리스트 페이지 이동
	@GetMapping("/produce/completeList")
	public String completeList(Model model) {

		return "/produce/completeList";
	}

	// 완제품 list에 ajax주는 것
	@GetMapping("/produce/completedList")
	@ResponseBody
	public List<Map<String, Object>> completedList(RegistVO vo) {
		return registService.completeList(vo);
	}

	// 불량관리 페이지 이동
	@GetMapping("/produce/errorPage")
	public String errorPage(Model model) {

		return "/produce/errorPage";
	}

	// 불량리스트
	@GetMapping("/produce/errorList")
	@ResponseBody
	public List<Map<String, Object>> errorList(RegistVO vo) {
		return registService.errorList(vo);
	}
	
	//자재조회
	@GetMapping("/produce/materialList")
	@ResponseBody
	public List<BomVO> materialList() {
		return bomService.selectMaterialList();
	}

	// ===========================================================
}
