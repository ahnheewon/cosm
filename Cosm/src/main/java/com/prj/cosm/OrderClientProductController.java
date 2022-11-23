package com.prj.cosm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prj.cosm.sales.client.service.ClientService;
import com.prj.cosm.sales.client.service.ClientVO;
import com.prj.cosm.sales.orders.service.OrdersService;
import com.prj.cosm.sales.orders.service.OrdersVO;
import com.prj.cosm.sales.product.service.ProductService;

@Controller
@CrossOrigin("*")
public class OrderClientProductController {
	@Autowired
	OrdersService oService;

	@Autowired
	ClientService cService;

	@Autowired
	ProductService pService;

// 제품페이지=================================================================================================================
	//로그인 유무 상관없이 보여짐
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

	// 주문하기(tab or layout),(회원+고객+주문 조인) 페이지
	@GetMapping("/client/insertOrder") //url
	public String insertOrder(Model model) {
		return "/client/insertOrder"; //resources - insertOrder
	}

	// 주문 등록시 데이터

	// 주문조회 화면(월별 : 1개월 3개월 6개월 조회 가능)
	@GetMapping("/client/orderList")
	@ResponseBody
	public List<ClientVO> cliOrderList(Model model) {
		// model.addAttribute("uno"), cService.getUserNo());
		return cService.myOrderList();
	}

	// 주문조회 데이터
	@GetMapping("/client/orderList")
	@RequestMapping
	public List<ClientVO> orderList() {

		return cService.myOrderList();
	}

	// 마이페이지 화면
	@RequestMapping("/client/myPage")
	public String myPage(Model model) {
		return "/client/myPage";
	}

	// 진위확인 된 사업자번호

	// 영업=================================================================================================================
	// 메인페이지 - 주문관리
	@GetMapping("/orders/sMain")
	public String salesorder(Model model) {
		return "/orders/sMain";
	}

	// 주문조회 리스트
	@ResponseBody
	@GetMapping("/orders/ajaxOrders") // url
	public List<OrdersVO> ajaxOrder(Model model) {
		return oService.salesOrderList();
	}

	// 체크박스 - 삭제
	@ResponseBody
	@PostMapping("/orders/ajaxDelcheckOrder") // ajaxDelcheckOrder, requestBody 는 웬만한 값 다 넘겨줄수 있음.(여기서는 배열 넘길때 씀)
	public int delCheckOrder(@RequestBody OrdersVO vo) {
		return oService.deleteCheck(vo.getNoList());
	}

	// 주문 - 수정
	@ResponseBody
	@PostMapping("/orders/ajaxUpOrders") //ajaxUpOrders
	public int updateInfo(@RequestBody List<OrdersVO> list, RedirectAttributes ratt) {
		int result = oService.updatePro(list);

		return result;
	}

	// 접수 버튼 이벤트
	@ResponseBody
	@PostMapping("/orders/ajaxRecNos")
	public int recNos(@RequestBody List<OrdersVO> vo, RedirectAttributes ratt) {
		int result = oService.recNos(vo);
		return result;
	}

	// 테스트용
//	@RequestMapping("/test")
//	public String test(Model model) {
//		return "sales/test";
//	}

	// 사원 - 주문목록데이터
	@GetMapping("/orders/ordersList")
	@ResponseBody
	public List<OrdersVO> salesorderList(Model model) {
		model.addAttribute("id", oService.getOrderNo());
		return oService.salesOrderList();
	}

	/* main - 주문목록조회 = ajax, get */

	// 영업 end =======================================================

}
