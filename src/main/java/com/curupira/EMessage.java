package com.curupira;

import java.util.Date;
import java.util.UUID;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class EMessage {
	
	public EMessage(String id, String title, String content, String language, Date lastUpdated) {
		super();
		this.title = title;
		this.content = content;
		this.language = language;
		this.lastUpdated = lastUpdated;
		this.pass = UUID.randomUUID().toString();
		encodeContent(content);
	}
	
	@Id
	private Long id;

	private String title;
	
	private String content;
		
	private String language;
	
	private Date lastUpdated;
	
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
	
	
	public void encodeContent(String pass){
		this.content = MessageEncoder.encode(content, pass);
	}

	public String getPass() {
		return pass;
	}
	
	public static EMessage find(long id){
		Objectify ofy = ObjectifyService.ofy();
		ofy = ObjectifyService.ofy();
		return ofy.load().type(EMessage.class).id(id).now();
	}

	
	
	

}
