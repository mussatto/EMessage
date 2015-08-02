package com.curupira;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.curupira.entity.EMessage;
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
		System.out.println("----------testPersistence");
		String id=null;
		String title="My Prayer Title";
		String content="Is this the real life? Is this just a fantasy?";
		String language="en";
		Date lastUpdated=new Date();
		EMessage message = EMessage.createMessage(id, title, content, language, lastUpdated,null);
		
		message.persist();
		
		System.out.println("id generated:"+message.getId());
		
		EMessage messagefound = EMessage.find(message.getId());
		System.out.println("Message sent:"+message.getContent());
		System.out.println("Message found:"+messagefound.getContent());
		
		assertEquals(message.getContent(), messagefound.getContent());
		assertNotEquals(null, message.getPass());
		System.out.println(message.getPass());
		
	}
	
	@Test
	public void testEncoding(){
		System.out.println("----------testEncoding");
		String text = "i am going to encode this text";
		String pass = UUID.randomUUID().toString();
		System.out.println("pass:"+pass);
		String encodedText = MessageEncoder.encode(text, pass);
		System.out.println("encodedText:"+encodedText);
		
		String decodedText = MessageEncoder.decode(encodedText, pass);
		
		System.out.println("decodedText:"+decodedText);
	}
	
	@Test
	public void testEncodingLargeString(){
		System.out.println("----------testEncodingLARGE");
		String text = "i am going to encode this text that is very very very large"+
		"and have multiple lines that keep going on and on forever"+
		"and i have no more ideas of what to write in this line";
		String pass = UUID.randomUUID().toString();
		System.out.println("pass:"+pass);
		String encodedText = MessageEncoder.encode(text, pass);
		System.out.println("encodedText:"+encodedText);
		
		String decodedText = MessageEncoder.decode(encodedText, pass);
		
		System.out.println("decodedText:"+decodedText);
	}

}
