package com.studio216.service.Idao;

import com.studio216.service.entity.InforImageInfo;

public interface IInforImageInfoDao {
	public InforImageInfo getInforImageInfoByInforCode(String inforCode)
			throws Exception;
}
