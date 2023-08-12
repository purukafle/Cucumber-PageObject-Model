package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;
	/**
	 * This method is used to load the properties from config.properties file
	 * @return
	 */
	public Properties init_prop() {
		prop=new Properties();
		try {
			FileInputStream file=new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}
	

}
