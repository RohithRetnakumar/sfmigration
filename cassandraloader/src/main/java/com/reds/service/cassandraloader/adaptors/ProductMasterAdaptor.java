package com.reds.service.cassandraloader.adaptors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.reds.service.cassandraloader.dos.ProductKey;
import com.reds.service.cassandraloader.dos.ProductMaster;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;
import com.reds.service.cassandraloader.utils.DataTypeUtils;
import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;
import com.reds.service.fileadapterapi.adapter.DataAdapter;
import com.reds.service.fileadapterapi.adapter.FileDetails;

public class ProductMasterAdaptor implements DataAdapter<String> {

	private List<String> inputRejectedRecords = null;
	private List<ProductMaster> outputRecords = null;

	private final int noOfColumns = 22;

	private final String FIELD_DELIMITER;

	private final int id_idx = 0;
	private final int created_on_idx = 1;
	private final int created_user_idx = 2;
	private final int customer_type_idx = 3;
	private final int description_idx = 4;
	private final int fg_code_idx = 5;
	private final int gross_weight_idx = 6;
	private final int modified_on_idx = 7;
	private final int modified_user_idx = 8;
	private final int product_name_idx = 9;
	private final int uom_idx = 10;
	private final int weight_unit_idx = 11;
	private final int product_category_id_idx = 12;
	private final int product_hierarchy_idx = 13;
	private final int product_image_idx = 14;
	private final int deletion_flag_idx = 15;
	private final int description_of_material_idx = 16;
	private final int material_code_idx = 17;
	private final int material_group_idx = 18;
	private final int material_type_idx = 19;
	private final int sales_organisation_idx = 20;
	private final int distribution_channel_idx = 21;
	private final int product_category_idx = 22;

	private long recordId = 1;

	public ProductMasterAdaptor() {
		FIELD_DELIMITER = CassandraloaderTreasury.open.takeProductMasterConfig().getFieldDelimiter().getValue();
	}

	@Override
	public List<String> getRejectedRecords() {

		return inputRejectedRecords;
	}

	@Override
	public void onCompleted(String arg0, String arg1) {
		try {
			// CassandraloaderTreasury.open.takeCassandraManager().persistAssetMainDetails(outputRecords);
			CassandraloaderTreasury.open.takeCassandraManager().generateCsvProductMaster(outputRecords);
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
			CassandraloaderTreasury.open.takeCassandraManager().generateCsvProductMaster(outputRecords);
			outputRecords.clear();
		} catch (Exception e) {
			CassandraloaderTrack.me.error("Could not process batch", e);
		}
		CassandraloaderTrack.me.info("Batch Ends   {} ", batchSize);
	}

	@Override
	public void onBatchStart() {
		CassandraloaderTrack.me.info("Batch starts  ");
		outputRecords = new ArrayList<ProductMaster>();
	}

	@Override
	public void onDataFound(List<String> records) {
		for (String record : records) {
			try {
				if (record.isEmpty()) {
					continue;
				}
				String[] splitRecord = record.split(FIELD_DELIMITER, -1);

				if (splitRecord.length <= noOfColumns) {
					if (this.inputRejectedRecords == null) {
						this.inputRejectedRecords = new ArrayList<String>();
					}
					this.inputRejectedRecords.add(record);
					CassandraloaderTrack.me.error("Record Rejected. Record does not have all {} necessary columns {}",
							noOfColumns, record);
					continue;
				}
				ProductMaster productMaster = new ProductMaster();
				// TODO need to set remaining `

				String id = splitRecord[id_idx];// not mapped
				Date createdOn = DataTypeUtils.getDate(splitRecord[created_on_idx]);
				String createdUser = splitRecord[created_user_idx];
				String customer_type = splitRecord[customer_type_idx];// not mapped
				String description = splitRecord[description_idx];
				String fgCode = splitRecord[fg_code_idx];
				String gross_weight = splitRecord[gross_weight_idx];// not mapped
				Date modifiedOn = DataTypeUtils.getDate(splitRecord[modified_on_idx]);
				String modifiedUser = splitRecord[modified_user_idx];
				String productName = splitRecord[product_name_idx];
				String uom = splitRecord[uom_idx];// not mapped
				String weight_unit = splitRecord[weight_unit_idx];// not mapped
				String product_category_id = splitRecord[product_category_id_idx];// not mapped
				String productHierarchy = splitRecord[product_hierarchy_idx];
				String product_image = splitRecord[product_image_idx];// not mapped
				String deletion_flag = splitRecord[deletion_flag_idx];// not mapped
				String description_of_material = splitRecord[description_of_material_idx];// not mapped
				String material_code = splitRecord[material_code_idx];
				String materialGroup = splitRecord[material_group_idx];
				String material_type = splitRecord[material_type_idx];// not mapped
				String sales_organisation = splitRecord[sales_organisation_idx];// not mapped
				String distribution_channel = splitRecord[distribution_channel_idx];// not mapped
				String productCategory = splitRecord[product_category_idx];

				productMaster.setCreatedOn(createdOn);
				productMaster.setCreatedUser(createdUser);
				productMaster.setDescription(description);
				productMaster.setModifiedOn(modifiedOn);
				productMaster.setModifiedUser(modifiedUser);
				productMaster.setProductName(productName);
				productMaster.setProductHierarchy(productHierarchy);
				productMaster.setProductCategory(materialGroup); // Need confirmation from arun
				productMaster.setProductCategoryName(productCategory);

				ProductKey key = new ProductKey(fgCode);
				productMaster.setKey(key);
				key.setFgCode(fgCode);

				outputRecords.add(productMaster);
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
