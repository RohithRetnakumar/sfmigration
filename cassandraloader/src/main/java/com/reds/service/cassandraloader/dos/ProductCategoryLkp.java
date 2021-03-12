package com.reds.service.cassandraloader.dos;

public class ProductCategoryLkp {

	private long productId;
	private String productName;
	private long categoryId;
	private String categoryName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ProductCategoryLkp [productId=" + productId + ", productName=" + productName + ", categoryId="
				+ categoryId + ", categoryName=" + categoryName + "]";
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
}
