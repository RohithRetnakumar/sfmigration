package com.reds.service.cassandraloader.adaptors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.reds.service.cassandraloader.dos.AssetCassandraTransactionHistory;
import com.reds.service.cassandraloader.dos.AssetTransactionKey;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;
import com.reds.service.cassandraloader.utils.DataTypeUtils;
import com.reds.service.cassandraloader.utils.FileUtils;
import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;
import com.reds.service.fileadapterapi.adapter.DataAdapter;
import com.reds.service.fileadapterapi.adapter.FileDetails;

public class AssetCassandraTransactionHistoryAdaptor implements DataAdapter<String> {

	private List<String> inputRejectedRecords = null;
	private List<AssetCassandraTransactionHistory> outputRecords = null;
	private Map<Long, AssetTransactionKey> lookUp = null;
	private static boolean lookupLoaded = false;

	private final int noOfColumns = 24;

	private final String FIELD_DELIMITER;
//	//updated for Oct 1 
//	private final int id_idx=0;
//	private final int created_on_idx=1;
//	private final int created_user_idx=2;
//	private final int cross_channel_idx=3;
//	private final int cross_cluster_idx=4;
//	private final int cross_region_idx=5;
//	private final int description_idx=6;
//	private final int from_channel_id_idx=7;
//	private final int from_cluster_idx=8;
//	private final int from_owner_id_idx=9;
//	private final int from_owner_type_idx=10;
//	private final int from_region_idx=11;
//	private final int to_channel_id_idx=12;
//	private final int to_cluster_idx=13;
//	private final int to_owner_id_idx=14;
//	private final int to_owner_type_idx=15;
//	private final int to_region_idx=16;
//	private final int asset_details_id_idx=17;
//	private final int asset_states_id_idx=18;
//	private final int asset_transaction_master_id_idx=19;
//	private final int price_idx=20;
//	private final int cancelled_idx=21;
//	private final int from_warehouse_id_idx=22;
//	private final int to_warehouse_id_idx=23;
	private final int id_idx =0;
	private final int cancelled_idx =1;
	private final int created_on_idx =2;
	private final int created_user_idx =3;
	private final int cross_channel_idx =4;
	private final int cross_cluster_idx =5;
	private final int cross_region_idx =6;
	private final int description_idx =7;
	private final int from_channel_id_idx =8;
	private final int from_cluster_idx =9;
	private final int from_owner_id_idx =10;
	private final int from_owner_type_idx =11;
	private final int from_region_idx =12;
	private final int from_warehouse_id_idx =13;
	private final int price_idx =14;
	private final int to_channel_id_idx =15;
	private final int to_cluster_idx =16;
	private final int to_owner_id_idx =17;
	private final int to_owner_type_idx =18;
	private final int to_region_idx =19;
	private final int to_warehouse_id_idx =20;
	private final int asset_details_id_idx =21;
	private final int asset_states_id_idx =22;
	private final int asset_transaction_master_id_idx =23;


	private long recordId = 1;

	public AssetCassandraTransactionHistoryAdaptor() {
		FIELD_DELIMITER = CassandraloaderTreasury.open.takeAssetTransactionStatusHistoryConfig().getFieldDelimiter()
				.getValue();

	}

	private void lookupMasterData() {
		CassandraloaderTrack.me.info("Starting lookup loading for transaction master ");
		// all indexes based on 'asset transaction master' table column order
		final int transactionMasterId_idx = 0;
		final int orderId_idx = 16;
		final int processType_idx = 33;
		final int transactionDate_idx = 29;//process_type
		final String mysqlDateFormat = "yyyy-MM-dd hh:mm:ss";
		final int transactionId_idx = 30;
		final String lookupInputFolder = "bucket//transhistory//lookup//";

		if (lookUp == null) {
			lookUp = new HashMap<Long, AssetTransactionKey>();
		}

		CassandraloaderTrack.me.info("Searching for transaction Master files in lookup folder: {}", lookupInputFolder);
		for (String fileName : FileUtils.getFilesInFolder(lookupInputFolder)) {
			List<String> data = FileUtils.readFile(lookupInputFolder + fileName);
			// need to read all files of transaction master

			for (String line : data) {
				AssetTransactionKey key = new AssetTransactionKey();
				String[] splitRecord = line.split("\\|");

				key.setOrderId(splitRecord[orderId_idx].trim());
				key.setProcessType(splitRecord[processType_idx].trim());
				try {
					key.setTransactionDate(
							new SimpleDateFormat(mysqlDateFormat).parse(splitRecord[transactionDate_idx].trim()));
				} catch (ParseException e) {
					CassandraloaderTrack.me.error("Unable to parse date for lookup. {}",
							splitRecord[transactionDate_idx], e);
				}
				key.setTransactionId(splitRecord[transactionId_idx].trim());
				long transactionMasterId = DataTypeUtils.getLong(splitRecord[transactionMasterId_idx].trim());
				lookUp.put(transactionMasterId, key);
			}
			CassandraloaderTrack.me.info("Transaction Master Lookup Data from {} file ,Loaded to memory", fileName);
		}
		CassandraloaderTrack.me.info("Transaction Master Lookup Loading completed for all files in the folder");
	}

