package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IMagazinePublicDao;
import com.studio216.service.entity.Magazinepublic;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class MagazinePublicDaoImpl implements IMagazinePublicDao {

	public MagazinePublicDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Magazinepublic getMagazinePublicByMagaCode(Integer magapublicId)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Magazinepublic magazinepublic = (Magazinepublic) session.get(
				Magazinepublic.class, magapublicId);
		session.close();
		return magazinepublic;
	}

}
