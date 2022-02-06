package com.qa.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	
	/**
	 * reading multiple properties from config.properties file
	 * @return returns prop object.
	 */
	
	
private	Properties prop;

public Properties init_Properties()  {
	
	
	prop = new Properties();
	
	FileInputStream fis;
	try {
		fis = new FileInputStream("./src/test/resources/config/config.properties");
		
		prop.load(fis);
		
	} catch (FileNotFoundException e1) {
		
		e1.printStackTrace();
	}
	
	catch (IOException e) {
			
		e.printStackTrace();
		}
		
	
	return prop;
	
}


	
	

}
