package com.studio216.service.Iservice;

import com.studio216.service.bean.Magazine;

public interface IMagazineService {
	public Magazine getMagazineByMagaCode(String magaCode) throws Exception;
	public Magazine getMagazineByMagaBarCode(String magaBarCode) throws Exception;
}
