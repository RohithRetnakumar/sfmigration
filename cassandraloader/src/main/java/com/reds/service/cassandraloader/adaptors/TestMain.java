package com.reds.service.cassandraloader.adaptors;

public class TestMain {
	
	
	public static void main(String[] args) {
		AssetMainDetailsAdaptor adaptor = new AssetMainDetailsAdaptor();
		adaptor.loadLookupData();
	}
}
