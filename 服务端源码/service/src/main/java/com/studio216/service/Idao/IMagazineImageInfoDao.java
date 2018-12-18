package com.studio216.service.Idao;

import com.studio216.service.entity.MagazineImageInfo;

public interface IMagazineImageInfoDao {
	public MagazineImageInfo getMagazineImageInfoByMagaCode(String magaCode)
			throws Exception;
}
