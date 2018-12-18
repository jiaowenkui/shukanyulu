package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IBookPublicDao;
import com.studio216.service.entity.Bookpublic;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class BookPublicDaoImpl implements IBookPublicDao {

	public BookPublicDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Bookpublic getBookPublicByBookPublicId(Integer bookPublicId)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Bookpublic bookpublic = null;
		bookpublic = (Bookpublic) session.get(Bookpublic.class, bookPublicId);
		session.close();
		return bookpublic;
	}

}
