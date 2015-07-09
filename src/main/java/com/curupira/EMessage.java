package com.curupira;

import java.util.Date;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class EMessage {
	
	public static final String EMESSAGE_ENTITY_NAME="EMESSAGE";
	
	public EMessage(String id, String title, String content, String language, Date lastUpdated) {
		super();
		this.title = title;
		this.content = content;
		this.lastUpdated = lastUpdated;
	}
	
	@Id
	private String id;

	private String title;
	
	private String content;
	
	private String language;
	
	private Date lastUpdated;
	

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id){
		this.id=id;
	}

	public String getLanguage() {
		return language;
	}

	public static EMessage findById(String id2) {
		return null;
	}
	
	public void persist(){
		com.google.appengine.api.datastore.Entity entity;
		if(this.getId()!=null){
			Key prayerKey = KeyFactory.createKey(EMessage.EMESSAGE_ENTITY_NAME, id);
			entity = new com.google.appengine.api.datastore.Entity(EMessage.EMESSAGE_ENTITY_NAME, prayerKey);
		}else{
			entity = new com.google.appengine.api.datastore.Entity(EMessage.EMESSAGE_ENTITY_NAME);
		    entity.setProperty("content", this.getContent());
		    entity.setProperty("title", this.getTitle());
		    entity.setProperty("language", this.getLanguage());
		    entity.setProperty("lastUpdated", this.getLastUpdated());
		    
		    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		    Key persistedKey = datastore.put(entity);
		    this.id = persistedKey.getAppId();
		}
	}
	
	public static EMessage find(String key){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter filter = new FilterPredicate(com.google.appengine.api.datastore.Entity.KEY_RESERVED_PROPERTY, FilterOperator.EQUAL, key);
		Query q = new Query(EMESSAGE_ENTITY_NAME).setFilter(filter);
		return null;
	}
	

}
