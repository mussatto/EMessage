package com.curupira.entity;

import java.util.Date;
import java.util.UUID;

import com.curupira.MessageEncoder;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;

@Entity
public class EMessage {
	
	public EMessage(){
		
	}
	private EMessage(String id, String title, String content, String language, Date lastUpdated, String pass) {
		super();
		this.title = title;
		this.content = content;
		this.language = language;
		this.lastUpdated = lastUpdated;
		this.pass = pass;
	}
	
	public static EMessage createMessage(String id, 
			String title, 
			String content, 
			String language, 
			Date lastUpdated, 
			String pass) {
		EMessage emessage;
		if(pass!=null)
			emessage = new EMessage(id,title, content, language, lastUpdated,pass);
		else
			emessage = new EMessage(id,title, content, language, lastUpdated,UUID.randomUUID().toString());
		return emessage;
	}
	
	@Id
	private Long id;

	private String title;
	
	private String content;
		
	private String language;
	
	private Date lastUpdated;
	
	@Ignore
	private String pass;
	

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}

	public String getLanguage() {
		return language;
	}

	public static EMessage findById(String id2) {
		return null;
	}
	
	public void persist(){
	    ObjectifyService.ofy().save().entity(this).now();
	}
	
	
	public void encodeContent(){
		this.content = MessageEncoder.encode(content, getPass());
	}

	public String getPass() {
		return pass;
	}
	
	public static EMessage find(long id){
		Objectify ofy = ObjectifyService.ofy();
		ofy = ObjectifyService.ofy();
		return ofy.load().type(EMessage.class).id(id).now();
	}
	
	public String decodeContent(String pass){
		return MessageEncoder.decode(this.content, pass);	
	}
	

}
