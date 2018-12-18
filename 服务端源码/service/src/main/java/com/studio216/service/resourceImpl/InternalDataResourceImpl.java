package com.studio216.service.resourceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.studio216.service.Iresource.IInternalDataResource;
import com.studio216.service.Iservice.IInternalDataService;
import com.studio216.service.bean.InternalData;

@Path("/InternalData")
public class InternalDataResourceImpl implements IInternalDataResource {

	@Autowired
	private IInternalDataService internalDataService;

	public InternalDataResourceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Produces("application/json")
	@GET
	@Path("/getInternalDataByInforCode")
	@Override
	public InternalData getInternalDataByInforCode(
			@QueryParam("inforCode") String inforCode) {
		// TODO Auto-generated method stub
		try {
			return internalDataService.getInternalDataByInforCode(inforCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new InternalData();
		}
	}

	@Produces("application/json")
	@GET
	@Path("/getInternalDataByInforBarCode")
	@Override
	public InternalData getInternalDataByInforBarCode(
			@QueryParam("inforBarCode") String inforBarCode) {
		// TODO Auto-generated method stub
		try {
			return internalDataService
					.getInternalDataByInforBarCode(inforBarCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new InternalData();
		}
	}

	public IInternalDataService getInternalDataService() {
		return internalDataService;
	}

	public void setInternalDataService(IInternalDataService internalDataService) {
		this.internalDataService = internalDataService;
	}
}
