package com.students.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	private static volatile PropertyReader proInstance;
	private PropertyReader() {
		
	}
	public static synchronized PropertyReader getInstance() {
		if(proInstance==null) {
			proInstance = new PropertyReader();			
		}
		return proInstance;
	}
	public String getProperty(String propertyName) {
		Properties  prop = new Properties();
		try {
			InputStream inpStream = getClass().getClassLoader().getResourceAsStream("application.properties");
			prop.load(inpStream);
			
			if(prop.getProperty(propertyName) != null) {
				return prop.getProperty(propertyName);
			}
			
		}catch(Exception e) {
			System.err.println("Property not found");
		}
		return null;
		
	}
}
