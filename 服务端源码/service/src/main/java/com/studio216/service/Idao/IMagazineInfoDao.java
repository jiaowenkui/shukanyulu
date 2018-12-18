package com.studio216.service.Idao;

import java.util.List;

import com.studio216.service.bean.CheckItem;
import com.studio216.service.entity.MagazineInfo;

public interface IMagazineInfoDao {
	public MagazineInfo getMagazineInfoByMagaCode(String magaCode)
			throws Exception;

	public MagazineInfo getMagazineInfoByMagaBarCode(String magaBarCode)
			throws Exception;
	public List<CheckItem> getCheckItemByPlace(String place) throws Exception;
}
