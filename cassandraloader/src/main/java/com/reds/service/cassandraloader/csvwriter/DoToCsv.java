package com.reds.service.cassandraloader.csvwriter;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.reds.service.cassandraloader.dos.AssetCassandraTransactionHistory;
import com.reds.service.cassandraloader.dos.AssetMainDetails;
import com.reds.service.cassandraloader.dos.MaterialMaster;
import com.reds.service.cassandraloader.dos.ProductMaster;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;

public class DoToCsv {

	private static final String delimiter = CassandraloaderTreasury.open.takeCsvWriterConfig().getFieldDelimiter();

	public static String getCsvOf(AssetMainDetails mainDetails) {
		//updated for 1 OCT
		String csv = "";

		csv += mainDetails.getKey().getIccId() + delimiter;
		csv += mainDetails.getKey().getMdnNo() + delimiter;
		csv += String.valueOf(mainDetails.getKey().getProductId()) + delimiter;
		csv += String.valueOf(mainDetails.getKey().getProductCategoryId()) + delimiter;
		csv += getDateAsString(mainDetails.getActivationDate()) + delimiter;// Date field
		// check json
		csv += mainDetails.getAssetDataJson() + delimiter;
		csv += mainDetails.getAssetStatus() + delimiter;
		csv += mainDetails.getBoxId() + delimiter;
		csv += mainDetails.getChannelId() + delimiter;
		csv += mainDetails.getCluster() + delimiter;
		csv += getDateAsString(mainDetails.getCreatedOn()) + delimiter;// Date field
		csv += mainDetails.getCreatedUser() + delimiter;
		csv += mainDetails.getDescription() + delimiter;
		csv += String.valueOf(mainDetails.getDistributionWarehouseId()) + delimiter;
		csv += mainDetails.getDistributorId() + delimiter;
		csv += getDateAsString(mainDetails.getExpiryDate()) + delimiter;// Date field
		csv += mainDetails.getId() + delimiter;
		csv += mainDetails.getMasterBox() + delimiter;
		csv += getDateAsString(mainDetails.getModifiedOn()) + delimiter;// Date field
		csv += mainDetails.getModifiedUser() + delimiter;
		csv += mainDetails.getOwnerId() + delimiter;
		csv += mainDetails.getOwnerType() + delimiter;
		csv += String.valueOf(mainDetails.getPrice()) + delimiter;
		csv += mainDetails.getProductCategoryName() + delimiter;
		csv += mainDetails.getProductName() + delimiter;
		csv += String.valueOf(mainDetails.getProductionWarehouseId()) + delimiter;
		csv += mainDetails.getRegion() + delimiter;
		csv += mainDetails.getStatus() + delimiter;
		csv += getDateAsString(mainDetails.getTerminationDate());// Date field

		csv = csv.replaceAll("null", "");
		return csv;

	}

