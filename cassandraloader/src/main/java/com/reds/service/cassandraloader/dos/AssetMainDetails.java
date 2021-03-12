package com.reds.service.cassandraloader.dos;

import java.util.Date;

//@Table("asset_main_details")
public class AssetMainDetails {

	// @PrimaryKey
	private AssetDetailsKey key;

	// @Column("id")
	private String id;

	// @Column("price")
	private Double price;

	// @Column("channel_id")
	private String channelId;

	// @Column("region_id")
	private String region;

	// @Column("cluster_id")
	private String cluster;

	// @Column("owner_id")
	private String ownerId;

	// @Column("owner_type")
	private String ownerType;

	// @Column("production_warehouse_id")
	private Long productionWarehouseId;

	// @Column("distribution_warehouse_id")
	private Long distributionWarehouseId;

	// @Column("distributor_id")
	private String distributorId;

	// @Column("box_id")
	private String boxId;

	// @Column("master_box")
	private String masterBox;

	// @Column("expiry_date")
	private Date expiryDate;

	// @Column("product_name")
	private String productName;

	// @Column("product_category_name")
	private String productCategoryName;

	// @Column("asset_status")
	private String assetStatus;

	// @Column("activation_date")
	private Date activationDate;

	// @Column("termination_date")
	private Date terminationDate;

	// @Column("description")
	private String description;

	// @Column("created_user")
	private String createdUser;

	// @Column("modified_user")
	private String modifiedUser;

	// @Column("created_on")
	private Date createdOn;

	// @Column("modified_on")
	private Date modifiedOn;

	// @Column("asset_data_json")
	private String assetDataJson;

	// @Column("status")
	private String status;

	public AssetDetailsKey getKey() {
		return key;
	}

	public void setKey(AssetDetailsKey key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
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

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getMasterBox() {
		return masterBox;
	}

	public void setMasterBox(String masterBox) {
		this.masterBox = masterBox;
	}

	public Long getProductionWarehouseId() {
		return productionWarehouseId;
	}

	public void setProductionWarehouseId(Long productionWarehouseId) {
		this.productionWarehouseId = productionWarehouseId;
	}

	public Long getDistributionWarehouseId() {
		return distributionWarehouseId;
	}

	public void setDistributionWarehouseId(Long distributionWarehouseId) {
		this.distributionWarehouseId = distributionWarehouseId;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getAssetDataJson() {
		return assetDataJson;
	}

	public void setAssetDataJson(String assetDataJson) {
		this.assetDataJson = assetDataJson;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}