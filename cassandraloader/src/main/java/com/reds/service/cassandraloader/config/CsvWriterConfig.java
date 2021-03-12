package com.reds.service.cassandraloader.config;

import com.reds.generator.redsannotations.Configuration;
import com.reds.library.redscommons.config.PlatformConfig;

@Configuration
public class CsvWriterConfig implements PlatformConfig {

	/**
	 * Holds the name of the configurations
	 */
	private String id = "CsvWriterConfig";
	/**
	 * Holds the description of the configurations
	 */
	private String description = "Configurations for Csv output Mode";

	private String assetDetailOutputPath = "";
	private String transactionHistoryOutputPath = "";
	private String productOutputPath = "";
	private String materialOutputPath = "";
	private String fieldDelimiter = "|";
	private boolean doneFileOnCompletion = true;

	@Override
	public String getId() {

		return id;
	}

	@Override
	public String getDescription() {

		return description;
	}

	public String getAssetDetailOutputPath() {
		return assetDetailOutputPath;
	}

	public void setAssetDetailOutputPath(String assetDetailOutputPath) {
		this.assetDetailOutputPath = assetDetailOutputPath;
	}

	public String getTransactionHistoryOutputPath() {
		return transactionHistoryOutputPath;
	}

	public void setTransactionHistoryOutputPath(String transactionHistoryOutputPath) {
		this.transactionHistoryOutputPath = transactionHistoryOutputPath;
	}

	public String getProductOutputPath() {
		return productOutputPath;
	}

	public void setProductOutputPath(String productOutputPath) {
		this.productOutputPath = productOutputPath;
	}

	public String getFieldDelimiter() {
		return fieldDelimiter;
	}

	public void setFieldDelimiter(String fieldDelimiter) {
		this.fieldDelimiter = fieldDelimiter;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDoneFileOnCompletion() {
		return doneFileOnCompletion;
	}

	public void setDoneFileOnCompletion(boolean doneFileOnCompletion) {
		this.doneFileOnCompletion = doneFileOnCompletion;
	}

	public String getMaterialOutputPath() {
		return materialOutputPath;
	}

	public void setMaterialOutputPath(String materialOutputPath) {
		this.materialOutputPath = materialOutputPath;
	}

}
