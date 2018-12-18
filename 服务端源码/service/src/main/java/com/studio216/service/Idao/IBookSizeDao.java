package com.studio216.service.Idao;

import com.studio216.service.entity.Booksize;

public interface IBookSizeDao {
	public Booksize getBookSizeByBooksizeId(Integer bookSizeId)throws Exception;
}
