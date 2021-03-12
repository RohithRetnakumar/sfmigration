package com.reds.service.cassandraloader.dos;

import java.util.Date;

//Table("asset_transaction_status_history")
public class AssetCassandraTransactionHistory {

	//PrimaryKey
	private AssetTransactionKey key;

	//Column("master_transaction_id")
	private Long assetTransactionMasterId;
	
	//Column("transactionAmount")
	private Double transactionAmount;
	
	//Column("product_name")
	private String productName;

	//Column("product_category")
	private String productCategory;
	
	//Column("product_category_name")
	private String productCategoryName;

	//Column("from_channel_id")
	private String fromChannelId;

	//Column("to_channle_id")
	private String toChannelId;

	//Column("from_region")
	private String fromRegionId;

	//Column("to_region")
	private String toRegion;

	//Column("from_cluster")
	private String fromCluster;

	//Column("to_cluster")
	private String toCluster;

	//Column("from_owner_id")
	private String fromOwnerId;

	//Column("to_owner_id")
	private String toOwnerId;

	//Column("from_owner_type")
	private String fromOwnerType;

	//Column("to_owner_type")
	private String toOwnerType;
	
	//Column("from_warehouse_id")
	private String fromWareHouseId;
	
	//Column("to_warehouse_id")
	private String toWareHouseId;

	//Column("cross_channel")
	private Boolean crossChannel;

	//Column("cross_region")
	private Boolean crossRegion;

	//Column("cross_cluster")
	private Boolean crossCluster;

	//Column("description")
	private String description;

	//Column("asset_status")
	private String assetStatus;

	//Column("price")
	private Double price;
	
	//Column("access_via")
	private String accessVia;
	
	//Column("payment_mode")
	private String paymentMode;
	
	//Column("checkin_id")
	private String checkinId;
	
	//Column("program_id")
	private String programId;

	//Column("program_name")
	private String programName;
	
	//Column("cancelled")
	private Boolean cancelled = false;

	//Column("created_on")
	private Date createdOn;

	//Column("created_user")
	private String createdUser;
	
	//Column("distributor_warehouse_id")
	private String distributorWarehouseId;

	public AssetTransactionKey getKey() {
		return key;
	}

	public void setKey(AssetTransactionKey key) {
		this.key = key;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public Long getAssetTransactionMasterId() {
		return assetTransactionMasterId;
	}

	public void setAssetTransactionMasterId(Long assetTransactionMasterId) {
		this.assetTransactionMasterId = assetTransactionMasterId;
	}
	
	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getFromChannelId() {
		return fromChannelId;
	}

	public void setFromChannelId(String fromChannelId) {
		this.fromChannelId = fromChannelId;
	}

	public String getToChannelId() {
		return toChannelId;
	}

	public void setToChannelId(String toChannelId) {
		this.toChannelId = toChannelId;
	}

	public String getFromOwnerId() {
		return fromOwnerId;
	}

	public void setFromOwnerId(String fromOwnerId) {
		this.fromOwnerId = fromOwnerId;
	}

	public String getToOwnerId() {
		return toOwnerId;
	}

	public void setToOwnerId(String toOwnerId) {
		this.toOwnerId = toOwnerId;
	}

	public String getFromRegionId() {
		return fromRegionId;
	}

	public void setFromRegionId(String fromRegionId) {
		this.fromRegionId = fromRegionId;
	}

	public String getToRegion() {
		return toRegion;
	}

	public void setToRegion(String toRegion) {
		this.toRegion = toRegion;
	}

	public String getFromCluster() {
		return fromCluster;
	}

	public void setFromCluster(String fromCluster) {
		this.fromCluster = fromCluster;
	}

	public String getToCluster() {
		return toCluster;
	}

	public void setToCluster(String toCluster) {
		this.toCluster = toCluster;
	}

	public String getFromOwnerType() {
		return fromOwnerType;
	}

	public void setFromOwnerType(String fromOwnerType) {
		this.fromOwnerType = fromOwnerType;
	}

	public String getToOwnerType() {
		return toOwnerType;
	}

	public void setToOwnerType(String toOwnerType) {
		this.toOwnerType = toOwnerType;
	}

	public String getFromWareHouseId() {
		return fromWareHouseId;
	}

	public void setFromWareHouseId(String fromWareHouseId) {
		this.fromWareHouseId = fromWareHouseId;
	}

	public String getToWareHouseId() {
		return toWareHouseId;
	}

	public void setToWareHouseId(String toWareHouseId) {
		this.toWareHouseId = toWareHouseId;
	}

	public Boolean getCrossChannel() {
		return crossChannel;
	}

	public void setCrossChannel(Boolean crossChannel) {
		this.crossChannel = crossChannel;
	}

	public Boolean getCrossRegion() {
		return crossRegion;
	}

	public void setCrossRegion(Boolean crossRegion) {
		this.crossRegion = crossRegion;
	}

	public Boolean getCrossCluster() {
		return crossCluster;
	}

	public void setCrossCluster(Boolean crossCluster) {
		this.crossCluster = crossCluster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAccessVia() {
		return accessVia;
	}

	public void setAccessVia(String accessVia) {
		this.accessVia = accessVia;
	}

	public String getCheckinId() {
		return checkinId;
	}

	public void setCheckinId(String checkinId) {
		this.checkinId = checkinId;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Boolean getCancelled() {
		if(null == cancelled) {
			return false;
		}
		return cancelled;
	}

	public void setCancelled(Boolean cancelled) {
		this.cancelled = cancelled;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getDistributorWarehouseId() {
		return distributorWarehouseId;
	}

	public void setDistributorWarehouseId(String distributorWarehouseId) {
		this.distributorWarehouseId = distributorWarehouseId;
	}
	
	

}
