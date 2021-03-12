package com.reds.service.cassandraloader.dos;

import java.util.Date;

public class ProductMaster {

	private ProductKey key;

	private String productName;

	private String description;

	private String productCategory;

	private String productCategoryName;

	private String productType;

	private String productHierarchyCode;

	private String productHierarchy;

	private String createdUser;

	private Date createdOn;

	private String modifiedUser;

	private Date modifiedOn;

	public ProductKey getKey() {
		return key;
	}

	public void setKey(ProductKey key) {
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

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductHierarchyCode() {
		return productHierarchyCode;
	}

	public void setProductHierarchyCode(String productHierarchyCode) {
		this.productHierarchyCode = productHierarchyCode;
	}

	public String getProductHierarchy() {
		return productHierarchy;
	}

	public void setProductHierarchy(String productHierarchy) {
		this.productHierarchy = productHierarchy;
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

}
