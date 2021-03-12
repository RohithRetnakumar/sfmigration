package com.reds.service.cassandraloader.dao;

import java.util.List;

import com.reds.service.cassandraloader.dos.AssetCassandraTransactionHistory;

public interface AssetTransactionStatusHistoryDAO {
	public void insert(List<AssetCassandraTransactionHistory> dos) throws Exception;
}
