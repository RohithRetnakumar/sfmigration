package com.reds.service.cassandraloader.config;

import com.reds.generator.redsannotations.Configuration; 
import com.reds.library.redscommons.config.PlatformConfig; 

/**
 * <b>Purpose:</b> TEst
 *
 * @author <b>Shineed</b>
 *
 * 
 */
@Configuration
public class TestConfig implements PlatformConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Holds the name of the configurations
	 */
	private String id="TestConfig";	
	/**
	 * Holds the description of the configurations
	 */
	private String description="TEst";

	/**
	 * To get Unique Id for this TestConfig
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * To get description of TestConfig
	 */
	@Override
	public String getDescription(){
	 return description;	
	}

	@Override
	public PlatformConfig getDefault() {
		return this;
	}

}