package com.reds.service.cassandraloader.adaptors;

import java.util.ArrayList;
import java.util.List;

import com.reds.service.cassandraloader.dos.MaterialKey;
import com.reds.service.cassandraloader.dos.MaterialMaster;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;
import com.reds.service.cassandraloader.utils.DataTypeUtils;
import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;
import com.reds.service.fileadapterapi.adapter.DataAdapter;
import com.reds.service.fileadapterapi.adapter.FileDetails;

public class MaterialMasterAdaptor implements DataAdapter<String> {

	private List<String> inputRejectedRecords = null;
	private List<MaterialMaster> outputRecords = null;

	private final int noOfColumns = 17;

	private final String FIELD_DELIMITER;
	//Updated for Oct 1
//	private final int id_idx = 0;
//	private final int created_on_idx = 1;
//	private final int deletion_flag_idx = 2;
//	private final int description_idx = 3;
//	private final int distribution_channel_idx = 4;
//	private final int gross_weight_idx = 5;
//	private final int material_idx = 6;
//	private final int modified_on_idx = 7;
//	private final int product_hierarchy_idx = 8;
//	private final int material_image_idx = 9;
//	private final int material_name_idx = 10;
//	private final int sales_organisation_idx = 11;
//	private final int uom_idx = 12;
//	private final int version_idx = 13;
//	private final int weight_unit_idx = 14;
//	private final int material_type_id_idx = 15;
//	private final int material_group_id_idx = 16;
//	private final int material_group_description_idx = 17;
	
	private final int id_idx = 0;
	private final int created_on_idx = 1;
	private final int deletion_flag_idx = 2;
	private final int description_idx = 3;
	private final int distribution_channel_idx = 4;
	private final int gross_weight_idx = 5;
	private final int material_idx = 6;
	private final int modified_on_idx = 7;
	private final int product_hierarchy_idx = 8;
	private final int material_image_idx = 9;
	private final int material_name_idx = 10;
	private final int sales_organisation_idx = 11;
	private final int uom_idx = 12;
	private final int version_idx = 13;
	private final int weight_unit_idx = 14;
	private final int material_type_id_idx = 15;
	private final int material_group_id_idx = 16;
	private final int material_group_id_1_idx = 17;
	private final int material_group_id_2_idx = 18;
	private final int material_group_id_3_idx = 19;
	private final int material_group_id_6_idx = 20;
	
	
	

	private long recordId = 1;

	public MaterialMasterAdaptor() {
		FIELD_DELIMITER = CassandraloaderTreasury.open.takeProductMasterConfig().getFieldDelimiter().getValue();
	}

	@Override
	public List<String> getRejectedRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCompleted(String arg0, String arg1) {
		try {
			// CassandraloaderTreasury.open.takeCassandraManager().persistAssetMainDetails(outputRecords);
			CassandraloaderTreasury.open.takeCassandraManager().generateCsvMaterialMaster(outputRecords);
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
			CassandraloaderTreasury.open.takeCassandraManager().generateCsvMaterialMaster(outputRecords);
			outputRecords.clear();
		} catch (Exception e) {
			CassandraloaderTrack.me.error("Could not process batch", e);
		}
		CassandraloaderTrack.me.info("Batch Ends   {} ", batchSize);
	}

	@Override
	public void onBatchStart() {
		CassandraloaderTrack.me.info("Batch starts  ");
		outputRecords = new ArrayList<MaterialMaster>();
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
				MaterialMaster materialMaster = new MaterialMaster();
				// TODO need to set remaining `

				String id = splitRecord[id_idx].trim();
				String created_on = splitRecord[created_on_idx].trim();
				boolean deletionFlag = DataTypeUtils.getBoolean(splitRecord[deletion_flag_idx].trim());
				String description = splitRecord[description_idx].trim();
				String distributionChannel = splitRecord[distribution_channel_idx].trim();
				String grossWeight = splitRecord[gross_weight_idx].trim();
				String material = splitRecord[material_idx].trim();
				String modified_on = splitRecord[modified_on_idx].trim();
				String productHierarchy = splitRecord[product_hierarchy_idx].trim();
				String material_image = splitRecord[material_image_idx].trim();
				String material_name = splitRecord[material_name_idx].trim();
				String salesOrganisation = splitRecord[sales_organisation_idx].trim();
				String uom = splitRecord[uom_idx].trim();
				String version = splitRecord[version_idx].trim();
				String weightUnit = splitRecord[weight_unit_idx].trim();
				String material_type_id = splitRecord[material_type_id_idx].trim();
				String material_group_id = splitRecord[material_group_id_idx].trim();
				//String materialGroupDescription=splitRecord[material_group_description_idx].trim();

				MaterialKey key = new MaterialKey();
				key.setMaterial(material);
				materialMaster.setKey(key);
				materialMaster.setDeletionFlag(deletionFlag);
				materialMaster.setDescription(description);
				materialMaster.setDistributionChannel(distributionChannel);
				materialMaster.setGrossWeight(grossWeight);
				materialMaster.setProductHierarchy(productHierarchy);
				materialMaster.setSalesOrganisation(salesOrganisation);
				materialMaster.setUom(uom);
				materialMaster.setWeightUnit(weightUnit);
				//materialMaster.setMaterialGroupDescription(materialGroupDescription);
				// materialMaster.setMaterialType(materialType);
				// materialMaster.setMaterialGrouping(materialGrouping);

				outputRecords.add(materialMaster);
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
