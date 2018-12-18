package com.studio216.service.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IInforDataDao;
import com.studio216.service.bean.CheckItem;
import com.studio216.service.entity.Infordata;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class InforDataDaoImpl implements IInforDataDao {

	public InforDataDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Infordata getInforDataByInforCode(String inforCode) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Infordata infordata = (Infordata) session.get(Infordata.class,
				inforCode);
		session.close();
		return infordata;
	}

	@Override
	public Infordata getInforDataByInforBarCode(String inforBarCode)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "select i from Infordata i where i.inforBarCode=?";
		Infordata infordata = (Infordata) session.createQuery(hql)
				.setParameter(0, inforBarCode).uniqueResult();
		return infordata;
	}

	public List<CheckItem> getCheckItemByPlace(String place) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql;
		List<Infordata> infordataList;
		if (place.equals("")) {
			hql = "select i from Infordata i where i.inforplace is not null and i.inforplace!=''";
			infordataList = (List<Infordata>) session.createQuery(hql).list();
		} else {
			hql = "select i from Infordata i where i.inforplace=?";
			infordataList = (List<Infordata>) session.createQuery(hql)
					.setParameter(0, place).list();
		}
		List<CheckItem> list = new ArrayList<CheckItem>();
		for (Infordata infordata : infordataList) {
			CheckItem checkItem = new CheckItem();
			checkItem.setDataName(infordata.getInforname());
			checkItem.setCode(infordata.getInforname());
			checkItem.setPlace(infordata.getInforplace().trim());
			if (infordata.getIslend() == 0)
				checkItem.setStatus("未借出");
			else {
				checkItem.setStatus("已借出");
			}
			list.add(checkItem);
		}
		return list;
	}
}
