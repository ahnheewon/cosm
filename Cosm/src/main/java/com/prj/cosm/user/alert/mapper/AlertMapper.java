package com.prj.cosm.user.alert.mapper;

import java.util.List;

import com.prj.cosm.user.alert.service.AlertVO;

public interface AlertMapper {
	public List<AlertVO> getAlertList(String usersNo);

	public AlertVO getAlert(AlertVO aVO);

	public int insertAlert(AlertVO aVO);
	
	public int updateAlert(AlertVO aVO);
}
