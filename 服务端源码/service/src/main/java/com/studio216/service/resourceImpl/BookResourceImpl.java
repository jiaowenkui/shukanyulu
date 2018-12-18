package com.studio216.service.resourceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.studio216.service.Iresource.IBookResource;
import com.studio216.service.Iservice.IBookService;
import com.studio216.service.bean.Book;

@Path("/Book")
public class BookResourceImpl implements IBookResource {

	@Autowired
	private IBookService bookService;

	public BookResourceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	@Produces("application/json")
	@GET
	@Path("/getBookByBookCode")
	public Book getBookByBookCode(@QueryParam("bookCode") String bookCode) {
		// TODO Auto-generated method stub
		try {
			return bookService.getBookByBookCode(bookCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Book();
		}
	}

	@Override
	@Produces("application/json")
	@GET
	@Path("/getBookByBookBarCode")
	public Book getBookByBookBarCode(
			@QueryParam("bookBarCode") String bookBarCode) {
		// TODO Auto-generated method stub
		try {
			return bookService.getBookByBookBarCode(bookBarCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new Book();
		}
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
}
