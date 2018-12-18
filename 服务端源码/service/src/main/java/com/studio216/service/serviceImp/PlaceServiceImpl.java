package com.studio216.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studio216.service.Idao.IPlaceDao;
import com.studio216.service.Iservice.IPlaceService;
import com.studio216.service.entity.Place;

@Service
public class PlaceServiceImpl implements IPlaceService {

	@Autowired
	private IPlaceDao placeDao;

	public PlaceServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Place> getAllPlaces() throws Exception {
		// TODO Auto-generated method stub
		return placeDao.getAllPlaces();
	}

	public IPlaceDao getPlaceDao() {
		return placeDao;
	}

	public void setPlaceDao(IPlaceDao placeDao) {
		this.placeDao = placeDao;
	}

}
