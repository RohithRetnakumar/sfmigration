package com.reds.service.cassandraloader.config;

import com.reds.library.redscommons.tracker.TrackerConfig; 
import com.reds.generator.redsannotations.Configuration; 
import com.reds.library.redscommons.config.PlatformConfig; 
/**
 * <b>Purpose:</b> Tracker configuration Cassandraloader.
 * 
 * @author <b>Algols Builder</b>
 *
 * This code is generated by Reds on 30/07/2020 02:11:30
 */
@Configuration
public class CassandraloaderTrackerConfig extends TrackerConfig {

	public CassandraloaderTrackerConfig() {

	}

	@Override
	public PlatformConfig getDefault() {
		return this;
	}
}
