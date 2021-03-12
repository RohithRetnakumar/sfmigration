package com.reds.service.cassandraloader.dos;

public class MaterialMaster {

	// @PrimaryKey
	private MaterialKey key;

	// @Column("product_name")
	private String productName;

	// @Column("description")
	private String description;

	// @Column("material_group")
	private String productCategory;

	// @Column("material_group_description")
	private String materialGroupDescription;

	// @Column("material_type")
	private String materialType;

	// @Column("material_grouping")
	private String materialGrouping;

	// @Column("product_hierarchy")
	private String productHierarchy;

	// @Column("uom")
	private String uom;

	// @Column("gross_weight")
	private String grossWeight;

	// @Column("weight_unit")
	private String weightUnit;

	// @Column("sales_organisation")
	private String salesOrganisation;

	// @Column("distribution_channel")
	private String distributionChannel;

	// @Column("deletion_flag")
	private boolean deletionFlag = false;

	public MaterialKey getKey() {
		return key;
	}

	public void setKey(MaterialKey key) {
		this.key = key;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialGrouping() {
		return materialGrouping;
	}

	public void setMaterialGrouping(String materialGrouping) {
		this.materialGrouping = materialGrouping;
	}

	public String getProductHierarchy() {
		return productHierarchy;
	}

	public void setProductHierarchy(String productHierarchy) {
		this.productHierarchy = productHierarchy;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getSalesOrganisation() {
		return salesOrganisation;
	}

	public void setSalesOrganisation(String salesOrganisation) {
		this.salesOrganisation = salesOrganisation;
	}

	public String getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	public boolean isDeletionFlag() {
		return deletionFlag;
	}

	public void setDeletionFlag(boolean deletionFlag) {
		this.deletionFlag = deletionFlag;
	}

	public String getMaterialGroupDescription() {
		return materialGroupDescription;
	}

	public void setMaterialGroupDescription(String materialGroupDescription) {
		this.materialGroupDescription = materialGroupDescription;
	}

}
