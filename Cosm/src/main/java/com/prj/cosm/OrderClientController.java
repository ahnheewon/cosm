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
import com.prj.cosm.sales.orders.service.OrdersService;
import com.prj.cosm.sales.orders.service.OrdersVO;

@Controller
@CrossOrigin("*")
public class OrderClientController {
	@Autowired
	OrdersService oService;
	
	@Autowired
	ClientService cService;
	
	// 주문하기 화면
	@RequestMapping("/order")
	public String clientOrder(Model model) {
		return "client/order";
	}
	// 주문조회 화면
	
	// 마이페이지 화면
	
	// 제품리스트 화면
	@RequestMapping("/coder")
	public List<OrdersVO> client(Model model) {
		return oService.salesOrderList();
	}

	// 고객 - 첫 화면
	@RequestMapping("/cmain")
	public String cilentorder(Model model) {
		return "client/order";
	}

	// 주문 등록창
	@PostMapping("insert")
	public String cinsert(OrdersVO vo, RedirectAttributes ratt) {
		oService.insertOrder(vo);
		return "client/insert"; // 목록으로 돌아가기
	}

	// 고객 - 주문목록데이터
	@RequestMapping("/orderList")
	@ResponseBody
	public List<OrdersVO> clientorderList(Model model) {
		model.addAttribute("id", oService.getOrderNo());
		return oService.salesOrderList();
	}

	

	// 마이페이지
	@RequestMapping("/my")
	public String clientMypage(Model model) {
		return "client/myPage";
	}

	// 영업==========================================================================================
	// 주문조회 리스트
	@ResponseBody
	@GetMapping("/ajax/orders") // url
	public List<OrdersVO> ajaxOrder(Model model) {
		return oService.salesOrderList();
	}

	// 체크박스 - 삭제
	@ResponseBody
	@PostMapping("/ajax/delcheckOrder") // requestBody 는 웬만한 값 다 넘겨줄수 있음.(여기서는 배열 넘길때 씀)
	public int delCheckOrder(@RequestBody OrdersVO vo) {
		return oService.deleteCheck(vo.getNoList());
	}

	// 주문 - 수정
	@ResponseBody
	@PostMapping("/ajax/upOrders")
	public int updateInfo(@RequestBody List<OrdersVO> list, RedirectAttributes ratt) {
		int result = oService.updatePro(list);

		return result;
	}
	
	// 접수 버튼 이벤트
	@ResponseBody
	@PostMapping("/ajax/recNos")
	public int recNos(@RequestBody List<OrdersVO> vo , RedirectAttributes ratt) {
		int result = oService.recNos(vo);
		return result;
	}


	// 테스트용
	@RequestMapping("/test")
	public String test(Model model) {
		return "sales/test";
	}

	// 메인페이지 - 주문관리
	@GetMapping("/orders")
	public String salesorder(Model model) {
		return "sales/orders";
	}

	// 사원 - 주문목록데이터
	@GetMapping("/ordersList")
	@ResponseBody
	public List<OrdersVO> salesorderList(Model model) {
		model.addAttribute("id", oService.getOrderNo());
		return oService.salesOrderList();
	}


	
	
	/* main - 주문목록조회 = ajax, get */

	// 영업 end =======================================================

}