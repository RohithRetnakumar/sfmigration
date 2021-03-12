package com.reds.service.cassandraloader.config;

import com.reds.generator.redsannotations.Configuration;
import com.reds.library.redscommons.config.PlatformConfig;
import com.reds.service.fileadapterapi.config.FieldDelimiter;
import com.reds.service.fileadapterapi.config.InputAdapterConfig; 

/**
 * <b>Purpose:</b> Adaptor for Assert Main Details
 *
 * @author <b>Shineed</b>
 *
 * 
 */
@Configuration
public class AssertMainDetailsConfig extends InputAdapterConfig implements PlatformConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Holds the name of the configurations
	 */
	private String id="AssertMainDetailsConfig";	
	/**
	 * Holds the description of the configurations
	 */
	private String description="Adaptor for Assert Main Details";

	/**
	 * To get Unique Id for this AssertMainDetailsConfig
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * To get description of AssertMainDetailsConfig
	 */
	@Override
	public String getDescription(){
	 return description;	
	}

	@Override
	public PlatformConfig getDefault() {
		setAdapterName("AssertMainDetailsAdapter");
		setInputPath("./bucket/assetmain/input/");
		setArchivePath("./bucket/assetmain/archive/");
		setRecordRejectPath("./bucket/assetmain/recordreject/");
		setRejectPath("./bucket/assetmain/filereject/");
		setHandlerThreads(2);		
		setFieldDelimiter(FieldDelimiter.COMMA);
		return this;
	}

}