	@Override
	public List<String> getRejectedRecords() {

		return inputRejectedRecords;
	}

	@Override
	public void onCompleted(String arg0, String arg1) {
		try {
			// CassandraloaderTreasury.open.takeCassandraManager().persistTransactionHistory(outputRecords);
			CassandraloaderTreasury.open.takeCassandraManager().generateCsvTransactionHistory(outputRecords);
			outputRecords.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CassandraloaderTrack.me.info("Completed  Processing    {} : {}", arg0, arg1);
	}

	@Override
	public void onBatchEnd(int batchSize) {
		try {
			// CassandraloaderTreasury.open.takeCassandraManager().persistTransactionHistory(outputRecords);
			CassandraloaderTreasury.open.takeCassandraManager().generateCsvTransactionHistory(outputRecords);
			outputRecords.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CassandraloaderTrack.me.info("Batch Ends   {} ", batchSize);
	}

	@Override
	public void onBatchStart() {
		CassandraloaderTrack.me.info("Batch starts  ");
		outputRecords = new ArrayList<AssetCassandraTransactionHistory>();
	}

	@Override
	public void onDataFound(List<String> records) {
		if (!lookupLoaded) {
			lookupMasterData();
			lookupLoaded = true;
		}

		for (String record : records) {
			try {
				if (record.isEmpty()) {
					continue;
				}
				String[] splitRecord = record.split(FIELD_DELIMITER, -1);

				if (splitRecord.length < noOfColumns) {
					if (this.inputRejectedRecords == null) {
						this.inputRejectedRecords = new ArrayList<String>();
					}
					this.inputRejectedRecords.add(record);
					CassandraloaderTrack.me.error("Record Rejected.Record does not have all {} necessary columns {} ",
							noOfColumns, record);
					continue;
				}

				String orderId = "UNDEFINED";
				String transactionId = "UNDEFINED";
				Date transactionDate = null;
				String processType = "UNDEFINED";

				AssetCassandraTransactionHistory transactionHistory = new AssetCassandraTransactionHistory();

				String id = splitRecord[id_idx].trim();// Not mapped
				Date createdOn = DataTypeUtils.getDate(splitRecord[created_on_idx].trim());
				String createdUser = splitRecord[created_user_idx].trim();
				// boolean not implemented properly
				boolean crossChannel = DataTypeUtils.getBoolean(splitRecord[cross_channel_idx].trim());
				boolean crossCluster = DataTypeUtils.getBoolean(splitRecord[cross_cluster_idx].trim());
				boolean crossRegion = DataTypeUtils.getBoolean(splitRecord[cross_region_idx].trim());
				String description = splitRecord[description_idx].trim();
				String fromChannelId = splitRecord[from_channel_id_idx].trim();
				String fromCluster = splitRecord[from_cluster_idx].trim();
				String fromOwnerId = splitRecord[from_owner_id_idx].trim();
				String fromOwnerType = splitRecord[from_owner_type_idx].trim();
				String fromRegionId = splitRecord[from_region_idx].trim();
				String fromWareHouseId = splitRecord[from_warehouse_id_idx].trim();
				String toChannelId = splitRecord[to_channel_id_idx].trim();
				String toCluster = splitRecord[to_cluster_idx].trim();
				String toOwnerId = splitRecord[to_owner_id_idx].trim();
				String toOwnerType = splitRecord[to_owner_type_idx].trim();
				String toRegion = splitRecord[to_region_idx].trim();
				String toWareHouseId = splitRecord[to_warehouse_id_idx].trim();
				String assetDetailId = splitRecord[asset_details_id_idx].trim();
				String asset_states_id = splitRecord[asset_states_id_idx].trim();// Not mapped
				long assetTransactionMasterId = DataTypeUtils
						.getLong(splitRecord[asset_transaction_master_id_idx].trim());
				double price = DataTypeUtils.getDoubleOf(splitRecord[price_idx].trim());
				boolean cancelled = DataTypeUtils.getBoolean(splitRecord[cancelled_idx].trim());

				if (lookUp.get(assetTransactionMasterId) != null) {
					orderId = lookUp.get(assetTransactionMasterId).getOrderId();
					transactionId = lookUp.get(assetTransactionMasterId).getTransactionId();
					transactionDate = lookUp.get(assetTransactionMasterId).getTransactionDate();
					processType = lookUp.get(assetTransactionMasterId).getProcessType();
				} else {
					// Removing all records that does not have master data, as Requested by Rejeth
					CassandraloaderTrack.me.info(
							"No Master data found for assetTransactionMasterId={}. Rejecting Record",
							assetTransactionMasterId);
					if (this.inputRejectedRecords == null) {
						this.inputRejectedRecords = new ArrayList<String>();
					}
					this.inputRejectedRecords.add(record);
					CassandraloaderTrack.me.warn("Input Record Rejected {} {} ", record);
					continue;
				}

				transactionHistory.setCreatedOn(createdOn);
				transactionHistory.setCreatedUser(createdUser);
				transactionHistory.setCrossChannel(crossChannel);
				transactionHistory.setCrossCluster(crossCluster);
				transactionHistory.setCrossRegion(crossRegion);
				transactionHistory.setDescription(description);
				transactionHistory.setFromChannelId(fromChannelId);
				transactionHistory.setFromCluster(fromCluster);
				transactionHistory.setFromOwnerId(fromOwnerId);
				transactionHistory.setFromOwnerType(fromOwnerType);
				transactionHistory.setFromRegionId(fromRegionId);
				transactionHistory.setFromWareHouseId(fromWareHouseId);
				transactionHistory.setToChannelId(toChannelId);
				transactionHistory.setToCluster(toCluster);
				transactionHistory.setToOwnerId(toOwnerId);
				transactionHistory.setToOwnerType(toOwnerType);
				transactionHistory.setToRegion(toRegion);
				transactionHistory.setToWareHouseId(toWareHouseId);
				transactionHistory.setAssetTransactionMasterId(assetTransactionMasterId);
				transactionHistory.setPrice(price);
				transactionHistory.setCancelled(cancelled);

				AssetTransactionKey key = new AssetTransactionKey(orderId, assetDetailId, id,
						createdOn, processType);
				key = setDefaultsIfNull(key);
				transactionHistory.setKey(key);

				outputRecords.add(transactionHistory);
				recordId++;

			} catch (Exception e) {
				if (this.inputRejectedRecords == null) {
					this.inputRejectedRecords = new ArrayList<String>();
				}
				this.inputRejectedRecords.add(record);
				CassandraloaderTrack.me.error("Input Record Rejected {} {} ", record, e);
				e.printStackTrace();
			}
		}

	}

	private AssetTransactionKey setDefaultsIfNull(AssetTransactionKey key) {
		if (key.getAssetDetailId() == null || key.getAssetDetailId().equals("")) {
			key.setAssetDetailId("UNDEFINED");
		}
		if (key.getOrderId() == null || key.getOrderId().equals("")) {
			key.setOrderId("UNDEFINED");
		}
		if (key.getProcessType() == null || key.getProcessType().equals("")) {
			key.setProcessType("UNDEFINED");
		}
		if (key.getTransactionId() == null || key.getTransactionId().equals("")) {
			key.setTransactionId("UNDEFINED");
		}
		if (key.getTransactionDate() == null) {
			CassandraloaderTrack.me.warn("Transaction Date is null for key {} . Will cause errors in Data loading",
					key);
		}

		return key;
	}

	@Override
	public void onException(String arg0, String arg1, Throwable arg2) {
		CassandraloaderTrack.me.error("ERROR  {}:{}:{} ", arg0, arg1, arg2);

	}

	@Override
	public void onFileFound(FileDetails arg0) {
		this.recordId = 1;

	}

	@Override
	public void onMovedToArchive(String arg0, String arg1, String arg2) {
		CassandraloaderTrack.me.info("File  {} moved to Archive {}:{} ", arg0, arg1, arg2);
	}

	@Override
	public void onMovedToReject(String arg0, String arg1, String arg2) {
		CassandraloaderTrack.me.error("File  {} moved to Reject {}:{} ", arg0, arg1, arg2);
	}

}
