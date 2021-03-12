package com.reds.service.cassandraloader.dos;

//@PrimaryKeyClass
public class AssetDetailsKey {

	// @PrimaryKeyColumn(name = "iccid", type = PrimaryKeyType.PARTITIONED)
	private String iccId;

	// @PrimaryKeyColumn(name = "mdn_no", ordinal = 0)
	private String mdnNo;

	// @PrimaryKeyColumn(name = "product_id", ordinal = 1, ordering =
	// Ordering.ASCENDING)
	private Long productId;

	// @PrimaryKeyColumn(name = "product_category_id", ordinal = 2, ordering =
	// Ordering.ASCENDING)
	private Long productCategoryId;

	public AssetDetailsKey() {

	}

	public AssetDetailsKey(String iccId, String mdnNo, Long productId, Long productCategoryId) {
		this.iccId = iccId;
		this.mdnNo = mdnNo;
		this.productId = productId;
		this.productCategoryId = productCategoryId;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

}
