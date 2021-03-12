package com.reds.service.cassandraloader.config;

import com.reds.generator.redsannotations.Configuration;
import com.reds.library.redscommons.config.PlatformConfig;
import com.reds.service.fileadapterapi.config.FieldDelimiter;
import com.reds.service.fileadapterapi.config.InputAdapterConfig;

@Configuration
public class MaterialMasterConfig extends InputAdapterConfig implements PlatformConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Holds the name of the configurations
	 */
	private String id = "MaterialMasterConfig";
	/**
	 * Holds the description of the configurations
	 */
	private String description = "Adaptor for Material Master Config";

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
	public String getDescription() {
		return description;
	}

	@Override
	public PlatformConfig getDefault() {
		setAdapterName("MaterialMasterAdapter");
		setInputPath("./bucket/material/input/");
		setArchivePath("./bucket/material/archive/");
		setRecordRejectPath("./bucket/material/recordreject/");
		setRejectPath("./bucket/material/filereject/");
		setHandlerThreads(2);
		setFieldDelimiter(FieldDelimiter.PIPE);
		return this;
	}

}
