package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IInforPublicDao;
import com.studio216.service.entity.Inforpublic;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class IInforPublicDaoImpl implements IInforPublicDao {

	
	public IInforPublicDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Inforpublic getInforPublicByInforPublicId(Integer inforPublicId)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Inforpublic inforpublic = (Inforpublic)session.get(Inforpublic.class, inforPublicId);
		return inforpublic;
	}

}
