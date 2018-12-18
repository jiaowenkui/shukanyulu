package com.studio216.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studio216.service.Idao.IBookLanguageDao;
import com.studio216.service.Idao.ILongDao;
import com.studio216.service.Idao.IMagazineImageInfoDao;
import com.studio216.service.Idao.IMagazineInfoDao;
import com.studio216.service.Idao.IMagazinePublicDao;
import com.studio216.service.Iservice.IMagazineService;
import com.studio216.service.bean.Magazine;
import com.studio216.service.entity.Booklanguage;
import com.studio216.service.entity.Long;
import com.studio216.service.entity.MagazineImageInfo;
import com.studio216.service.entity.MagazineInfo;
import com.studio216.service.entity.Magazinepublic;

@Service
public class MagazineServiceImpl implements IMagazineService {

	@Autowired
	private IMagazineInfoDao magazineInfoDao;
	@Autowired
	private IMagazinePublicDao magazinePublicDao;
	@Autowired
	private IMagazineImageInfoDao magazineImageInfoDao;
	@Autowired
	private IBookLanguageDao bookLanguageDao;
	@Autowired
	private ILongDao longDao;

	public MagazineServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Magazine getMagazineByMagaCode(String magaCode) throws Exception {
		// TODO Auto-generated method stub
		MagazineInfo magazineInfo = magazineInfoDao
				.getMagazineInfoByMagaCode(magaCode);
		if (magazineInfo == null) {
			throw new Exception("没有该杂志");
		}
		int magapublicId = Integer.parseInt(magazineInfo.getMagapublicId());
		MagazineImageInfo magazineImageInfo = magazineImageInfoDao
				.getMagazineImageInfoByMagaCode(magazineInfo.getMagaCode());
		Magazinepublic magazinepublic = magazinePublicDao
				.getMagazinePublicByMagaCode(magapublicId);
		Booklanguage booklanguage = bookLanguageDao
				.getBookLanguageByBooklanguageId(magazineInfo
						.getMagalanguageId());
		Long long1 = longDao.getLongByLongId(magazineInfo.getLongId());
		Magazine magazine = new Magazine();
		magazine.setMagazine1DCode(magazineInfo.getMagaCode());
		magazine.setMagazineISBN(magazineInfo.getMagaBarCode());
		magazine.setMagazineName(magazineInfo.getMaganame());
		magazine.setMagazinePublic(magazinepublic.getMagapublicname());
		magazine.setMagazinePrice(magazineInfo.getMagaprice());
		magazine.setMagazineLanguage(booklanguage.getBooklanguagename());
		magazine.setMagazinePublicYear(magazineInfo.getMagapublicyear());
		magazine.setMagazinePeriod(magazineInfo.getSumperiod());
		magazine.setMagazineLong(long1.getLongname());
		magazine.setMagazineVolume(magazineInfo.getVolume());
		magazine.setMagazineSint(magazineInfo.getSint());
		magazine.setMagazinePlace(magazineInfo.getMagaplace());
		if (magazineInfo.getIslend() == 0)
			magazine.setMagazineIsBorrow("未借出");
		else {
			magazine.setMagazineIsBorrow("已借出");
		}
		magazine.setMagazineImage(magazineImageInfo.getImages());
		return magazine;
	}

	@Override
	public Magazine getMagazineByMagaBarCode(String magaBarCode)
			throws Exception {
		// TODO Auto-generated method stub
		MagazineInfo magazineInfo = magazineInfoDao
				.getMagazineInfoByMagaBarCode(magaBarCode);
		if (magazineInfo == null) {
			throw new Exception("没有该杂志");
		}
		int magapublicId = Integer.parseInt(magazineInfo.getMagapublicId());
		MagazineImageInfo magazineImageInfo = magazineImageInfoDao
				.getMagazineImageInfoByMagaCode(magazineInfo.getMagaCode());
		Magazinepublic magazinepublic = magazinePublicDao
				.getMagazinePublicByMagaCode(magapublicId);
		Booklanguage booklanguage = bookLanguageDao
				.getBookLanguageByBooklanguageId(magazineInfo
						.getMagalanguageId());
		Long long1 = longDao.getLongByLongId(magazineInfo.getLongId());
		Magazine magazine = new Magazine();
		magazine.setMagazine1DCode(magazineInfo.getMagaCode());
		magazine.setMagazineISBN(magazineInfo.getMagaBarCode());
		magazine.setMagazineName(magazineInfo.getMaganame());
		magazine.setMagazinePublic(magazinepublic.getMagapublicname());
		magazine.setMagazinePrice(magazineInfo.getMagaprice());
		magazine.setMagazineLanguage(booklanguage.getBooklanguagename());
		magazine.setMagazinePublicYear(magazineInfo.getMagapublicyear());
		magazine.setMagazinePeriod(magazineInfo.getSumperiod());
		magazine.setMagazineLong(long1.getLongname());
		magazine.setMagazineVolume(magazineInfo.getVolume());
		magazine.setMagazineSint(magazineInfo.getSint());
		magazine.setMagazinePlace(magazineInfo.getMagaplace());
		if (magazineInfo.getIslend() == 0)
			magazine.setMagazineIsBorrow("未借出");
		else {
			magazine.setMagazineIsBorrow("已借出");
		}
		magazine.setMagazineImage(magazineImageInfo.getImages());
		return magazine;
	}

	public IMagazineInfoDao getMagazineInfoDao() {
		return magazineInfoDao;
	}

	public void setMagazineInfoDao(IMagazineInfoDao magazineInfoDao) {
		this.magazineInfoDao = magazineInfoDao;
	}

	public IMagazinePublicDao getMagazinePublicDao() {
		return magazinePublicDao;
	}

	public void setMagazinePublicDao(IMagazinePublicDao magazinePublicDao) {
		this.magazinePublicDao = magazinePublicDao;
	}

	public IMagazineImageInfoDao getMagazineImageInfoDao() {
		return magazineImageInfoDao;
	}

	public void setMagazineImageInfoDao(
			IMagazineImageInfoDao magazineImageInfoDao) {
		this.magazineImageInfoDao = magazineImageInfoDao;
	}

}
