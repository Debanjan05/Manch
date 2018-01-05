package com.altimetrik.playground.usermanagement.api.test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import com.altimetrik.playground.usermanagement.api.PgAwsDirectoryBundleApi;
import com.altimetrik.playground.usermanagement.api.bean.ErrorBean;
import com.altimetrik.playground.usermanagement.api.bean.PgAwsDirectoryBundleResponse;
import com.altimetrik.playground.usermanagement.api.service.PgAwsDirectoryBundleApiService;
import com.altimetrik.playground.usermanagement.exception.NotFoundException;
@RunWith(MockitoJUnitRunner.class)
public class PgAwsDirectoryBundleApiTest {
	@Mock
	PgAwsDirectoryBundleApiService pgAwsDirectoryBundleApiService;
	@Test
	public void testFindByIdSkillTrack_Success() throws NotFoundException {
		PgAwsDirectoryBundleApi pgAwsDirectoryBundleApi=new PgAwsDirectoryBundleApi();
		PgAwsDirectoryBundleResponse directoryBundleResponse=new PgAwsDirectoryBundleResponse();
		directoryBundleResponse.setBundleId("bundleID");
		directoryBundleResponse.setDirectoryId("directoryID");
		pgAwsDirectoryBundleApi.setService(pgAwsDirectoryBundleApiService);
		given(pgAwsDirectoryBundleApiService.findByIdSkillTrack("FULL STACK DEVELOPER")).willReturn(directoryBundleResponse);
		ResponseEntity<PgAwsDirectoryBundleResponse> returnValue=pgAwsDirectoryBundleApi.findByIdSkillTrack("FULL STACK DEVELOPER");
		assertEquals(returnValue.getStatusCodeValue(),200);
	}
	@Test
	public void testFindByIdSkillTrack_Failure() throws NotFoundException {
		PgAwsDirectoryBundleApi pgAwsDirectoryBundleApi=new PgAwsDirectoryBundleApi();
		PgAwsDirectoryBundleResponse directoryBundleResponse=new PgAwsDirectoryBundleResponse();
		ErrorBean error=new ErrorBean();
		error.setCode("ERROR");
		error.setMessage("ERROR");
		directoryBundleResponse.setErrorBean(error);
		pgAwsDirectoryBundleApi.setService(pgAwsDirectoryBundleApiService);
		given(pgAwsDirectoryBundleApiService.findByIdSkillTrack("FULL STACK DEVELOPER")).willReturn(directoryBundleResponse);
		ResponseEntity<PgAwsDirectoryBundleResponse> returnValue=pgAwsDirectoryBundleApi.findByIdSkillTrack("FULL STACK DEVELOPER");
		assertEquals(returnValue.getStatusCodeValue(),400);
	}


}
