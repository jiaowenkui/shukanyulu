package com.studio216.service.Iresource;

import com.studio216.service.bean.Magazine;

public interface IMagazineResource {
	public Magazine getMagazineByMagaCode(String magaCode);

	public Magazine getMagazineByMagaBarCode(String magaBarCode);

}
