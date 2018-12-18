package com.studio216.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studio216.service.Idao.IBookInfoDao;
import com.studio216.service.Idao.IInforDataDao;
import com.studio216.service.Idao.IMagazineInfoDao;
import com.studio216.service.Idao.IOtherDao;
import com.studio216.service.Iservice.IOtherService;
import com.studio216.service.bean.CheckItem;
import com.studio216.service.daoImpl.BookInfoDaoImpl;
import com.studio216.service.daoImpl.InforDataDaoImpl;
import com.studio216.service.daoImpl.MagazineInfoDaoImpl;

@Service
public class OtherServiceImpl implements IOtherService {

	@Autowired
	private IOtherDao otherDao;

	public OtherServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTypeByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return otherDao.getTypeByCode(code);
	}

	@Override
	public String getTypeByBarCode(String barCode) throws Exception {
		// TODO Auto-generated method stub
		return otherDao.getTypeByBarCode(barCode);
	}

	public IOtherDao getOtherDao() {
		return otherDao;
	}

	public void setOtherDao(IOtherDao otherDao) {
		this.otherDao = otherDao;
	}

	@Override
	public List<CheckItem> getCheckItemByPlace(String place) throws Exception {
		// TODO Auto-generated method stub
		IBookInfoDao bookInfoDao = new BookInfoDaoImpl();
		IMagazineInfoDao magazineInfoDao = new MagazineInfoDaoImpl();
		IInforDataDao inforDataDao = new InforDataDaoImpl();
		List<CheckItem> list = new ArrayList<CheckItem>();
		list.addAll(bookInfoDao.getCheckItemByPlace(place));
		list.addAll(magazineInfoDao.getCheckItemByPlace(place));
		list.addAll(inforDataDao.getCheckItemByPlace(place));
		return list;
	}

}
