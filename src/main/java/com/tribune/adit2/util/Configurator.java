package com.tribune.adit2.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.yaml.snakeyaml.Yaml;

public class Configurator {
	
	private static Logger logger = LoggerFactory.getLogger(Configurator.class);
	private static Map<String, String> config = new HashMap<String, String>();
	public static void loadCongifuration()
	{
	    	
	    	String autEnvironment = System.getProperty("autEnvironment");
	    	if (autEnvironment == null)
	    		autEnvironment = "DEV";
			System.out.println("aut env is:\t"+autEnvironment);
			config.put("AUT_ENVIRONMENT", autEnvironment);
			try 
			{
			 loadAppConfiguration(autEnvironment);
			} catch (NullPointerException ne) {
				ne.printStackTrace();
			}
	}
	
	
	@SuppressWarnings("unchecked")
	public static void loadAppConfiguration(String autEnvironment){
		Yaml yaml = new Yaml();
		try {
			InputStream input = Configurator.class.getClassLoader().getResourceAsStream("appConfiguration.yaml");
			Map<String, Map<String, String>> YFile = (Map<String, Map<String, String>>) yaml.load(input);
			addToConfig(YFile.get(autEnvironment));
		}catch(org.yaml.snakeyaml.error.YAMLException ye){
			logger.info("appConfiguration.yaml file not found" + ye);
		}
	}
	
	public static Map<String, String> getConfig() {
		return config;
	}

	private static void addToConfig(Map<String, String> m) {
		Iterator<String> iterator = m.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			config.put(key, m.get(key));			
		}
	}
}
