package com.paritech;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
	
	public static SessionFactory sf;
	
	static {
		
		try {
			sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		catch(Throwable e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSF() {
		
		return sf;
	}

}
