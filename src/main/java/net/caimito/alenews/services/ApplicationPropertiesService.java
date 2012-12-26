package net.caimito.alenews.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationPropertiesService {
	private static Logger LOGGER = LoggerFactory.getLogger(ApplicationPropertiesService.class) ;
	
	private Properties properties ;

	public ApplicationPropertiesService() {
		try {
			properties = new Properties() ;
			InputStream inputStream = this.getClass().getResourceAsStream("/application.properties") ;
			if (inputStream == null) {
				LOGGER.error("Could not find application.properties") ;
			} else
				properties.load(inputStream) ;
		} catch (IOException e) {
			throw new RuntimeException(e) ;
		}
	}
	
	public String getCurrentVersion() {
		return properties.getProperty("version") ;
	}
	
}
