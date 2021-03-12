package com.reds.service.cassandraloader.adaptors;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.reds.library.redsutils.json.Json;
import com.reds.service.cassandraloader.dao.AssetDetails;
import com.reds.service.cassandraloader.dao.AssetStates;
import com.reds.service.cassandraloader.dao.Product;
import com.reds.service.cassandraloader.dos.AssetDetailsKey;
import com.reds.service.cassandraloader.dos.AssetMainDetails;
import com.reds.service.cassandraloader.dos.ProductCategoryLkp;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;
import com.reds.service.cassandraloader.utils.DataTypeUtils;
import com.reds.service.cassandraloader.utils.FileUtils;
import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;
import com.reds.service.fileadapterapi.adapter.DataAdapter;
import com.reds.service.fileadapterapi.adapter.FileDetails;

public class AssetMainDetailsAdaptor implements DataAdapter<String> {

	private List<String> inputRejectedRecords = null;
	private List<AssetMainDetails> outputRecords = null;
	private Map<Long, ProductCategoryLkp> categoryMap = null;
	private static boolean lookupLoaded = false;

	private final String FIELD_DELIMITER;
	private final int minNoOfColumns = 28;
	//updated for Oct 1
	private final int id_idx = 0;
	private final int activation_date_idx = 1;
	private final int box_id_idx = 2;
	private final int channel_id_idx = 3;
	private final int cluster_id_idx = 4;
	private final int created_on_idx = 5;
	private final int created_user_idx = 6;
	private final int description_idx = 7;
	private final int distribution_warehouse_id_idx = 8;
	private final int distributor_id_idx = 9;
	private final int do_number_idx = 10;
	private final int expiry_date_idx = 11;
	private final int iccid_idx = 12;
	private final int mdn_no_idx = 13;
	private final int meid_idx = 14;
	private final int migrated_yes_no_idx = 15;
	private final int modified_on_idx = 16;
	private final int modified_user_idx = 17;
	private final int owner_id_idx = 18;
	private final int owner_type_idx = 19;
	private final int price_idx = 20;
	private final int production_warehouse_id_idx = 21;
	private final int region_id_idx = 22;
	private final int status_idx = 23;
	private final int subs_id_idx = 24;
	private final int termination_date_idx = 25;
	private final int asset_states_id_idx = 26;
	private final int product_id_idx = 27;

	private long recordId = 1;

	public AssetMainDetailsAdaptor() {
		FIELD_DELIMITER = CassandraloaderTreasury.open.takeAssertMainDetailsConfig().getFieldDelimiter().getValue();
	}
	

	public void loadLookupData() {
		if (categoryMap == null) {
			categoryMap = new HashMap<Long, ProductCategoryLkp>();

		} // Input file must be the same file as input for material master table
		List<String> data = FileUtils.readFile("bucket//assetmain//productLkp//lookup_product_category.csv");
		//List<String> data = FileUtils.readFile("C:\\Users\\aruna\\Documents\\lookup_product_category.csv");
		int lineNo = 0;
		
			

		for (String line : data) {
			ProductCategoryLkp product = new ProductCategoryLkp();
			String[] splitRecord = line.split("\\|");
			product.setProductId(DataTypeUtils.getLong(splitRecord[0].trim()));
			product.setProductName(splitRecord[3].trim());
			product.setCategoryId(DataTypeUtils.getLong(splitRecord[16].trim()));// need to get correct mapping
			product.setCategoryName(splitRecord[21].trim());
			categoryMap.put(product.getProductId(), product);
			lineNo++;
		}

		CassandraloaderTrack.me.info("Product Category Data Loaded to memory");
	}

	@Override
	public List<String> getRejectedRecords() {

		return inputRejectedRecords;
	}

	@Override
	public void onCompleted(String arg0, String arg1) {
		try {
			// CassandraloaderTreasury.open.takeCassandraManager().persistAssetMainDetails(outputRecords);
			CassandraloaderTreasury.open.takeCassandraManager().generateCsvAssetMainDetails(outputRecords);
			outputRecords.clear();
		} catch (Exception e) {
			CassandraloaderTrack.me.error("Could not process last batch", e);
		}
		CassandraloaderTrack.me.info("Completed  Processing    {} : {}", arg0, arg1);
	}

	@Override
	public void onBatchEnd(int batchSize) {
		try {
			// CassandraloaderTreasury.open.takeCassandraManager().persistAssetMainDetails(outputRecords);
			CassandraloaderTreasury.open.takeCassandraManager().generateCsvAssetMainDetails(outputRecords);
			outputRecords.clear();
		} catch (Exception e) {
			CassandraloaderTrack.me.error("Could not process batch", e);
		}
		CassandraloaderTrack.me.info("Batch Ends   {} ", batchSize);
	}

