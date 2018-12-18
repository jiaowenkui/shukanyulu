package com.studio216.service.Idao;

import java.util.List;

import com.studio216.service.bean.CheckItem;
import com.studio216.service.entity.BookInfo;

public interface IBookInfoDao {
	public BookInfo getBookInfoByBookCode(String bookCode) throws Exception;

	public BookInfo getBookInfoByBookBarCode(String bookBarCode)
			throws Exception;
	public List<CheckItem> getCheckItemByPlace(String place) throws Exception;
}
