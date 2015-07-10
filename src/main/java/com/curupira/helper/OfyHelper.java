package com.curupira.helper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.curupira.entity.EMessage;
import com.googlecode.objectify.ObjectifyService;

public class OfyHelper implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		register();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
	public static void register() {
		ObjectifyService.register(EMessage.class);
	}
	

}
