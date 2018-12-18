package com.studio216.service.Idao;

public interface IOtherDao {
	public String getTypeByCode(String code) throws Exception;

	public String getTypeByBarCode(String barCode) throws Exception;
}
