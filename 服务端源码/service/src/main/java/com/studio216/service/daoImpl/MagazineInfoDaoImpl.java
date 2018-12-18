package com.studio216.service.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IMagazineInfoDao;
import com.studio216.service.bean.CheckItem;
import com.studio216.service.entity.MagazineInfo;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class MagazineInfoDaoImpl implements IMagazineInfoDao {

	public MagazineInfoDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public MagazineInfo getMagazineInfoByMagaCode(String magaCode)
			throws Exception {
		Session session = HibernateSessionFactory.getSession();
		MagazineInfo magazineInfo = (MagazineInfo) session.get(
				MagazineInfo.class, magaCode);
		session.close();
		return magazineInfo;
	}

	@Override
	public MagazineInfo getMagazineInfoByMagaBarCode(String magaBarCode)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hql = "select m from MagazineInfo m where m.magaBarCode=?";
		MagazineInfo magazineInfo = (MagazineInfo) session.createQuery(hql)
				.setParameter(0, magaBarCode).uniqueResult();
		return magazineInfo;
	}

	public List<CheckItem> getCheckItemByPlace(String place) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		List<MagazineInfo> magazineInfoList;
		String hql;
		if (place.equals("*")) {
			hql = "select m from MagazineInfo m where m.magaplace is not null and m.magaplace!=''";
			magazineInfoList = (List<MagazineInfo>) session.createQuery(hql)
					.list();
		} else {
			hql = "select m from MagazineInfo m where m.magaplace=?";
			magazineInfoList = (List<MagazineInfo>) session.createQuery(hql)
					.setParameter(0, place).list();
		}
		List<CheckItem> list = new ArrayList<CheckItem>();
		for (MagazineInfo magazineInfo : magazineInfoList) {
			CheckItem checkItem = new CheckItem();
			checkItem.setDataName(magazineInfo.getMaganame());
			checkItem.setCode(magazineInfo.getMagaCode());
			checkItem.setPlace(magazineInfo.getMagaplace().trim());
			if (magazineInfo.getIslend() == 0)
				checkItem.setStatus("未借出");
			else {
				checkItem.setStatus("已借出");
			}
			list.add(checkItem);
		}
		return list;
	}
}
