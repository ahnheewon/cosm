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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.material.material.service.MaterialVO;
import com.prj.cosm.sales.client.service.ClientService;
import com.prj.cosm.sales.client.service.ClientVO;
import com.prj.cosm.sales.orders.service.OrdersService;
import com.prj.cosm.sales.orders.service.OrdersVO;
import com.prj.cosm.sales.product.service.ProductService;
import com.prj.cosm.sales.salesIo.service.SalesIoService;
import com.prj.cosm.sales.salesIo.service.SalesIoVO;
import com.prj.cosm.user.alert.service.AlertService;
import com.prj.cosm.user.emp.service.EmpService;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.mode_return;

@Controller
@CrossOrigin("*")
public class OrderClientProductController {
	/*-----------------
	  주문 : orders service
	-----------------*/
	@Autowired
	OrdersService oService;

	/*-----------------
	  완제품 : salesIo service
	-----------------*/
	@Autowired
	SalesIoService sService;

	/*-----------------
	  고객 : client service
	-----------------*/
	@Autowired
	ClientService cService;

	/*-----------------
	  제품 : product service
	-----------------*/
	@Autowired
	ProductService pService;

// 제품페이지=================================================================================================================
	// 로그인 유무 상관없이 보여짐
	@RequestMapping("/client/productList")
	public String productList(Model model) {
		return "/client/productList";
	}

// 고객=================================================================================================================
	// 고객 - 로그인 후, 첫 화면 - 주문등록, 이전주문, 주문조회.. 볼 수 있음
	@RequestMapping("/client/main")
	public String main() {
		return "/client/main";
	}

	// 주문조회 페이지(월별 : 1개월 3개월 6개월 조회 가능)
	@GetMapping("/client/orderList")
	public String orderList(Model model) {
		// model.addAttribute("uno"), cService.getUserNo());
		return "/client/main";
	}

	//주문조회 데이터 - userNo,clientName - 1201일단 보류 
	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("/orders/getOrderList") public List<ClientVO> getOrderList(Model
	 * model) { return cService.getOrderList(); }
	 */

	// 마이페이지 화면
	@RequestMapping("/client/myPage")
	public String myPage(Model model) {
		return "/client/myPage";
	}

	// 문의하기 페이지
	@RequestMapping("/client/chat")
	public String chat(Model model) {
		return "/client/chat";
	}

	/*
	 * // 등록 페이지
	 * 
	 * @RequestMapping("/client/insertOrder") public String insertOrder(Model model)
	 * { // model.addAttribute("no", oService.getOrderNo()); return
	 * "/orders/insertOrder"; }
	 * 
	 * // 주문 등록 데이터
	 * 
	 * @PostMapping("/client/insertOrderData") public String
	 * insertOrderPage(OrdersVO ovo) { System.out.println("insert vo" + ovo);
	 * oService.insertOrder(ovo); return "redirect:/orders/sMain"; }
	 */

	// 등록 페이지
	@RequestMapping("/client/insertOrder")
	public String insertOrder(Model model) {
		// model.addAttribute("no", oService.getOrderNo());
		return "/client/insertOrder";
	}

	// 주문 등록 데이터
	@PostMapping("/client/insertOrderData")
	public String insertOrderPage(OrdersVO cvo) {
		System.out.println("insert vo" + cvo);
		oService.insertOrder(cvo);
		return "redirect:/client/main";
	}

	// 영업=================================================================================================================
	// 메인페이지 - 주문관리
	@GetMapping("/orders/sMain")
	public String salesorder(Model model) {
		return "/orders/sMain";
	}

	// 자재 정보 상세조회(단건) - 상세정보 데이터
	@ResponseBody
	@GetMapping("/orders/getOrderInfo")
	public OrdersVO getOrderInfo(OrdersVO vo) {
		return oService.getOrderInfo(vo); // ajax의 데이터를 보여줘야기때문에 데이터로 return
	}

	// 완제품 조회 리스트
	@ResponseBody
	@GetMapping("/orders/ajaxSalesList")
	public List<SalesIoVO> ajaxSalesList(Model model) {
		return sService.getSalesIoList();
	}

	// 완제품 조회 데이터
	@ResponseBody
	@GetMapping("/orders/salesList")
	public List<SalesIoVO> salesList(Model model) {
		model.addAttribute("id", sService.getSalesNo());
		return sService.getSalesIoList();
	}

	// 주문 조회 리스트
	@ResponseBody
	@GetMapping("/orders/ajaxOrders") // url
	public List<OrdersVO> ajaxOrder(Model model) {
		return oService.getOrderList();
	}

	// 접수 조회 데이터
	@GetMapping("/orders/getReceiptList")
	@ResponseBody
	public List<OrdersVO> getReceiptList(Model model) {
		model.addAttribute("id", oService.getOrderNo());
		return oService.getReceiptList();
	}

	// 신규 조회 데이터
	@GetMapping("/orders/ordersList")
	@ResponseBody
	public List<OrdersVO> salesorderList(Model model) {
		model.addAttribute("id", oService.getOrderNo());
		return oService.getOrderList();
	}

	// 출고내역 삭제
	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/orders/ajaxDelOutOrder") public int delOutOrder(@RequestBody
	 * SalesIoVO vo) { return sService.delOutOrder(vo); }
	 */

	// 삭제 - 접수 주문관리
	@ResponseBody
	@PostMapping("/orders/ajaxDelcheckOrder") // ajaxDelcheckOrder, requestBody 는 웬만한 값 다 넘겨줄수 있음.(여기서는 배열 넘길때 씀)
	public int delCheckOrder(@RequestBody OrdersVO vo) {
		return oService.deleteCheck(vo.getNoList());
	}

	// 주문 - 수정
	@ResponseBody
	@PostMapping("/orders/ajaxUpOrders") // ajaxUpOrders
	public int updateInfo(@RequestBody List<OrdersVO> list, RedirectAttributes ratt) {
		int result = oService.updatePro(list);

		return result;
	}

	// 출고 버튼 이벤트
	@ResponseBody
	@PostMapping("/orders/updateOutInfo")
	public int updateOutInfo(@RequestBody List<SalesIoVO> list) {
		int result = sService.updateOutInfo(list);
		return result;
	}

	// 접수 버튼 이벤트
	@ResponseBody
	@PostMapping("/orders/ajaxRecNos")
	public int recNos(@RequestBody List<OrdersVO> vo, RedirectAttributes ratt) {
		int result = oService.recNos(vo);
		return result;
		// 알림설정 필요
	}

	// 영업 end =======================================================

}
