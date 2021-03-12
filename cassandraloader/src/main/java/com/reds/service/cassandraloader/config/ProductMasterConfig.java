package com.reds.service.cassandraloader.config;

import com.reds.generator.redsannotations.Configuration;
import com.reds.library.redscommons.config.PlatformConfig;
import com.reds.service.fileadapterapi.config.FieldDelimiter;
import com.reds.service.fileadapterapi.config.InputAdapterConfig; 

/**
 * <b>Purpose:</b> Adaptor for Product Master Config
 *
 * @author <b>Shineed</b>
 *
 * 
 */
@Configuration
public class ProductMasterConfig extends InputAdapterConfig implements PlatformConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Holds the name of the configurations
	 */
	private String id="ProductMasterConfig";	
	/**
	 * Holds the description of the configurations
	 */
	private String description="Adaptor for Product Master Config";

	/**
	 * To get Unique Id for this Product Master Config
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * To get description of Product Master Config
	 */
	@Override
	public String getDescription(){
	 return description;	
	}

	@Override
	public PlatformConfig getDefault() {
		setAdapterName("ProductMasterAdapter");
		setInputPath("./bucket/product/input/");
		setArchivePath("./bucket/product/archive/");
		setRecordRejectPath("./bucket/product/recordreject/");
		setRejectPath("./bucket/product/filereject/");
		setHandlerThreads(2);		
		setFieldDelimiter(FieldDelimiter.PIPE);
		return this;
	}

}