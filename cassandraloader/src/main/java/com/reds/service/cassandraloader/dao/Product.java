package com.reds.service.cassandraloader.dao;

import java.util.Date;

//@Entity
//@Table(name = "MATERIAL_MASTER")
public class Product {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	private Long id;

	//@Column(name = "material")
	private String material;

	//@Column(name = "description")
	private String description;

	//@Column(name = "uom")
	private String uom;

	//@Column(name = "sales_organisation")
	private String salesOrganisation;

	//@Column(name = "distribution_channel")
	private String distributionChannel;

	//@Column(name = "product_hierarchy")
	private String productHierarchy;

	// Change name to materialGroup
	//@OneToOne
	//@JoinColumn(name = "material_group_id")
	private ProductCategory productCategory;

	//@Column(name = "gross_weight")
	private String grossWeight;

	//@Column(name = "weight_unit")
	private String weightUnit;

	//@OneToOne
	//@JoinColumn(name = "material_type_id")
	private MaterialType materialType;

	// Below fields are not mapped in SAP

	// Set same value in description, set internally
	//@Column(name = "material_name")
	private String productName;

	//@Column(name = "material_image")
	private String productImage;

	//@Column(name = "deletion_flag")
	private boolean deletionFlag = false;

	//@CreationTimestamp
	//@Column(name = "created_on")
	private Date createdOn;

	//@UpdateTimestamp
	//@Column(name = "modified_on")
	private Date modifiedOn;

	// @Version
	private int version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
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

	public String getProductHierarchy() {
		return productHierarchy;
	}

	public void setProductHierarchy(String productHierarchy) {
		this.productHierarchy = productHierarchy;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
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

	public MaterialType getMaterialType() {
		return materialType;
	}

	public void setMaterialType(MaterialType materialType) {
		this.materialType = materialType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public boolean isDeletionFlag() {
		return deletionFlag;
	}

	public void setDeletionFlag(boolean deletionFlag) {
		this.deletionFlag = deletionFlag;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
