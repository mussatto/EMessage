package com.curupira;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.Closeable;

public class EMessageTest {
	
	private final LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	Closeable session;
	@Before
	public void setUp() {
		session = ObjectifyService.begin();
		ObjectifyService.register(EMessage.class);
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
		EMessage message = new EMessage(id, title, content, language, lastUpdated);
		
		message.persist();
		
		System.out.println("id generated:"+message.getId());
		
		EMessage messagefound = EMessage.find(message.getId());
		System.out.println("Message sent:"+message.getContent());
		System.out.println("Message found:"+messagefound.getContent());
		
	}
	
	@Test
	public void testEncoding(){
		String text = "i am going to encode this text";
		String pass = "password";
		String encodedText = MessageEncoder.encode(text, pass);
		System.out.println(encodedText);
		
		String decodedText = MessageEncoder.decode(encodedText, pass);
		
		System.out.println(decodedText);
				
	}

}
