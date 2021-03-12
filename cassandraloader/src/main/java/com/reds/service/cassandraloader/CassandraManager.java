package com.reds.service.cassandraloader;

import java.util.List;

import com.reds.generator.redsannotations.treasury.AddToTreasury;
import com.reds.service.cassandraloader.config.CassandraloaderConfig.OutputMode;
import com.reds.service.cassandraloader.csvwriter.CsvWriter;
import com.reds.service.cassandraloader.dao.AssetMainDetailsDAO;
import com.reds.service.cassandraloader.dao.AssetMainDetailsDAOImpl;
import com.reds.service.cassandraloader.dao.AssetTransactionStatusHistoryDAO;
import com.reds.service.cassandraloader.dao.AssetTransactionStatusHistoryDAOImpl;
import com.reds.service.cassandraloader.dao.ProductMasterDAO;
import com.reds.service.cassandraloader.dao.ProductMasterDAOImpl;
import com.reds.service.cassandraloader.dos.AssetCassandraTransactionHistory;
import com.reds.service.cassandraloader.dos.AssetMainDetails;
import com.reds.service.cassandraloader.dos.MaterialMaster;
import com.reds.service.cassandraloader.dos.ProductMaster;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;
import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;

@AddToTreasury
public class CassandraManager {

	private AssetMainDetailsDAO assetMainDetailsDAO = null;
	private AssetTransactionStatusHistoryDAO assetTransactionStatusHistoryDAO = null;
	private ProductMasterDAO productMasterDAO = null;
	private CsvWriter csvWriter = null;

	public CassandraManager() {
		switch (CassandraloaderTreasury.open.takeCassandraloaderConfig().getOutputMode()) {
		case CASSANDRA_INSERT:
			CassandraloaderTrack.me.info("Starting in CASSANDRA_INSERT mode");
			assetMainDetailsDAO = new AssetMainDetailsDAOImpl();
			assetTransactionStatusHistoryDAO = new AssetTransactionStatusHistoryDAOImpl();
			productMasterDAO = new ProductMasterDAOImpl();
			break;

		case CSV:
			CassandraloaderTrack.me.info("Starting in CSV output mode");
			csvWriter = new CsvWriter();
			break;
		default:
			CassandraloaderTrack.me.error("INVALID output mode");
			break;
		}

	}

	public void generateCsvAssetMainDetails(List<AssetMainDetails> mainDos) throws Exception {
		csvWriter.writeAssetMainDetails(mainDos);
	}

	public void generateCsvTransactionHistory(List<AssetCassandraTransactionHistory> transactionHistoryDos)
			throws Exception {
		csvWriter.writeAssetTransactionStatusHistory(transactionHistoryDos);
	}

	public void generateCsvProductMaster(List<ProductMaster> productDos) throws Exception {
		csvWriter.writeProductMaster(productDos);
	}

	public void generateCsvMaterialMaster(List<MaterialMaster>productDos) throws Exception{
		csvWriter.writeMaterialMaster(productDos);
	}
	
	public void persistAssetMainDetails(List<AssetMainDetails> mainDos) throws Exception {
		assetMainDetailsDAO.insert(mainDos);
	}

	public void persistTransactionHistory(List<AssetCassandraTransactionHistory> transactionHistoryDos)
			throws Exception {

		assetTransactionStatusHistoryDAO.insert(transactionHistoryDos);
	}

	public void persistProductMaster(List<ProductMaster> productDos) throws Exception {
		productMasterDAO.insert(productDos);
	}

}
