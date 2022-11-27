package com.prj.cosm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

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


}
