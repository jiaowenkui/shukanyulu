package com.studio216.service.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IBookInfoDao;
import com.studio216.service.bean.CheckItem;
import com.studio216.service.entity.BookInfo;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class BookInfoDaoImpl extends HibernateDaoSupport implements
		IBookInfoDao {

	public BookInfoDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public BookInfo getBookInfoByBookCode(String bookCode) throws Exception {
		BookInfo bookInfo;
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		bookInfo = null;
		bookInfo = (BookInfo) session.get(BookInfo.class, bookCode);
		session.close();
		return bookInfo;
	}

	@Override
	public BookInfo getBookInfoByBookBarCode(String bookBarCode)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "select b from BookInfo b where b.bookBarCode=?";
		BookInfo bookInfo = (BookInfo) session.createQuery(hql)
				.setParameter(0, bookBarCode).uniqueResult();
		return bookInfo;
	}

	@Override
	public List<CheckItem> getCheckItemByPlace(String place) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql;
		List<BookInfo> bookInfoList;
		if (place.equals("*")) {
			hql = "select b from BookInfo b where b.bookplace is not null and b.bookplace!=''";
			bookInfoList = (List<BookInfo>) session.createQuery(hql).list();
		} else {
			hql = "select b from BookInfo b where b.bookplace=?";
			bookInfoList = (List<BookInfo>) session.createQuery(hql)
					.setParameter(0, place).list();
		}
		List<CheckItem> list = new ArrayList<CheckItem>();
		for (BookInfo bookInfo : bookInfoList) {
			CheckItem checkItem = new CheckItem();
			checkItem.setDataName(bookInfo.getBookname());
			checkItem.setCode(bookInfo.getBookCode());
			checkItem.setPlace(bookInfo.getBookplace().trim());
			if (bookInfo.getIslend() == 0)
				checkItem.setStatus("未借出");
			else {
				checkItem.setStatus("已借出");
			}
			list.add(checkItem);
		}
		return list;
	}
}
