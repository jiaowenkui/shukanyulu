package com.studio216.service.resourceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.studio216.service.Iresource.IOtherResource;
import com.studio216.service.Iservice.IOtherService;
import com.studio216.service.bean.CheckItem;

@Path("/Other")
public class OtherResourceImpl implements IOtherResource {

	@Autowired
	private IOtherService otherService;

	public OtherResourceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	@GET
	@Path("/getTypeByCode")
	public String getTypeByCode(@QueryParam("code") String code) {
		// TODO Auto-generated method stub
		try {
			return otherService.getTypeByCode(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
	}

	@Override
	@GET
	@Path("/getTypeByBarCode")
	public String getTypeByBarCode(@QueryParam("barCode") String barCode) {
		// TODO Auto-generated method stub
		try {
			return otherService.getTypeByBarCode(barCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "0";
		}
	}
	@GET
	@Path("/getCheckItemByPlace")
	@Override
	public List<CheckItem> getCheckItemByPlace(@QueryParam("place") String place) {
		// TODO Auto-generated method stub
		try {
			return otherService.getCheckItemByPlace(place);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			return new ArrayList<CheckItem>();
			e.printStackTrace();
		}
		return null;
	}

	public IOtherService getOtherService() {
		return otherService;
	}

	public void setOtherService(IOtherService otherService) {
		this.otherService = otherService;
	}

}
