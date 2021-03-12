package com.reds.service.cassandraloader;

import com.reds.generator.redsannotations.treasury.AddToTreasury;
import com.reds.service.cassandraloader.adaptors.AssetCassandraTransactionHistoryAdaptor;
import com.reds.service.cassandraloader.adaptors.AssetMainDetailsAdaptor;
import com.reds.service.cassandraloader.adaptors.MaterialMasterAdaptor;
import com.reds.service.cassandraloader.adaptors.ProductMasterAdaptor;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;
import com.reds.service.cassandraloaderapi.exception.CassandraloaderErrorCodes;
import com.reds.service.cassandraloaderapi.exception.CassandraloaderException;
import com.reds.service.fileadapterapi.adapter.Adapter;
import com.reds.service.fileadapterapi.config.FileAdapterConfig;
import com.reds.service.fileadapterapi.exception.FileAdapterException;

@AddToTreasury
public class FileAdaptorManager {
	private Adapter<String> assetDetails = null;
	private Adapter<String> assetTransaction = null;
	private Adapter<String> productMaster = null;

	public void start() throws CassandraloaderException {

		startAssetMainDetails();
		startAssetCassandraTransactionHistoryDetails();
		startProductMasterDetails();
		startMaterialMaster();
	}

	private void startAssetMainDetails() throws CassandraloaderException {
		try {
			FileAdapterConfig assetConfig = new FileAdapterConfig();
			assetConfig.setInputAdapterConfig(CassandraloaderTreasury.open.takeAssertMainDetailsConfig());
			assetDetails = CassandraloaderTreasury.open.accessFileAdapter().createFileAdapter(assetConfig,
					new AssetMainDetailsAdaptor());
			assetDetails.start();
		} catch (FileAdapterException e) {
			throw new CassandraloaderException(CassandraloaderErrorCodes.errorCode(1),
					"Failed to create asset detail adaptor", e);
		}
	}

	private void startAssetCassandraTransactionHistoryDetails() throws CassandraloaderException {
		try {
			FileAdapterConfig assetConfig = new FileAdapterConfig();
			assetConfig.setInputAdapterConfig(CassandraloaderTreasury.open.takeAssetTransactionStatusHistoryConfig());
			assetTransaction = CassandraloaderTreasury.open.accessFileAdapter().createFileAdapter(assetConfig,
					new AssetCassandraTransactionHistoryAdaptor());
			assetTransaction.start();
		} catch (FileAdapterException e) {
			throw new CassandraloaderException(CassandraloaderErrorCodes.errorCode(1),
					"Failed to create AssetCassandraTransactionHistory adaptor", e);
		}
	}

	private void startProductMasterDetails() throws CassandraloaderException {
		try {
			FileAdapterConfig assetConfig = new FileAdapterConfig();
			assetConfig.setInputAdapterConfig(CassandraloaderTreasury.open.takeProductMasterConfig());
			productMaster = CassandraloaderTreasury.open.accessFileAdapter().createFileAdapter(assetConfig,
					new ProductMasterAdaptor());
			productMaster.start();
		} catch (FileAdapterException e) {
			throw new CassandraloaderException(CassandraloaderErrorCodes.errorCode(1),
					"Failed to create Product Master Adaptor", e);
		}
	}

	private void startMaterialMaster() throws CassandraloaderException {
		try {
			FileAdapterConfig assetConfig = new FileAdapterConfig();
			assetConfig.setInputAdapterConfig(CassandraloaderTreasury.open.takeMaterialMasterConfig());
			productMaster = CassandraloaderTreasury.open.accessFileAdapter().createFileAdapter(assetConfig,
					new MaterialMasterAdaptor());
			productMaster.start();
		} catch (FileAdapterException e) {
			throw new CassandraloaderException(CassandraloaderErrorCodes.errorCode(1),
					"Failed to create Material Master Adaptor", e);
		}

	}

}
