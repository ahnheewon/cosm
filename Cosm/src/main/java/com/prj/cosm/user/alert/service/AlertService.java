package com.prj.cosm.user.alert.service;

import java.util.List;

public interface AlertService {
	public List<AlertVO> getAlertList(String usersNo);
	public AlertVO getAlert(AlertVO aVO);
	public int insertAlert(AlertVO aVO);
	public int updateAlert(AlertVO aVO);
}
