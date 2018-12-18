package com.studio216.service.Iresource;

import com.studio216.service.bean.InternalData;

public interface IInternalDataResource {
	public InternalData getInternalDataByInforCode(String inforCode);
	public InternalData getInternalDataByInforBarCode(String inforBarCode);
}
