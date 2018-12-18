package com.studio216.service.Iresource;

import com.studio216.service.bean.Book;

public interface IBookResource {
	public Book getBookByBookCode(String bookCode);
	public Book getBookByBookBarCode(String bookBarCode);
}
