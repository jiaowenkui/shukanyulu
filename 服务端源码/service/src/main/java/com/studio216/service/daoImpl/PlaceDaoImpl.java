package com.studio216.service.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IPlaceDao;
import com.studio216.service.entity.Place;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class PlaceDaoImpl implements IPlaceDao {

	
	public PlaceDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Place> getAllPlaces() throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		@SuppressWarnings("unchecked")
		List<Place> list = session.createQuery("from Place").list();
		session.close();
		return list;
	}

}
