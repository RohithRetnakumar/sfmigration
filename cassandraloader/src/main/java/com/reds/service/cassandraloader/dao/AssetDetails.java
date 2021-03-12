package com.reds.service.cassandraloader.dao;

import java.io.Serializable;
import java.util.Date;


// @Entity
// @Table(name = "ASSET_DETAILS")
public class AssetDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8654674977021014048L;

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id")
	private Long id;

	// @Column(name = "iccid")
	private String iccId;

	// @Column(name = "mdn_no")
	private String mdnNo;

	// @Column(name = "meid")
	private String meId;

	// @Column(name = "subs_id")
	private String subsId;

	// @Column(name = "migrated_yes_no")
	private boolean migratedYesNo = false;

	// @Column(name = "price")
	private Double price;

	// @Column(name = "channel_id")
	private String channelId;

	// @Column(name = "region_id")
	private String regionId;

	// @Column(name = "cluster_id")
	private String clusterId;

	// @Column(name = "owner_type")
	private String ownerType;

	// @Column(name = "owner_id")
	private String ownerId;

	// @Column(name = "distributor_id")
	private String distributorId;

	// @Column(name = "box_id")
	private String boxId;

	// @Column(name = "production_warehouse_id")
	private Long productionWarehouseId;

	// @Column(name = "distribution_warehouse_id")
	private Long distributionWarehouseId;

	// @Column(name = "expiry_date")
	private Date expiryDate;

	// @Column(name = "activation_date")
	private Date activationDate;

	// @Column(name = "termination_date")
	private Date terminationDate;

	// @Column(name = "description")
	private String description;

	// @Column(name = "created_user")
	private String createdUser;
	
	// @Column(name = "modified_user")
	private String modifiedUser;

	// @CreationTimestamp
	// @Column(name = "created_on")
	private Date createdOn;

	// @UpdateTimestamp
	// @Column(name = "modified_on")
	private Date modifiedOn;

	// @OneToOne
	// @JoinColumn(name = "Product_id")
	private Product product;

	// @OneToOne
	// @JoinColumn(name = "asset_states_id")
	private AssetStates assetStates;

	// @Column(name = "status")
	private String status;
	
	// @Column(name = "do_number")
	private String doNumber;

	// @Transient
	private ProductPrice productPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoNumber() {
		return doNumber;
	}

	public void setDoNumber(String doNumber) {
		this.doNumber = doNumber;
	}

	public String getIccId() {
		return iccId;
	}

	public void setIccId(String iccId) {
		this.iccId = iccId;
	}

	public String getMdnNo() {
		return mdnNo;
	}

	public void setMdnNo(String mdnNo) {
		this.mdnNo = mdnNo;
	}

	public String getMeId() {
		return meId;
	}

	public void setMeId(String meId) {
		this.meId = meId;
	}

	public String getSubsId() {
		return subsId;
	}

	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}

	public Boolean getMigratedYesNo() {
		return migratedYesNo;
	}

	public void setMigratedYesNo(Boolean migratedYesNo) {
		this.migratedYesNo = migratedYesNo;
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

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public AssetStates getAssetStates() {
		return assetStates;
	}

	public void setAssetStates(AssetStates assetStates) {
		this.assetStates = assetStates;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProductPrice getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(ProductPrice productPrice) {
		this.productPrice = productPrice;
	}


}
