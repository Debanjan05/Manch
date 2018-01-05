package com.altimetrik.playground.usermanagement.api.service.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import com.altimetrik.playground.usermanagement.api.bean.PgAwsDirectoryBundleResponse;
import com.altimetrik.playground.usermanagement.api.service.impl.PgAwsDirectoryBundleApiServiceImpl;
import com.altimetrik.playground.usermanagement.models.PgAwsDirectoryBundle;
import com.altimetrik.playground.usermanagement.models.PgSkillTrackMstr;
import com.altimetrik.playground.usermanagement.models.repository.PgAwsDirectoryBundleRepository;
import com.altimetrik.playground.usermanagement.models.repository.PgSkillTrackMstrRepository;
@RunWith(MockitoJUnitRunner.class)
public class PgAwsDirectoryBundleApiServiceImplTest {
	@Mock
	private PgAwsDirectoryBundleRepository pgAwsDirectoryBundleRepository;
	@Mock
	private PgSkillTrackMstrRepository  pgSkillTrackMstrRepository;
	@Test
	public void testFindByIdSkillTrack_Success() {
		PgAwsDirectoryBundleResponse awsDirectoryBundleResponse=new PgAwsDirectoryBundleResponse();
		PgAwsDirectoryBundleApiServiceImpl pgAwsDirectoryBundleApiServiceImpl=new PgAwsDirectoryBundleApiServiceImpl();
		PgAwsDirectoryBundle awsDirectoryBundle=new PgAwsDirectoryBundle();
		PgSkillTrackMstr pgSkillMstr=new PgSkillTrackMstr();
		pgSkillMstr.setSkillTrackName("FSD");
		pgSkillMstr.setDescription("FULL STACK DEVELOPER");
		pgSkillMstr.setStatus("ACTIVE");
		awsDirectoryBundle.setPgSkillTrackMstr(pgSkillMstr);
		awsDirectoryBundle.setBundleId("BUNDLEID");
		awsDirectoryBundle.setDirectoryId("DIRECTORYID");
		pgAwsDirectoryBundleApiServiceImpl.setPgSkillTrackMstrRepository(pgSkillTrackMstrRepository);
		pgAwsDirectoryBundleApiServiceImpl.setPgAwsDirectoryBundleRepository(pgAwsDirectoryBundleRepository);
		given(pgSkillTrackMstrRepository.findAllByDescription("FULL STACK DEVELOPER")).willReturn(pgSkillMstr);
		given(pgAwsDirectoryBundleRepository.findAllByPgSkillTrackMstr(pgSkillMstr)).willReturn(awsDirectoryBundle);
		awsDirectoryBundleResponse=pgAwsDirectoryBundleApiServiceImpl.findByIdSkillTrack("FULL STACK DEVELOPER");
		assertNull(awsDirectoryBundleResponse.getError());
	}
	@Test
	public void testFindByIdSkillTrack_Failure() {
		PgAwsDirectoryBundleResponse awsDirectoryBundleResponse=new PgAwsDirectoryBundleResponse();
		PgAwsDirectoryBundleApiServiceImpl pgAwsDirectoryBundleApiServiceImpl=new PgAwsDirectoryBundleApiServiceImpl();
		PgAwsDirectoryBundle awsDirectoryBundle=new PgAwsDirectoryBundle();
		PgSkillTrackMstr pgSkillMstr=null;
		pgAwsDirectoryBundleApiServiceImpl.setPgSkillTrackMstrRepository(pgSkillTrackMstrRepository);
		pgAwsDirectoryBundleApiServiceImpl.setPgAwsDirectoryBundleRepository(pgAwsDirectoryBundleRepository);
		given(pgSkillTrackMstrRepository.findAllByDescription("FULL STACK DEVELOPER")).willReturn(pgSkillMstr);
		awsDirectoryBundleResponse=pgAwsDirectoryBundleApiServiceImpl.findByIdSkillTrack("FULL STACK DEVELOPER");
		assertNotNull(awsDirectoryBundleResponse.getError());
	}

}
