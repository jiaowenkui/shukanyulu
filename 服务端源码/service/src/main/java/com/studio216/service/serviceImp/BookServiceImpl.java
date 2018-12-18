package com.studio216.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studio216.service.Idao.IBookImageInfoDao;
import com.studio216.service.Idao.IBookInfoDao;
import com.studio216.service.Idao.IBookLanguageDao;
import com.studio216.service.Idao.IBookPublicDao;
import com.studio216.service.Idao.IBookSizeDao;
import com.studio216.service.Idao.IBookTypeDao;
import com.studio216.service.Iservice.IBookService;
import com.studio216.service.bean.Book;
import com.studio216.service.entity.BookImageInfo;
import com.studio216.service.entity.BookInfo;
import com.studio216.service.entity.Booklanguage;
import com.studio216.service.entity.Bookpublic;
import com.studio216.service.entity.Booksize;
import com.studio216.service.entity.Booktype;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookInfoDao bookInfoDao;
	@Autowired
	private IBookImageInfoDao bookImageInfoDao;
	@Autowired
	private IBookPublicDao bookPublicDao;
	@Autowired
	private IBookSizeDao bookSizeDao;
	@Autowired
	private IBookTypeDao bookTypeDao;
	@Autowired
	private IBookLanguageDao bookLanguageDao;

	public BookServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Book getBookByBookCode(String bookCode) throws Exception {
		// TODO Auto-generated method stub
		BookInfo bookInfo = bookInfoDao.getBookInfoByBookCode(bookCode);
		if (bookInfo == null)
			return new Book();
		else {
			// System.out.println(bookInfo.toString());
		}
		BookImageInfo bookImageInfo = bookImageInfoDao
				.getBookImageInfoByBookCode(bookInfo.getBookCode());
		Bookpublic bookpublic = bookPublicDao
				.getBookPublicByBookPublicId(bookInfo.getBookpublicId());
		Booksize booksize = bookSizeDao.getBookSizeByBooksizeId(bookInfo
				.getBooksizeId());
		Booktype booktype = bookTypeDao.getBookTypeByBookTypeId(bookInfo
				.getBooktypeId());
		Booklanguage booklanguage = bookLanguageDao
				.getBookLanguageByBooklanguageId(bookInfo.getBooklanguageId());
		Book book = new Book();
		book.setBook1DCode(bookInfo.getBookCode());
		book.setBookISBN(bookInfo.getBookBarCode());
		book.setBookname(bookInfo.getBookname());
		book.setBookType(booktype.getBooktypename());
		book.setBookAuthors(bookInfo.getBookauthors());
		book.setBookLanguage(booklanguage.getBooklanguagename());
		book.setBookContent(bookInfo.getBookcontent());
		book.setBookPublic(bookpublic.getBookpublicname());
		book.setBookEdition(bookInfo.getBookedition());
		book.setBookPublicdate(bookInfo.getPublicdate());
		book.setBookSize(booksize.getBooksizename());
		book.setBookPrintedSheets(bookInfo.getPrintedsheets());
		book.setBookNumber(bookInfo.getBooknumber());
		book.setBookImpression(bookInfo.getImpression());
		book.setBookPrintedNumber(bookInfo.getPrintednumber());
		book.setBookprice(bookInfo.getBookprice());
		book.setBookAappurtenances(bookInfo.getAppurtenances());
		if (bookInfo.getIslend() == 0)
			book.setBookIsBorrow("未借出");
		else {
			book.setBookIsBorrow("已借出");
		}
		book.setBookplace(bookInfo.getBookplace());
		if (bookImageInfo == null) {
			book.setBookImage("Upload/test.jpg");
		} else {
			book.setBookImage(bookImageInfo.getImages());
		}
		return book;
	}

	@Override
	public Book getBookByBookBarCode(String bookBarCode) throws Exception {
		// TODO Auto-generated method stub

		BookInfo bookInfo = bookInfoDao.getBookInfoByBookBarCode(bookBarCode);
		if (bookInfo == null)
			return new Book();
		else {
			// System.out.println(bookInfo.toString());
		}
		BookImageInfo bookImageInfo = bookImageInfoDao
				.getBookImageInfoByBookCode(bookInfo.getBookCode());
		Bookpublic bookpublic = bookPublicDao
				.getBookPublicByBookPublicId(bookInfo.getBookpublicId());
		Booksize booksize = bookSizeDao.getBookSizeByBooksizeId(bookInfo
				.getBooksizeId());
		Booktype booktype = bookTypeDao.getBookTypeByBookTypeId(bookInfo
				.getBooktypeId());
		Booklanguage booklanguage = bookLanguageDao
				.getBookLanguageByBooklanguageId(bookInfo.getBooklanguageId());
		Book book = new Book();
		book.setBook1DCode(bookInfo.getBookCode());
		book.setBookISBN(bookInfo.getBookBarCode());
		book.setBookname(bookInfo.getBookname());
		book.setBookType(booktype.getBooktypename());
		book.setBookAuthors(bookInfo.getBookauthors());
		book.setBookLanguage(booklanguage.getBooklanguagename());
		book.setBookContent(bookInfo.getBookcontent());
		book.setBookPublic(bookpublic.getBookpublicname());
		book.setBookEdition(bookInfo.getBookedition());
		book.setBookPublicdate(bookInfo.getPublicdate());
		book.setBookSize(booksize.getBooksizename());
		book.setBookPrintedSheets(bookInfo.getPrintedsheets());
		book.setBookNumber(bookInfo.getBooknumber());
		book.setBookImpression(bookInfo.getImpression());
		book.setBookPrintedNumber(bookInfo.getPrintednumber());
		book.setBookprice(bookInfo.getBookprice());
		book.setBookAappurtenances(bookInfo.getAppurtenances());
		if (bookInfo.getIslend() == 0)
			book.setBookIsBorrow("未借出");
		else {
			book.setBookIsBorrow("已借出");
		}
		book.setBookplace(bookInfo.getBookplace());
		book.setBookImage(bookImageInfo.getImages());
		return book;
	}

	public IBookInfoDao getBookInfoDao() {
		return bookInfoDao;
	}

	public void setBookInfoDao(IBookInfoDao bookInfoDao) {
		this.bookInfoDao = bookInfoDao;
	}

	public IBookImageInfoDao getBookImageInfoDao() {
		return bookImageInfoDao;
	}

	public void setBookImageInfoDao(IBookImageInfoDao bookImageInfoDao) {
		this.bookImageInfoDao = bookImageInfoDao;
	}

	public IBookPublicDao getBookPublicDao() {
		return bookPublicDao;
	}

	public void setBookPublicDao(IBookPublicDao bookPublicDao) {
		this.bookPublicDao = bookPublicDao;
	}

	public IBookSizeDao getBookSizeDao() {
		return bookSizeDao;
	}

	public void setBookSizeDao(IBookSizeDao bookSizeDao) {
		this.bookSizeDao = bookSizeDao;
	}

	public IBookTypeDao getBookTypeDao() {
		return bookTypeDao;
	}

	public void setBookTypeDao(IBookTypeDao bookTypeDao) {
		this.bookTypeDao = bookTypeDao;
	}

	public IBookLanguageDao getBookLanguageDao() {
		return bookLanguageDao;
	}

	public void setBookLanguageDao(IBookLanguageDao bookLanguageDao) {
		this.bookLanguageDao = bookLanguageDao;
	}

}