	@Override
	public void onBatchStart() {
		CassandraloaderTrack.me.info("Batch starts  ");
		outputRecords = new ArrayList<AssetMainDetails>();
	}

	@Override
	public void onDataFound(List<String> records) {
		if (!lookupLoaded) {
			loadLookupData();
			lookupLoaded = true;
		}

		for (String record : records) {
			try {
				if (record.isEmpty()) {
					continue;
				}
				String[] splitRecord = record.split(FIELD_DELIMITER, -1);
				if (splitRecord.length < minNoOfColumns) {
					if (this.inputRejectedRecords == null) {
						this.inputRejectedRecords = new ArrayList<String>();
					}
					this.inputRejectedRecords.add(record);
					CassandraloaderTrack.me.error("Record Rejected.Record does not have all "+minNoOfColumns+" necessary columns {} ",
							record);
					continue;
				}
				AssetMainDetails assetMainDetails = new AssetMainDetails();
				AssetDetailsKey key = new AssetDetailsKey();

					String id = splitRecord[id_idx].trim();
					Date activationDate = DataTypeUtils.getDate(splitRecord[activation_date_idx].trim());
					String boxId = splitRecord[box_id_idx].trim();
					String channelId = splitRecord[channel_id_idx].trim();
					String cluster = splitRecord[cluster_id_idx].trim();
					Date createdOn = DataTypeUtils.getDate(splitRecord[created_on_idx].trim());
					String createdUser = splitRecord[created_user_idx].trim();
					String description = splitRecord[description_idx].trim();
					Long distributionWarehouseId = DataTypeUtils.getLong(splitRecord[distribution_warehouse_id_idx].trim());
					String distributorId = splitRecord[distributor_id_idx].trim();
		String do_number = splitRecord[do_number_idx].trim();
					Date expiryDate = DataTypeUtils.getDate(splitRecord[expiry_date_idx].trim());
					String iccId = splitRecord[iccid_idx].trim();
					String mdnNo = splitRecord[mdn_no_idx].trim();
				String meid = splitRecord[meid_idx].trim();
		String migrated_yes_no = splitRecord[migrated_yes_no_idx].trim();
					Date modifiedOn = DataTypeUtils.getDate(splitRecord[modified_on_idx].trim());
					String modifiedUser = splitRecord[modified_user_idx].trim();
					String ownerId = splitRecord[owner_id_idx].trim();
					String ownerType = splitRecord[owner_type_idx].trim();
					Double price = DataTypeUtils.getDoubleOf(splitRecord[price_idx].trim());
					Long productionWarehouseId = DataTypeUtils.getLong(splitRecord[production_warehouse_id_idx].trim());
					String region = splitRecord[region_id_idx].trim();
					String status = splitRecord[status_idx].trim();
		String subs_id = splitRecord[subs_id_idx].trim();
					Date terminationDate = DataTypeUtils.getDate(splitRecord[termination_date_idx].trim());
		String asset_states_id = splitRecord[asset_states_id_idx].trim();
					Long productId = DataTypeUtils.getLong(splitRecord[product_id_idx].trim());

					assetMainDetails.setId(id);
			assetMainDetails.setActivationDate(activationDate);
			assetMainDetails.setChannelId(channelId);
			assetMainDetails.setCluster(cluster);
			assetMainDetails.setCreatedOn(createdOn);
			assetMainDetails.setCreatedUser(createdUser);
			assetMainDetails.setDescription(description);
			assetMainDetails.setDistributionWarehouseId(distributionWarehouseId);
			assetMainDetails.setExpiryDate(expiryDate);
			key.setIccId(iccId);
			key.setMdnNo(mdnNo);
			assetMainDetails.setModifiedOn(modifiedOn);
			assetMainDetails.setModifiedUser(modifiedUser);
			assetMainDetails.setOwnerId(ownerId);
			assetMainDetails.setOwnerType(ownerType);
			assetMainDetails.setPrice(price);
			assetMainDetails.setProductionWarehouseId(productionWarehouseId);
			assetMainDetails.setRegion(region);
			assetMainDetails.setStatus(status);
			assetMainDetails.setTerminationDate(terminationDate);
			assetMainDetails.setAssetStatus(asset_states_id);
			assetMainDetails.setBoxId(boxId);
			assetMainDetails.setDistributorId(distributorId);
			assetMainDetails.setAssetDataJson(getAssetDetailsJson(splitRecord));
				// assetMainDetails.setMasterBox(masterBox);

				if (categoryMap.get(productId) != null) {
						assetMainDetails.setProductCategoryName(categoryMap.get(productId).getCategoryName());
						assetMainDetails.setProductName(categoryMap.get(productId).getProductName());
						key.setProductCategoryId(categoryMap.get(productId).getCategoryId());
				} else {
					// Removing all records that does not have master data, as Requested by Rejeth

					CassandraloaderTrack.me.info("Product Id:{} not found in Lookup. Rejecting Record", productId);
					if (this.inputRejectedRecords == null) {
						this.inputRejectedRecords = new ArrayList<String>();
					}
					this.inputRejectedRecords.add(record);
					CassandraloaderTrack.me.warn("Input Record Rejected {} {} ", record);
					continue;

//					key.setProductCategoryId(0L);
//					assetMainDetails.setProductCategoryName("UNDEFINED");
//					assetMainDetails.setProductName("UNDEFINED");

				}

					key.setProductId(productId);
				key = setDefaultsIfNull(key);
				assetMainDetails.setKey(key);

				outputRecords.add(assetMainDetails);
				recordId++;

			} catch (Exception e) {
				if (this.inputRejectedRecords == null) {
					this.inputRejectedRecords = new ArrayList<String>();
				}
				this.inputRejectedRecords.add(record);
				CassandraloaderTrack.me.error("Input Record Rejected {} {} ", record, e);

			}
		}

	}

