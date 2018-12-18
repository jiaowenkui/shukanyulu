package com.studio216.service.Iservice;

import com.studio216.service.bean.Book;

public interface IBookService {
	public Book getBookByBookCode(String bookCode) throws Exception;
	public Book getBookByBookBarCode(String bookBarCode) throws Exception;
}
