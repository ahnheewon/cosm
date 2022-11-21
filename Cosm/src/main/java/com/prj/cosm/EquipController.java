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
import com.prj.cosm.equipment.part.service.PartService;
import com.prj.cosm.equipment.part.service.PartVO;
import com.prj.cosm.equipment.work.service.WorkService;
import com.prj.cosm.equipment.work.service.WorkVO;

@Controller
@CrossOrigin("*")
public class EquipController {


	@Autowired
	EquipService eService;
	
	@Autowired
	WorkService wService;
	
	@Autowired
	PartService pService;
		
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
		
	//점검	
		
		// 점검 전체 리스트 조회
		@GetMapping("/equipment/testList")
		@ResponseBody
		public List<EquipVO> test(){
						
		return eService.getTestList();
		}
		
		// 점검 등록
		@PostMapping("/equipment/insertTest")
		public String insertTest(EquipVO vo, RedirectAttributes ratt) {
			eService.insertTest(vo);
			return "redirect:/equipment/maintenance";
		}

		// 점검 단건 조회
		@GetMapping("/equipment/getTestInfo")
		@ResponseBody
		public EquipVO getTestInfo(Model model, int testNo) {
			return eService.getTestInfo(testNo);

		}

		// 점검 수정
		@PostMapping("/equipment/updateTest")
		@ResponseBody
		public EquipVO updateTest(EquipVO vo) {
			eService.updateTest(vo);
			return vo; // "{re:true}"
		}

		// 점검 삭제
		@DeleteMapping("/equipment/deleteTest/{processNo}")
		@ResponseBody
		public int deleteTest(@PathVariable int testNo) {
			int result = eService.deleteTest(testNo);
			return result;
		}	
		
		
	//고장
		
		// 고장 전체 리스트 조회
		@GetMapping("/equipment/failList")
		@ResponseBody
		public List<EquipVO> fail(){
						
		return eService.getFailList();
		}
		
		// 고장 등록
		@PostMapping("/equipment/insertFail")
		public String insertFail(EquipVO vo, RedirectAttributes ratt) {
			eService.insertFail(vo);
			return "redirect:/equipment/maintenance";
		}

		// 고장 단건 조회
		@GetMapping("/equipment/getFailInfo")
		@ResponseBody
		public EquipVO getFailInfo(Model model, int processNo) {
			return eService.getFailInfo(processNo);

		}

		// 고장 수정
		@PostMapping("/equipment/updateFail")
		@ResponseBody
		public EquipVO updateFail(EquipVO vo) {
			eService.updateFail(vo);
			return vo; // "{re:true}"
		}

		// 고장 삭제
		@DeleteMapping("/equipment/deleteFail/{failNo}")
		@ResponseBody
		public int deleteFail(@PathVariable int failNo) {
			int result = eService.deleteFail(failNo);
			return result;
		}
		
//================================================================================================================================
// 공사
		
		// 공사 전체 리스트 조회
		@GetMapping("/equipment/workList")
		@ResponseBody
		public List<WorkVO> work(){
								
			return wService.getWorkList();
		}
		
		// 공사 단건 조회
		@GetMapping("/equipment/getWorkInfo")
		@ResponseBody
		public WorkVO getWorkInfo(Model model, int workNo) {
			return wService.getWorkInfo(workNo);

		}
		
		// 공사 등록
		@PostMapping("/equipment/insertWork")
		public String insertWork(EquipVO vo, RedirectAttributes ratt) {
			eService.insertFail(vo);
		return "redirect:/equipment/maintenance"; 
				}
		
		//공사 결재안건 수정
	
//================================================================================================================================
// 부품
		
		// 부품 관리 페이지 이동화면
		@RequestMapping("/equipment/part")
		public String equipmentPart(Model model) {
			return "/equipment/part";
		}
		
		// 부품 전체 리스트 조회
		@GetMapping("/equipment/partList")
		@ResponseBody
		public List<PartVO> part(){
										
			return pService.getPartList();
		}
		
		// 부품 등록은 따로하지 않고 DB에서 넣습니다.
		
		// 부품 수정
		@PostMapping("/equipment/updatePart")
		@ResponseBody
		public int updatePart(PartVO vo) {
			int result = pService.updatePart(vo);
			result = result + pService.insertPartIO(vo);
			return result; // "{re:true}"
		}
		
		// 부품변동 전체 리스트 조회
		@GetMapping("/equipment/partIOList")
		@ResponseBody
		public List<PartVO> partIo(){
										
		return pService.getPartIOList();
		}
		
		// 부품변동 등록은 부품 수정할때 처리됩니다.
	
//================================================================================================================================	

}
