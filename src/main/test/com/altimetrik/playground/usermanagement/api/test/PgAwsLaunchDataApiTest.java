package com.altimetrik.playground.usermanagement.api.test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.altimetrik.playground.usermanagement.api.PgAwsLaunchDataApi;
import com.altimetrik.playground.usermanagement.api.bean.ErrorBean;
import com.altimetrik.playground.usermanagement.api.bean.PgAwsLaunchDataBean;
import com.altimetrik.playground.usermanagement.api.service.PgAwsLaunchDataApiService;
import com.altimetrik.playground.usermanagement.exception.NotFoundException;
@RunWith(MockitoJUnitRunner.class)
public class PgAwsLaunchDataApiTest {
	@Mock
	PgAwsLaunchDataApiService service;
	@Test
	public void testAddPgAwsLaunchData_Success() throws NotFoundException {
		
		PgAwsLaunchDataApi pgAwsLaunchDataApi=new PgAwsLaunchDataApi();
		PgAwsLaunchDataBean dataBean=new PgAwsLaunchDataBean();
		dataBean.setAdId("ADID");
		dataBean.setAwsClientAccessUrl("URL");
		dataBean.setRegistrationCode("CODE");
		dataBean.setWorkSpaceId("WORKSPACEID");
		given(service.addPgAwsLaunchData(dataBean)).willReturn(dataBean);
		pgAwsLaunchDataApi.setService(service);
		ResponseEntity<PgAwsLaunchDataBean> returnValue=pgAwsLaunchDataApi.addPgAwsLaunchData(dataBean);
		assertEquals(returnValue.getStatusCodeValue(),200);
	}

	@Test
	public void testFindByIdPgAwsLaunchData_Success() throws NotFoundException {
		PgAwsLaunchDataApi pgAwsLaunchDataApi=new PgAwsLaunchDataApi();
		PgAwsLaunchDataBean dataBean=new PgAwsLaunchDataBean();
		dataBean.setAdId("ADID");
		dataBean.setAwsClientAccessUrl("URL");
		dataBean.setRegistrationCode("CODE");
		dataBean.setWorkSpaceId("WORKSPACEID");
		given(service.findByIdAdId("ADID")).willReturn(dataBean);
		pgAwsLaunchDataApi.setService(service);
		ResponseEntity<PgAwsLaunchDataBean> returnValue=pgAwsLaunchDataApi.findByIdPgAwsLaunchData("ADID");
		assertEquals(returnValue.getStatusCodeValue(),200);
	}
	@Test
	public void testAddPgAwsLaunchData_Failure() throws NotFoundException {
		
		PgAwsLaunchDataApi pgAwsLaunchDataApi=new PgAwsLaunchDataApi();
		PgAwsLaunchDataBean dataBean=new PgAwsLaunchDataBean();
		ErrorBean error=new ErrorBean();
		error.setCode("ERROR");
		error.setMessage("ERROR");
		dataBean.setError(error);
		given(service.addPgAwsLaunchData(dataBean)).willReturn(dataBean);
		pgAwsLaunchDataApi.setService(service);
		ResponseEntity<PgAwsLaunchDataBean> returnValue=pgAwsLaunchDataApi.addPgAwsLaunchData(dataBean);
		assertEquals(returnValue.getStatusCodeValue(),400);
	}

	@Test
	public void testFindByIdPgAwsLaunchData_Failure() throws NotFoundException {
		PgAwsLaunchDataApi pgAwsLaunchDataApi=new PgAwsLaunchDataApi();
		PgAwsLaunchDataBean dataBean=new PgAwsLaunchDataBean();
		ErrorBean error=new ErrorBean();
		error.setCode("ERROR");
		error.setMessage("ERROR");
		dataBean.setError(error);
		given(service.findByIdAdId("ADID")).willReturn(dataBean);
		pgAwsLaunchDataApi.setService(service);
		ResponseEntity<PgAwsLaunchDataBean> returnValue=pgAwsLaunchDataApi.findByIdPgAwsLaunchData("ADID");
		assertEquals(returnValue.getStatusCodeValue(),400);
	}

}
