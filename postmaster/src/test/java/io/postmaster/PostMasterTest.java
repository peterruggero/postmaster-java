package io.postmaster;

import io.postmaster.core.PostMasterClient;

import org.junit.Before;

public class PostMasterTest {

	@Before
	public void setUp() {
		//TODO use always working development data or comment with YOUR_API_KEY, YOUR_API_DOMAIN
		PostMasterClient.initialize(
				"tt_MTEwMDE6MVZCS2t2bWtBZG1NbkpYeUctdWFETlRFby1r",
				"https://staging.api.postmaster.io");
	}

}
