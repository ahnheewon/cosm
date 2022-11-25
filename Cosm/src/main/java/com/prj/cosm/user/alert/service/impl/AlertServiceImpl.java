package com.prj.cosm.user.alert.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.user.alert.mapper.AlertMapper;
import com.prj.cosm.user.alert.service.AlertService;
import com.prj.cosm.user.alert.service.AlertVO;

@Service
public class AlertServiceImpl implements AlertService {

	@Autowired
	AlertMapper mapper;

	@Override
	public List<AlertVO> getAlertList(String usersNo) {
		return mapper.getAlertList(usersNo);
	}

	@Override
	public AlertVO getAlert(AlertVO aVO) {
		return mapper.getAlert(aVO);
	}

	@Override
	public int insertAlert(AlertVO aVO) {
		return mapper.insertAlert(aVO);
	}

	@Override
	public int updateAlert(AlertVO aVO) {
		return mapper.updateAlert(aVO);
	}

}
