package com.altimetrik.playground.usermanagement.api.service.impl.test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import java.util.regex.Matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.altimetrik.playground.usermanagement.api.bean.PgAwsLaunchDataBean;
import com.altimetrik.playground.usermanagement.api.service.impl.PgAwsLaunchDataApiServiceImpl;
import com.altimetrik.playground.usermanagement.exception.NotFoundException;
import com.altimetrik.playground.usermanagement.models.PgAwsLaunchData;
import com.altimetrik.playground.usermanagement.models.PgUserInfoDtls;
import com.altimetrik.playground.usermanagement.models.repository.PgAwsLaunchDataRepository;
import com.altimetrik.playground.usermanagement.models.repository.PgUserInfoDtlsRepository;
@RunWith(MockitoJUnitRunner.class)
public class PgAwsLaunchDataApiServiceImplTest {
	@Mock
	 private PgAwsLaunchDataRepository  pgAwsLaunchDataRepository ;
	@Mock
	private PgUserInfoDtlsRepository  pgUserInfoDtlsRepository;
	@Test
	public void testAddPgAwsLaunchData_Success() throws NotFoundException {
		PgAwsLaunchDataBean response = new PgAwsLaunchDataBean();
		PgAwsLaunchDataBean dataBean = new PgAwsLaunchDataBean();
		PgAwsLaunchDataApiServiceImpl serviceImpl = new PgAwsLaunchDataApiServiceImpl();
		PgAwsLaunchData data = new PgAwsLaunchData();
		data.setAdId("ADID");
		data.setAwsClientAccessUrl("url");
		data.setLaunchId(1L);
		data.setRegistrationCode("RegistrationCode");
		data.setWorkspaceId("WorkspaceId");
		PgUserInfoDtls infoDtls = new PgUserInfoDtls();
		infoDtls.setAdId("ADID");
		infoDtls.setEmailId("email@email.com");
		dataBean.setAdId("ADID");
		dataBean.setAwsClientAccessUrl("URL");
		dataBean.setRegistrationCode("RegistrationCode");
		dataBean.setWorkSpaceId("WORKSPACEId");
		data.setPgUserInfoDtls(infoDtls);
		serviceImpl.setPgAwsLaunchDataRepository(pgAwsLaunchDataRepository);
		serviceImpl.setPgUserInfoDtlsRepository(pgUserInfoDtlsRepository);
		given(pgUserInfoDtlsRepository.findAllByAdId(dataBean.getAdId())).willReturn(infoDtls);
		given(pgAwsLaunchDataRepository.findAllByAdId(dataBean.getAdId())).willReturn(null);
		given(pgAwsLaunchDataRepository.save(Matchers.any(PgAwsLaunchData.class))).willReturn(data);
		response = serviceImpl.addPgAwsLaunchData(dataBean);
		assertNull(response.getError());
	}
	@Test
	public void testAddPgAwsLaunchData_DuplicateFailure() throws NotFoundException {
		PgAwsLaunchDataBean response = new PgAwsLaunchDataBean();
		PgAwsLaunchDataBean dataBean = new PgAwsLaunchDataBean();
		PgAwsLaunchDataApiServiceImpl serviceImpl = new PgAwsLaunchDataApiServiceImpl();
		PgAwsLaunchData data = new PgAwsLaunchData();
		data.setAdId("ADID");
		data.setAwsClientAccessUrl("url");
		data.setLaunchId(1L);
		data.setRegistrationCode("RegistrationCode");
		data.setWorkspaceId("WorkspaceId");
		PgUserInfoDtls infoDtls = new PgUserInfoDtls();
		infoDtls.setAdId("ADID");
		infoDtls.setEmailId("email@email.com");
		dataBean.setAdId("ADID");
		dataBean.setAwsClientAccessUrl("URL");
		dataBean.setRegistrationCode("CODE");
		dataBean.setWorkSpaceId("WORKSPACEID");
		serviceImpl.setPgAwsLaunchDataRepository(pgAwsLaunchDataRepository);
		serviceImpl.setPgUserInfoDtlsRepository(pgUserInfoDtlsRepository);
		given(pgUserInfoDtlsRepository.findAllByAdId(dataBean.getAdId())).willReturn(infoDtls);
		given(pgAwsLaunchDataRepository.findAllByAdId(dataBean.getAdId())).willReturn(data);
		given(pgAwsLaunchDataRepository.save(data)).willReturn(data);
		response = serviceImpl.addPgAwsLaunchData(dataBean);
		assertNotNull(response.getError());
	}
	@Test
	public void testAddPgAwsLaunchData_InvalidADIDFailure() throws NotFoundException {
		PgAwsLaunchDataBean response = new PgAwsLaunchDataBean();
		PgAwsLaunchDataBean dataBean = new PgAwsLaunchDataBean();
		PgAwsLaunchDataApiServiceImpl serviceImpl = new PgAwsLaunchDataApiServiceImpl();
		PgAwsLaunchData data = new PgAwsLaunchData();
		PgUserInfoDtls infoDtls = new PgUserInfoDtls();
		infoDtls.setAdId("ADID");
		infoDtls.setEmailId("email@email.com");
		data.setAdId("ADID");
		data.setAwsClientAccessUrl("url");
		data.setLaunchId(1L);
		data.setRegistrationCode("RegistrationCode");
		data.setWorkspaceId("WorkspaceId");
		
		dataBean.setAdId("ADID");
		dataBean.setAwsClientAccessUrl("URL");
		dataBean.setRegistrationCode("CODE");
		dataBean.setWorkSpaceId("WORKSPACEID");
		serviceImpl.setPgAwsLaunchDataRepository(pgAwsLaunchDataRepository);
		serviceImpl.setPgUserInfoDtlsRepository(pgUserInfoDtlsRepository);
		given(pgUserInfoDtlsRepository.findAllByAdId(dataBean.getAdId())).willReturn(null);
		given(pgAwsLaunchDataRepository.findAllByAdId(dataBean.getAdId())).willReturn(data);
		given(pgAwsLaunchDataRepository.save(data)).willReturn(data);
		response = serviceImpl.addPgAwsLaunchData(dataBean);
		assertNotNull(response.getError());
	}

	@Test
	public void testFindByIdAdId_Success() {
	}

}
