package de.kendel.simtru.model.service;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class DiscussionServiceTest extends ServiceTest{
	
	@Test
	@Transactional
	@Rollback
	public void testSaveAndFind()
	{
		
	}

}
