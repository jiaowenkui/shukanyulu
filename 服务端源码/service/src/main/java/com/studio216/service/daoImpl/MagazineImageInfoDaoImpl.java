package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IMagazineImageInfoDao;
import com.studio216.service.entity.MagazineImageInfo;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class MagazineImageInfoDaoImpl implements IMagazineImageInfoDao {

	public MagazineImageInfoDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public MagazineImageInfo getMagazineImageInfoByMagaCode(String magaCode)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "select m from MagazineImageInfo m where m.magaCode=?";
		MagazineImageInfo magazineImageInfo = (MagazineImageInfo) session
				.createQuery(hql).setParameter(0, magaCode).uniqueResult();
		session.close();
		return magazineImageInfo;
	}

}
