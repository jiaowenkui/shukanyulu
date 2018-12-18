package com.studio216.service.Iservice;

import java.util.List;

import com.studio216.service.bean.CheckItem;

public interface IOtherService {
	public String getTypeByCode(String code) throws Exception;

	public String getTypeByBarCode(String barCode) throws Exception;

	public List<CheckItem> getCheckItemByPlace(String place) throws Exception;
}
