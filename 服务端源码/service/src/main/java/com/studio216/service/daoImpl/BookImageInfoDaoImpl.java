package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IBookImageInfoDao;
import com.studio216.service.entity.BookImageInfo;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class BookImageInfoDaoImpl implements IBookImageInfoDao {

	public BookImageInfoDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public BookImageInfo getBookImageInfoByBookCode(String bookCode)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		BookImageInfo bookImageInfo = null;
		String hql = "select bookImageInfo from BookImageInfo bookImageInfo where bookImageInfo.bookCode=?";
		bookImageInfo = (BookImageInfo) session.createQuery(hql).setParameter(0, bookCode).uniqueResult();
		session.close();
		return bookImageInfo;
	}

}
