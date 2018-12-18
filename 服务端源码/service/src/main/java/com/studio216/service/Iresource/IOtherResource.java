package com.studio216.service.Iresource;

import java.util.List;

import com.studio216.service.bean.CheckItem;

public interface IOtherResource {
	public String getTypeByCode(String code);

	public String getTypeByBarCode(String BarCode);

	public List<CheckItem> getCheckItemByPlace(String place);
}
