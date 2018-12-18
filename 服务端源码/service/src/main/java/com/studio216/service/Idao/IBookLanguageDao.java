package com.studio216.service.Idao;

import com.studio216.service.entity.Booklanguage;

public interface IBookLanguageDao {
	public Booklanguage getBookLanguageByBooklanguageId(Integer booklanguageId)throws Exception;
}
