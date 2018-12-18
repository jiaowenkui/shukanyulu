package com.studio216.service.Iservice;

import com.studio216.service.bean.InternalData;

public interface IInternalDataService {
	public InternalData getInternalDataByInforCode(String inforCode)
			throws Exception;

	public InternalData getInternalDataByInforBarCode(String inforBarCode)
			throws Exception;
}
