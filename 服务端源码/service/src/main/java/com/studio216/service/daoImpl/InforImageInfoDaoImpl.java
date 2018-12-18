package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IInforImageInfoDao;
import com.studio216.service.entity.InforImageInfo;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class InforImageInfoDaoImpl implements IInforImageInfoDao {

	
	public InforImageInfoDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public InforImageInfo getInforImageInfoByInforCode(String inforCode)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "select i from InforImageInfo i where i.inforCode=?";
		InforImageInfo inforImageInfo = (InforImageInfo) session.createQuery(
				hql).setParameter(0, inforCode).uniqueResult();
		session.close();
		return inforImageInfo;
	}
}
