package com.reds.service.cassandraloaderapi.info;

import javax.inject.Singleton;

import com.reds.library.redscommons.info.Info;

/**
 * <b>Purpose:</b> Provide information of this module(Cassandraloader) , like name, author and
 * generated date etc. Only for informative purpose:
 * 
 * @author <b>Algols Builder</b>
 *
 * This code is generated by Reds on 30/07/2020 02:11:30
 */
@Singleton
public class CassandraloaderInfo implements Info {

	private String name = "CassandraloaderInfo";

	private String author = "Algols Builder";

	private String generatedDate = "30/07/2020 02:11:30";

	public CassandraloaderInfo() {

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public String getGeneratedDate() {
		return generatedDate;
	}

}