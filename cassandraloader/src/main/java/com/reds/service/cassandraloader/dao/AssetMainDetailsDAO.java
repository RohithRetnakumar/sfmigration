package com.reds.service.cassandraloader.dao;

import java.util.List;

import com.reds.service.cassandraloader.dos.AssetMainDetails;

public interface AssetMainDetailsDAO {

	public void insert(List<AssetMainDetails> dos) throws Exception;

}