	public String getAssetDetailsJson(String[] splitRecord) {
		AssetDetails assetDetails = new AssetDetails();
		assetDetails.setId(DataTypeUtils.getLong(splitRecord[id_idx]));
		
		assetDetails.setActivationDate(DataTypeUtils.getDate(splitRecord[activation_date_idx]));
		
		assetDetails.setBoxId(splitRecord[box_id_idx]);
		
		assetDetails.setChannelId(splitRecord[channel_id_idx]);
		
		assetDetails.setClusterId(splitRecord[cluster_id_idx]);
		
		assetDetails.setCreatedOn(DataTypeUtils.getDate(splitRecord[created_on_idx]));
		
		assetDetails.setCreatedUser(splitRecord[created_user_idx]);
		
		assetDetails.setDescription(splitRecord[description_idx]);
		
		assetDetails.setDistributionWarehouseId(DataTypeUtils.getLong(splitRecord[distribution_warehouse_id_idx]));
		
		assetDetails.setDistributorId(splitRecord[distributor_id_idx]);
		
assetDetails.setDoNumber(splitRecord[do_number_idx]);
		assetDetails.setExpiryDate(DataTypeUtils.getDate(splitRecord[expiry_date_idx]));
		
		assetDetails.setIccId(splitRecord[iccid_idx]);
		
		assetDetails.setMdnNo(splitRecord[mdn_no_idx]);
		
assetDetails.setMeId(splitRecord[meid_idx]);
assetDetails.setMigratedYesNo(DataTypeUtils.getBoolean(splitRecord[migrated_yes_no_idx]));
		assetDetails.setModifiedOn(DataTypeUtils.getDate(splitRecord[modified_on_idx]));
		
		assetDetails.setModifiedUser(splitRecord[modified_user_idx]);
		
		assetDetails.setOwnerId(splitRecord[owner_id_idx]);
		
		assetDetails.setOwnerType(splitRecord[owner_type_idx]);
		
		assetDetails.setPrice(DataTypeUtils.getDoubleOf(splitRecord[price_idx]));
		
		assetDetails.setProductionWarehouseId(DataTypeUtils.getLong(splitRecord[production_warehouse_id_idx]));
		
		assetDetails.setRegionId(splitRecord[region_id_idx]);
		
		assetDetails.setStatus(splitRecord[status_idx]);
		
assetDetails.setSubsId(splitRecord[subs_id_idx]);
		assetDetails.setTerminationDate(DataTypeUtils.getDate(splitRecord[termination_date_idx]));
		
		 AssetStates assetStates = new AssetStates(Long.parseLong(splitRecord[asset_states_id_idx]));
		assetDetails.setAssetStates(assetStates );
		

		//assetDetails.setProduct(product );

		return Json.toJson(assetDetails);
	}

	private AssetDetailsKey setDefaultsIfNull(AssetDetailsKey key) {
		if (key.getMdnNo() == null || key.getMdnNo().equals("")) {
			key.setMdnNo("UNDEFINED");
		}
		if (key.getIccId() == null || key.getIccId().equals("")) {
			key.setIccId("UNDEFINED");
		}
		if (key.getProductCategoryId() == null) {
			key.setProductCategoryId(0L);
		}
		if (key.getProductId() == null) {
			key.setProductId(0L);
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
