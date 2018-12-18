package com.studio216.service.Idao;

import com.studio216.service.entity.BookImageInfo;

public interface IBookImageInfoDao {
	public BookImageInfo getBookImageInfoByBookCode(String bookCode)
			throws Exception;
}
