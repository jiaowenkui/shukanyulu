package com.studio216.service.resourceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.studio216.service.Iresource.IMagazineResource;
import com.studio216.service.Iservice.IMagazineService;
import com.studio216.service.bean.Magazine;

@Path("/Magazine")
public class MagazineResourceImpl implements IMagazineResource {

	@Autowired
	private IMagazineService magazineService;

	public MagazineResourceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Produces("application/json")
	@GET
	@Path("/getMagazineByMagaCode")
	@Override
	public Magazine getMagazineByMagaCode(
			@QueryParam("magaCode") String magaCode) {
		// TODO Auto-generated method stub
		try {
			return magazineService.getMagazineByMagaCode(magaCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new Magazine();
		}
	}

	@Produces("application/json")
	@GET
	@Path("/getMagazineByMagaBarCode")
	@Override
	public Magazine getMagazineByMagaBarCode(
			@QueryParam("magaBarCode") String magaBarCode) {
		// TODO Auto-generated method stub
		try {
			return magazineService.getMagazineByMagaBarCode(magaBarCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new Magazine();
		}
	}

	public IMagazineService getMagazineService() {
		return magazineService;
	}

	public void setMagazineService(IMagazineService magazineService) {
		this.magazineService = magazineService;
	}
}
