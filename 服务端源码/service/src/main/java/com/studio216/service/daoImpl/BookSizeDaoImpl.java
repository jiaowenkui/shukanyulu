package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IBookSizeDao;
import com.studio216.service.entity.Booksize;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class BookSizeDaoImpl implements IBookSizeDao {

	public BookSizeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Booksize getBookSizeByBooksizeId(Integer bookSizeId)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Booksize booksize = null;
		booksize = (Booksize) session.get(Booksize.class, bookSizeId);
		session.close();
		return booksize;
	}

}
