package com.studio216.service.Idao;

import com.studio216.service.entity.Booktype;

public interface IBookTypeDao {
	public Booktype getBookTypeByBookTypeId(Integer bookTypeId)throws Exception;
}
