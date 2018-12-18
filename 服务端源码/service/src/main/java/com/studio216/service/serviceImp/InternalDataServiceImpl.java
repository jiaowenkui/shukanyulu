package com.studio216.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studio216.service.Idao.IInforDataDao;
import com.studio216.service.Idao.IInforImageInfoDao;
import com.studio216.service.Idao.IInforPublicDao;
import com.studio216.service.Iservice.IInternalDataService;
import com.studio216.service.bean.InternalData;
import com.studio216.service.entity.InforImageInfo;
import com.studio216.service.entity.Infordata;
import com.studio216.service.entity.Inforpublic;

@Service
public class InternalDataServiceImpl implements IInternalDataService {

	@Autowired
	private IInforDataDao inforDataDao;
	@Autowired
	private IInforImageInfoDao inforImageInfoDao;
	@Autowired
	private IInforPublicDao inforPublicDao;

	public InternalDataServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public InternalData getInternalDataByInforCode(String inforCode)
			throws Exception {
		// TODO Auto-generated method stub
		Infordata infordata = inforDataDao.getInforDataByInforCode(inforCode);
		if (infordata == null) {
			throw new Exception("找不到该科研数据");
		}
		InforImageInfo inforImageInfo = inforImageInfoDao
				.getInforImageInfoByInforCode(infordata.getInforCode());
		Inforpublic inforpublic = inforPublicDao
				.getInforPublicByInforPublicId(infordata.getInforpublicId());
		InternalData internalData = new InternalData();
		internalData.setInter1DCode(infordata.getInforCode());
		internalData.setInterISBN(infordata.getInforBarCode());
		internalData.setInterName(infordata.getInforname());
		internalData.setInterAuthors(infordata.getInforauthors());
		internalData.setInterPublic(inforpublic.getInforpublicname());
		internalData.setInterPublicDate(infordata.getPublicdate());
		internalData.setInterContent(infordata.getInforcontent());
		if (infordata.getIslend() == 0)
			internalData.setInterIsBorrow("未借出");
		else {
			internalData.setInterIsBorrow("已借出");
		}
		internalData.setInterPlace(infordata.getInforplace());
		internalData.setInterImage(inforImageInfo.getImages());
		return internalData;
	}

	@Override
	public InternalData getInternalDataByInforBarCode(String inforBarCode)
			throws Exception {
		// TODO Auto-generated method stub
		Infordata infordata = inforDataDao
				.getInforDataByInforBarCode(inforBarCode);
		if (infordata == null) {
			throw new Exception("找不到该科研数据");
		}
		InforImageInfo inforImageInfo = inforImageInfoDao
				.getInforImageInfoByInforCode(infordata.getInforCode());
		Inforpublic inforpublic = inforPublicDao
				.getInforPublicByInforPublicId(infordata.getInforpublicId());
		InternalData internalData = new InternalData();
		internalData.setInter1DCode(infordata.getInforCode());
		internalData.setInterISBN(infordata.getInforBarCode());
		internalData.setInterName(infordata.getInforname());
		internalData.setInterAuthors(infordata.getInforauthors());
		internalData.setInterPublic(inforpublic.getInforpublicname());
		internalData.setInterPublicDate(infordata.getPublicdate());
		internalData.setInterContent(infordata.getInforcontent());
		if (infordata.getIslend() == 0)
			internalData.setInterIsBorrow("未借出");
		else {
			internalData.setInterIsBorrow("已借出");
		}
		internalData.setInterPlace(infordata.getInforplace());
		internalData.setInterImage(inforImageInfo.getImages());
		return internalData;
	}

	public IInforDataDao getInforDataDao() {
		return inforDataDao;
	}

	public void setInforDataDao(IInforDataDao inforDataDao) {
		this.inforDataDao = inforDataDao;
	}

	public IInforImageInfoDao getInforImageInfoDao() {
		return inforImageInfoDao;
	}

	public void setInforImageInfoDao(IInforImageInfoDao inforImageInfoDao) {
		this.inforImageInfoDao = inforImageInfoDao;
	}

	public IInforPublicDao getInforPublicDao() {
		return inforPublicDao;
	}

	public void setInforPublicDao(IInforPublicDao inforPublicDao) {
		this.inforPublicDao = inforPublicDao;
	}

}
