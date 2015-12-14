package com.pramati.simplehibernatemaven.controller;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.pramati.simplehibernatemaven.model.StudentInformation;

public class Controller {
	private static SessionFactory sessionFactoryObj;
	private static ServiceRegistry serviceRegistryObj;
	final static Logger logger = Logger.getLogger(Controller.class);
	
	public static SessionFactory buildSessionFactory(){
		Configuration config = new Configuration();
		config.configure();
		serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactoryObj = config.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}
	
	public static void main(String args[]){
	String hql = "";
	Session session = null;
	try{
        
		buildSessionFactory();	// builds the session factory
		session = sessionFactoryObj.openSession();
		session.beginTransaction();
		
		hql = "FROM " + StudentInformation.class.getName();
		Query query = session.createQuery(hql);
		logger.info("Querying the db for document name as : "+hql);
		
		@SuppressWarnings("unchecked")
		List<StudentInformation> listOfStudents = query.list();
		if(listOfStudents.size()>0){
			Iterator<StudentInformation> iterator = listOfStudents.iterator();
			while(iterator.hasNext()){
				logger.debug(iterator.next());
			}
		}
	}
	catch(Exception e){
		
	}
	}
}
