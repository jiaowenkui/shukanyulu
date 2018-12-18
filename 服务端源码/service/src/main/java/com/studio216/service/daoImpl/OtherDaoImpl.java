package com.studio216.service.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.studio216.service.Idao.IOtherDao;
import com.studio216.service.hibernateUtil.HibernateSessionFactory;

@Repository
public class OtherDaoImpl implements IOtherDao {

	public OtherDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTypeByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		String bookHql = "select count(*) from BookInfo where bookCode=?";
		String magazineHql = "select count(*) from MagazineInfo m where m.magaCode=?";
		String inforHql = "select count(*) from Infordata i where i.inforCode=?";
		Session session = HibernateSessionFactory.getSession();
		Number bookNubNumber = (Number) session.createQuery(bookHql).setParameter(0, code)
				.uniqueResult();
		Number magazineNumber = (Number) session.createQuery(magazineHql).setParameter(0, code)
				.uniqueResult();
		Number inforNumber = (Number) session.createQuery(inforHql).setParameter(0, code)
				.uniqueResult();
		if (bookNubNumber.intValue() != 0) {
			return "1";
		} else if (magazineNumber.intValue() != 0) {
			return "2";
		} else if (inforNumber.intValue() != 0) {
			return "3";
		} else {
			return "0";
		}
	}

	@Override
	public String getTypeByBarCode(String barCode) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String bookHql = "select count(b) from BookInfo b where b.bookBarCode=?";
		String magazineHql = "select count(m) from MagazineInfo m where m.magaBarCode=?";
		String inforHql = "select count(i) from Infordata i where i.inforBarCode=?";
		Number bookNubNumber = (Number) session.createQuery(bookHql)
				.setString(0, barCode).uniqueResult();
		Number magazineNumber = (Number) session.createQuery(magazineHql)
				.setString(0, barCode).uniqueResult();
		Number inforNumber = (Number) session.createQuery(inforHql)
				.setString(0, barCode).uniqueResult();
		if (bookNubNumber.intValue() != 0) {
			return "1";
		} else if (magazineNumber.intValue() != 0) {
			return "2";
		} else if (inforNumber.intValue() != 0) {
			return "3";
		} else {
			return "0";
		}
	}

}
