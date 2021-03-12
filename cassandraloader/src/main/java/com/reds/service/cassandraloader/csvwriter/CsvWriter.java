package com.reds.service.cassandraloader.csvwriter;

import java.util.ArrayList;
import java.util.List;

import com.reds.service.cassandraloader.dos.AssetCassandraTransactionHistory;
import com.reds.service.cassandraloader.dos.AssetMainDetails;
import com.reds.service.cassandraloader.dos.MaterialMaster;
import com.reds.service.cassandraloader.dos.ProductMaster;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;
import com.reds.service.cassandraloader.utils.FileUtils;
import com.reds.service.cassandraloader.utils.FileWrite;
import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;

public class CsvWriter {
	private static int assetDetailFileCOunt = 0;
	private static int transactionHistoryFileCOunt = 0;
	private static int productFileCOunt = 0;
	private static int materialFileCOunt = 0;

	public void writeAssetMainDetails(List<AssetMainDetails> mainDos) {
		FileWrite writer = FileUtils.getWriter();
		assetDetailFileCOunt++;
		String fileName = CassandraloaderTreasury.open.takeCsvWriterConfig().getAssetDetailOutputPath()
				+ "F2F_asset_details_cassandra_" + assetDetailFileCOunt + ".csv";
		CassandraloaderTrack.me.info("Writing to asset_detail to file :{}", fileName);
		writer.createFile(fileName);
		List<String> output = new ArrayList<String>();
		for (AssetMainDetails mainDo : mainDos) {
			output.add(DoToCsv.getCsvOf(mainDo));
		}
		writer.write(output);
		writer.close();
		if (CassandraloaderTreasury.open.takeCsvWriterConfig().isDoneFileOnCompletion()) {
			writer.createFile(fileName + ".done");
			writer.close();
		}
	}

	public void writeAssetTransactionStatusHistory(List<AssetCassandraTransactionHistory> transactionHistoryDos) {
		FileWrite writer = FileUtils.getWriter();
		transactionHistoryFileCOunt++;
		String fileName = CassandraloaderTreasury.open.takeCsvWriterConfig().getTransactionHistoryOutputPath()
				+ "F2F_asset_transaction_history_cassandra_" + transactionHistoryFileCOunt + ".csv";
		writer.createFile(fileName);
		List<String> output = new ArrayList<String>();
		for (AssetCassandraTransactionHistory transactionHistoryDo : transactionHistoryDos) {
			output.add(DoToCsv.getCsvOf(transactionHistoryDo));
		}
		writer.write(output);
		writer.close();
		if (CassandraloaderTreasury.open.takeCsvWriterConfig().isDoneFileOnCompletion()) {
			writer.createFile(fileName + ".done");
			writer.close();
		}
	}

	public void writeProductMaster(List<ProductMaster> productDos) {
		FileWrite writer = FileUtils.getWriter();
		productFileCOunt++;
		String fileName = CassandraloaderTreasury.open.takeCsvWriterConfig().getProductOutputPath()
				+ "F2F_product_master_cassandra_" + productFileCOunt + ".csv";
		writer.createFile(fileName);
		List<String> output = new ArrayList<String>();
		for (ProductMaster productDo : productDos) {
			output.add(DoToCsv.getCsvOf(productDo));
		}
		writer.write(output);
		writer.close();
		if (CassandraloaderTreasury.open.takeCsvWriterConfig().isDoneFileOnCompletion()) {
			writer.createFile(fileName + ".done");
			writer.close();
		}
	}

	public void writeMaterialMaster(List<MaterialMaster> materialDos) {
		FileWrite writer = FileUtils.getWriter();
		materialFileCOunt++;
		String fileName = CassandraloaderTreasury.open.takeCsvWriterConfig().getMaterialOutputPath()
				+ "F2F_material_master_cassandra_" + materialFileCOunt + ".csv";
		writer.createFile(fileName);
		List<String> output = new ArrayList<String>();
		for (MaterialMaster materialDo : materialDos) {
			output.add(DoToCsv.getCsvOf(materialDo));
		}
		writer.write(output);
		writer.close();
		if (CassandraloaderTreasury.open.takeCsvWriterConfig().isDoneFileOnCompletion()) {
			writer.createFile(fileName + ".done");
			writer.close();
		}

	}

}
