package com.prj.cosm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prj.cosm.equipment.equip.service.EquipService;
import com.prj.cosm.produce.bom.service.BomService;
import com.prj.cosm.produce.goods.service.GoodsService;
import com.prj.cosm.produce.instruct.service.InsService;
import com.prj.cosm.produce.plan.service.PlanService;
import com.prj.cosm.produce.regist.service.RegistService;
import com.prj.cosm.sales.client.service.ClientService;

@Controller
@CrossOrigin("*")
//@Log4j2
public class MainController {

@RequestMapping("/")
public String home() {
	return "/top";
}
}
