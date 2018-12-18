package com.studio216.service.Idao;

import java.util.List;

import com.studio216.service.entity.Place;

public interface IPlaceDao {
	public List<Place> getAllPlaces() throws Exception;
}
