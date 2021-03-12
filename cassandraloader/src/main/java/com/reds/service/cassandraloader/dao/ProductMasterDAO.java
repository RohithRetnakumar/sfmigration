package com.reds.service.cassandraloader.dao;

import java.util.List;

import com.reds.service.cassandraloader.dos.ProductMaster;

public interface ProductMasterDAO {
	public void insert(List<ProductMaster> dos) throws Exception;
}
