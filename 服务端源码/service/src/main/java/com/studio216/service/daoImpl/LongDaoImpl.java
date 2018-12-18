package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.ILongDao;
import com.studio216.service.entity.Long;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class LongDaoImpl implements ILongDao {

	public LongDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long getLongByLongId(Integer longId) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Long long1 = (Long) session.get(Long.class, longId);
		session.close();
		return long1;
	}

}
