package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.studio216.service.Idao.IBookLanguageDao;
import com.studio216.service.entity.Booklanguage;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Service
public class BookLanguageDaoImpl implements IBookLanguageDao {

	public BookLanguageDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Booklanguage getBookLanguageByBooklanguageId(Integer booklanguageId)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Booklanguage booklanguage = null;
		booklanguage = (Booklanguage) session.get(Booklanguage.class,
				booklanguageId);
		session.close();
		return booklanguage;
	}

}
