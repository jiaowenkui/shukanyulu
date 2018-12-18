package com.studio216.service.resourceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.studio216.service.Iresource.IPlaceResource;
import com.studio216.service.Iservice.IPlaceService;
import com.studio216.service.entity.Place;

@Path("/Place")
public class PlaceResourceImpl implements IPlaceResource {

	@Autowired
	private IPlaceService placeService;

	public PlaceResourceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	@Produces("application/json")
	@GET
	@Path("/getAllPlaces")
	public List<Place> getAllPlaces() {
		// TODO Auto-generated method stub
		try {
			return placeService.getAllPlaces();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Place>();
		}
	}

	public IPlaceService getPlaceService() {
		return placeService;
	}

	public void setPlaceService(IPlaceService placeService) {
		this.placeService = placeService;
	}

}
