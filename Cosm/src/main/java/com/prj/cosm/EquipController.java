package com.prj.cosm;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.common.service.FileRenamePolicy;
import com.prj.cosm.common.service.FileUtil;
import com.prj.cosm.equipment.equip.service.EquipService;
import com.prj.cosm.equipment.equip.service.EquipVO;
import com.prj.cosm.equipment.work.service.WorkService;
import com.prj.cosm.equipment.work.service.WorkVO;

@Controller
@CrossOrigin("*")
public class EquipController {


	@Autowired
	EquipService eService;
	
	@Autowired
	WorkService wService;
	
	@Value("${file.path}")
	String path;
	
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
		public String insertEquip(EquipVO vo, MultipartFile img) throws IllegalStateException, IOException {
			
		      if(img != null && img.getSize() > 0) {
		          //첨부파일 처리        
		          String fname = img.getOriginalFilename(); // 이미지 실제 이름
		          
		          File file = new File(path, fname);         
		          file = FileRenamePolicy.rename(file); // 파일 중복 검사
		          
		          img.transferTo(file); // 파일을 폴더로 옮겨줌
		          vo.setEFile(file.getName());
		       }
		      
			eService.insertEquip(vo);
		return "redirect:/equipment/process";
		
		}
		
		// 현재 적용 공정에 달려있는 설비 갯수 조회
		@PostMapping("/equipment/getMaxEquipNum/{equipProcess}")
		@ResponseBody
		public EquipVO getMaxEquipNum(@PathVariable int equipProcess) {
			
		return eService.getMaxEquipNum(equipProcess);
		}	

		// 설비 단건 조회
		@GetMapping("/equipment/getEquipInfo")
		@ResponseBody
		public Map getEquipInfo(Model model, int equipNo) {
			
			Map<String, EquipVO> equipMap = new HashMap<String, EquipVO>();
			
			equipMap.put("et", eService.getEquipTime(equipNo) );
			equipMap.put("ei", eService.getEquipInfo(equipNo) );
	
			return equipMap;
			
		}
		
		// 파일 다운
		@GetMapping("/equipment/filedown")
		public void fileDown (String fname, HttpServletRequest request, HttpServletResponse response) throws Exception {
		      
		      FileUtil.fileDownload(path + fname, request, response); // path는 application.properties에 선언되어있음

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
			result = result + eService.updateDeleteEquipNo(equipNo);
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
			
			model.addAttribute("equip",eService.getEquipList());
			model.addAttribute("equipFirst",eService.getEquipList().get(0));
			model.addAttribute("tno",eService.getTestNo().getTestNo());

			model.addAttribute("wno",wService.getWorkNo().getWorkNo());
			
			return "/equipment/maintenance";
		}
		
		
		// 새로고침없이 다음 글 번호 가져오기위해..
			@GetMapping("/equipment/maintenanceNo")
			@ResponseBody
			public Map maintenanceNo() {
					
					Map<String, Integer> maintenanceNo = new HashMap<String, Integer>();
					
					maintenanceNo.put("tno",eService.getTestNo().getTestNo());
					maintenanceNo.put("wno",wService.getWorkNo().getWorkNo());
			
					return maintenanceNo;
					
				}
	//점검	
		
