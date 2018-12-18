package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IBookTypeDao;
import com.studio216.service.entity.Booktype;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class BookTypeDaoImpl implements IBookTypeDao {

	public BookTypeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Booktype getBookTypeByBookTypeId(Integer bookTypeId)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Booktype booktype = null;
		booktype = (Booktype) session.get(Booktype.class, bookTypeId);
		session.close();
		return booktype;
	}

}
