package com.studio216.service.Idao;

import java.util.List;

import com.studio216.service.bean.CheckItem;
import com.studio216.service.entity.Infordata;

public interface IInforDataDao {
	public Infordata getInforDataByInforCode(String inforCode) throws Exception;

	public Infordata getInforDataByInforBarCode(String inforBarCode)
			throws Exception;
	public List<CheckItem> getCheckItemByPlace(String place) throws Exception;
}