		// 점검 전체 리스트 조회
		@GetMapping("/equipment/testAllList")
		@ResponseBody
		public List<EquipVO> testAllList(){
						
		return eService.getTestList();
		}
			// 점검 미완 리스트 조회
			@GetMapping("/equipment/incompleteTestList")
			@ResponseBody
			public List<EquipVO> incompleteTestList(){
				
				return eService.getIncompleteTestList();
			}
			// 점검 완료 리스트 조회
			@GetMapping("/equipment/completeTestList")
			@ResponseBody
			public List<EquipVO> completeTestList(){
				
				return eService.getCompleteTestList();
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
		public EquipVO getTestInfo(int testNo, int testEquipNo) {
			
			return eService.getTestInfo(testNo, testEquipNo);

		}
		// 점검 선택 조회
		@PostMapping("/equipment/getTestSearch")
		@ResponseBody
		public EquipVO getTestSearch(EquipVO vo) {

			return eService.getTestSearch(vo);
		}

		// 점검 수정
					@PostMapping("/equipment/updateTest1") //1이 완료
					@ResponseBody
					@Transactional
					public EquipVO updateTest1(EquipVO vo) {
						eService.updateTestComplete(vo);
						return vo; // "{re:true}"
					}
					
					//점검 단순 수정.
					@PostMapping("/equipment/updateTest2") //2가 진행중
					@ResponseBody
					public EquipVO updateTest2(EquipVO vo) {
						eService.updateTestIncomplete(vo);
						return vo; // "{re:true}"
					}


		// 점검 삭제
		@DeleteMapping("/equipment/deleteTestNo/{testNo}")
		@ResponseBody
		public int deleteTest(@PathVariable int testNo) {
			int result = eService.deleteTest(testNo);
				result = result + eService.updateDeleteTestNo(testNo); //삭제 후 번호 정렬
			return result;
		}
		
		
		// 점검 전체조회 페이지네이션
		@ResponseBody
		@GetMapping(value="/equipment/testListPagination")
		public Map<String, Object> testListPagination(EquipVO vo,@Param("page")int page, @Param("perPage")int perPage) {
				
				
				Map<String, Object> pagination = new HashMap<String, Object>();
				pagination.put("page", vo.getPage());
				pagination.put("totalCount", eService.testListCount(vo)); // 데이터 갯수 세는 쿼리
				
				Map<String, Object>  gridData = new HashMap<String, Object>();
				gridData.put("pagination", pagination); 
				gridData.put("contents", eService.getTestListPage(page,perPage));
				
				Map<String, Object>  result = new HashMap<String, Object>();
				result.put("result", true);
				result.put("data", gridData);
				
			return result;
		}
		
//================================================================================================================================
// 공사
		
		// 공사 전체 리스트 조회
		@GetMapping("/equipment/workAllList")
		@ResponseBody
		public List<WorkVO> workAllList(){
								
			return wService.getWorkAllList();
		}
		
				// 공사 미승인 전체 리스트 조회
				@GetMapping("/equipment/incompleteWorkList")
				@ResponseBody
				public List<WorkVO> incompleteWorkList(){
										
					return wService.getIncompleteWorkList();
				}
				// 공사 미승인 전체 리스트 조회
				@GetMapping("/equipment/incompleteWork1")
				@ResponseBody
				public List<WorkVO> incompleteWork1(){
					
					return wService.getIncompleteWork1();
				}
				// 공사 미승인 전체 리스트 조회
				@GetMapping("/equipment/incompleteWork2")
				@ResponseBody
				public List<WorkVO> incompleteWork2(){
					
					return wService.getIncompleteWork2();
				}
				// 공사 미승인 전체 리스트 조회
				@GetMapping("/equipment/incompleteWork3")
				@ResponseBody
				public List<WorkVO> incompleteWork3(){
					
					return wService.getIncompleteWork3();
				}
				
				// 공사 승인완료 전체 리스트 조회
				@GetMapping("/equipment/completeWorkList")
				@ResponseBody
				public List<WorkVO> completeWorkList(){
										
					return wService.getCompleteWorkList();
				}
		
		
		// 공사 단건 조회
		@GetMapping("/equipment/getWorkInfo")
		@ResponseBody
		public WorkVO getWorkInfo(Model model, int workNo, int workEquipNo) {

			return wService.getWorkInfo(workNo, workEquipNo);
		}
		
		// 공사 등록
		@PostMapping("/equipment/insertWork")
		public int insertWork(WorkVO vo) {
			int result =wService.insertWork(vo)+wService.insertWorkSign(vo);		
			return result;
		}
		
		//공사 결재안건 수정 seq+1
		@PostMapping("/equipment/updateSignSeq")
		@ResponseBody
		public int updateSignSeq(WorkVO vo, RedirectAttributes ratt) {
			int result = wService.updateSignSeq(vo);	
			
			if(vo.getSignSeq() == 3) {
				wService.updateWorkCode(vo);
			}
			
			return result; // "{re:true}"
		}
		
		//공사 수정
		@PostMapping("/equipment/updateWork")
		@ResponseBody
		public WorkVO updateWork(WorkVO vo) {
				wService.updateWork(vo);
			return vo; // "{re:true}"
		}
		
		// 공사 삭제
		@DeleteMapping("/equipment/deleteWorkNo/{workNo}")
		@ResponseBody
		public int deleteWork(@PathVariable int workNo) {
				int a = wService.deleteWork(workNo);
				int b = wService.deleteSign(workNo);
				int c = wService.updateDeleteSignNo(workNo); //삭제 후 번호 정렬
				int d = wService.updateDeleteWorkNo(workNo); //삭제 후 번호 정렬
					
			return a+b+c+d;	
		}
		
		/*
		 * // 공사 품의 등록한 사람의 회원번호로 그 사람 권한 조회하기
		 * 
		 * @GetMapping("/equipment/getSignEmpNo")
		 * @ResponseBody public WorkVO getSignEmpNo(Model model, int signEmpNo) {
		 * model.addAttribute("writerAuthor",wService.getSignEmpNo(signEmpNo).
		 * getSignEmpNo()); return wService.getSignEmpNo(signEmpNo);
		 * 
		 * }
		 */
	
//================================================================================================================================
// 부품
		
		// 부품 관리 페이지 이동화면
		@RequestMapping("/equipment/part")
		public String equipmentPart(Model model) {
			model.addAttribute("equip",eService.getEquipList());
			
			return "/equipment/part";
		}
		
		// 부품 전체 리스트 조회
		@GetMapping("/equipment/partList")
		@ResponseBody
		public List<WorkVO> part(){
										
			return wService.getPartList();
		}	
		
		// 부품 단건 조회
		@GetMapping("/equipment/getPartInfo")
		@ResponseBody
		public WorkVO getPartInfo(String partNo) {
			return wService.getPartInfo(partNo);
					
		}
		
		// 부품 수정
			@PostMapping("/equipment/updatePart")
			@ResponseBody
			public int updatePart(WorkVO vo) {
				
				int result = wService.updatePart(vo)+ wService.updatePartEquip(vo);
				
				return result; //"{re:true}"
			}

		
//================================================================================================================================	
		@PostMapping("/equipment/equipControl")
		@ResponseBody
		@Transactional
		public int updateEquipState(int equipNo, String type) {
			System.out.println(equipNo+"         "+type);
			int result = eService.updateEquipState(equipNo);
			if(result ==1) {
				result = eService.controlEquipTime(equipNo,type);
			}
			return result;
		}
		
		@GetMapping("/equipment/getProAmt")
		@ResponseBody
		public EquipVO getProAmt() {
			return eService.getProAmt();
		}
}
