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
import com.prj.cosm.produce.goods.service.GoodsService;
import com.prj.cosm.produce.instruct.service.InsService;
import com.prj.cosm.produce.plan.service.PlanService;
import com.prj.cosm.produce.regist.service.RegistService;
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

	
}