	public static String getCsvOf(AssetCassandraTransactionHistory transactionHistory) {
		//updated for oct 1
		String csv = "";

		csv += transactionHistory.getKey().getAssetDetailId() + delimiter;
		csv += transactionHistory.getKey().getOrderId() + delimiter;
		csv += transactionHistory.getKey().getTransactionId() + delimiter;
		csv += getDateAsString(transactionHistory.getKey().getTransactionDate()) + delimiter;
		csv += transactionHistory.getKey().getProcessType() + delimiter;
		csv += transactionHistory.getAccessVia() + delimiter;
		csv += transactionHistory.getAssetStatus() + delimiter;
		csv += transactionHistory.getCancelled() + delimiter;// Boolean field
		csv += transactionHistory.getCheckinId() + delimiter;
		csv += getDateAsString(transactionHistory.getCreatedOn()) + delimiter;// date field
		csv += transactionHistory.getCreatedUser() + delimiter;
		csv += transactionHistory.getCrossChannel() + delimiter;// Boolean field
		csv += transactionHistory.getCrossCluster() + delimiter;// Boolean field
		csv += transactionHistory.getCrossRegion() + delimiter;// Boolean field
		csv += transactionHistory.getDescription() + delimiter;
		csv += delimiter;// distributor_warehouse_id is not available in AssetCassandraTransactionHistory
		csv += transactionHistory.getFromChannelId() + delimiter;
		csv += transactionHistory.getFromCluster() + delimiter;
		csv += transactionHistory.getFromOwnerId() + delimiter;
		csv += transactionHistory.getFromOwnerType() + delimiter;
		csv += transactionHistory.getFromRegionId() + delimiter;
		csv += transactionHistory.getFromWareHouseId() + delimiter;
		csv += String.valueOf(transactionHistory.getAssetTransactionMasterId()) + delimiter;// doubt
		csv += transactionHistory.getPaymentMode() + delimiter;
		csv += String.valueOf(transactionHistory.getPrice()) + delimiter;
		csv += transactionHistory.getProductCategory() + delimiter;
		csv += transactionHistory.getProductCategoryName() + delimiter;
		csv += transactionHistory.getProductName() + delimiter;
		csv += transactionHistory.getProgramId() + delimiter;
		csv += transactionHistory.getProgramName() + delimiter;
		csv += transactionHistory.getToChannelId() + delimiter;
		csv += transactionHistory.getToCluster() + delimiter;
		csv += transactionHistory.getToOwnerId() + delimiter;
		csv += transactionHistory.getToOwnerType() + delimiter;
		csv += transactionHistory.getToRegion() + delimiter;
		csv += transactionHistory.getToWareHouseId() + delimiter;
		csv += String.valueOf(transactionHistory.getTransactionAmount()) + delimiter;

		csv = csv.replaceAll("null", "");
		return csv;

	}

	public static String getCsvOf(ProductMaster productMaster) {
		String csv = "";

		csv += productMaster.getKey().getFgCode() + delimiter;
		csv += getDateAsString(productMaster.getCreatedOn()) + delimiter;
		csv += productMaster.getCreatedUser() + delimiter;
		csv += productMaster.getDescription() + delimiter;
		csv += getDateAsString(productMaster.getModifiedOn()) + delimiter;
		csv += productMaster.getModifiedUser() + delimiter;
		csv += productMaster.getProductCategory() + delimiter;
		csv += productMaster.getProductCategoryName() + delimiter;
		csv += productMaster.getProductHierarchy() + delimiter;
		csv += productMaster.getProductHierarchyCode() + delimiter;
		csv += productMaster.getProductName() + delimiter;
		csv += productMaster.getProductType() + delimiter;

		csv = csv.replaceAll("null", "");
		return csv;

	}

	public static String getCsvOf(MaterialMaster materialDo) {
		//updated for oct 1
		String csv = "";

		csv += materialDo.getKey().getMaterial() + delimiter;
		csv += materialDo.getDistributionChannel() + delimiter;
		csv += materialDo.getSalesOrganisation() + delimiter;
		csv += materialDo.isDeletionFlag() + delimiter;// check what string to be set for booleans
		csv += materialDo.getDescription() + delimiter;
		csv += materialDo.getGrossWeight() + delimiter;
		csv += materialDo.getProductCategory() + delimiter;//product category is material group
		csv += materialDo.getMaterialGroupDescription() + delimiter;
		csv += materialDo.getMaterialGrouping() + delimiter;
		csv += materialDo.getMaterialType() + delimiter;
		csv += materialDo.getProductHierarchy() + delimiter;
		csv += materialDo.getProductName() + delimiter;
		csv += materialDo.getUom() + delimiter;
		csv += materialDo.getWeightUnit() + delimiter;

		csv = csv.replaceAll("null", "");
		return csv;

	}

	private static String getDateAsString(Date date) {
		// 2012-06-23 16:14:01.867+0000
		if (date == null) {
			return "";
		}

		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return format.format(date) + "+0000";

	}

}
