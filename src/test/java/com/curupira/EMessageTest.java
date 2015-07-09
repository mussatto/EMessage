package com.curupira;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class EMessageTest {
	
	private final LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	
	@Before
	public void setUp() {
		helper.setUp();
	}
	
	@After
	public void tearDown(){
		helper.tearDown();
	}
	
	@Test
	public void testPersistence(){
		String id=null;
		String title="My Prayer Title";
		String content="Is this the real life? Is this just a fantasy?";
		String language="en";
		Date lastUpdated=new Date();
		EMessage prayer = new EMessage(id, title, content, language, lastUpdated);
		
		prayer.persist();
		
		System.out.println("id generated:"+prayer.getId());
		
		
	}

}
