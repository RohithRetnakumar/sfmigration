package com.reds.service.cassandraloader.config;

import com.reds.generator.redsannotations.Configuration;
import com.reds.library.redscommons.config.PlatformConfig;
import com.reds.service.fileadapterapi.config.FieldDelimiter;
import com.reds.service.fileadapterapi.config.InputAdapterConfig; 

/**
 * <b>Purpose:</b> Adaptor for AssetTransactionStatusHistory
 *
 * @author <b>Shineed</b>
 *
 * 
 */
@Configuration
public class AssetTransactionStatusHistoryConfig extends InputAdapterConfig implements PlatformConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Holds the name of the configurations
	 */
	private String id="AssetTransactionStatusHistoryConfig";	
	/**
	 * Holds the description of the configurations
	 */
	private String description="Adaptor for Asset Transaction Status History";

	/**
	 * To get Unique Id for this AssetTransactionStatusHistory
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * To get description of AssetTransactionStatusHistory
	 */
	@Override
	public String getDescription(){
	 return description;	
	}

	@Override
	public PlatformConfig getDefault() {
		setAdapterName("AssetTransactionStatusHistoryAda");
		setInputPath("./bucket/transhistory/input/");
		setArchivePath("./bucket/transhistory/archive/");
		setRecordRejectPath("./bucket/transhistory/recordreject/");
		setRejectPath("./bucket/transhistory/filereject/");
		setHandlerThreads(2);		
		setFieldDelimiter(FieldDelimiter.COMMA);
		return this;
	}

}