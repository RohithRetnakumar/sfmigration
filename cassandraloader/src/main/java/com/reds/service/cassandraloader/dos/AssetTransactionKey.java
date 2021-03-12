package com.reds.service.cassandraloader.dos;

import java.util.Date;

//PrimaryKeyClass
public class AssetTransactionKey {

	//PrimaryKeyColumn(name = "order_id", type = PrimaryKeyType.PARTITIONED)
	private String orderId;

	//PrimaryKeyColumn(name = "asset_detail_id", type = PrimaryKeyType.PARTITIONED)
	private String assetDetailId;

	//PrimaryKeyColumn(name = "transaction_id", type = PrimaryKeyType.PARTITIONED)
	private String transactionId;

	//PrimaryKeyColumn(name = "transaction_date", ordinal = 0, ordering = Ordering.DESCENDING)
	private Date transactionDate;

	//PrimaryKeyColumn(name = "process_type", ordinal = 1)
	private String processType;

	public AssetTransactionKey() {
		super();
	}

	public AssetTransactionKey(String orderId, String assetDetailId, String transactionId, Date transactionDate,
			String processType) {
		super();
		this.orderId = orderId;
		this.assetDetailId = assetDetailId;
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.processType = processType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public String getAssetDetailId() {
		return assetDetailId;
	}

	public void setAssetDetailId(String assetDetailId) {
		this.assetDetailId = assetDetailId;
	}

}
