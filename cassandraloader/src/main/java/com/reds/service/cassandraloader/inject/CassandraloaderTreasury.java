package com.reds.service.cassandraloader.inject;

import com.reds.platform.servicecommons.context.CloseContext;
import com.reds.platform.servicecommons.context.DeploymentContext;
import com.reds.platform.servicecommons.context.InitContext;
import com.reds.platform.servicecommons.context.ServiceContext;
import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack; 
/**
 * <b>Purpose:</b> Treasury class provides the way to all the classes of this
 * module to injected objects
 * 
 * @author <b>Algols Builder</b>
 *
 * This code is generated by Reds on 30/07/2020 02:11:30
 */
public class CassandraloaderTreasury {

	public static CassandraloaderComponent open;	
	public static InitContext initContext;
	public static ServiceContext serviceContext;
	public static CloseContext closeContext;
	public static DeploymentContext deploymentContext;

	public static void init(ServiceContext serviceContext){
		CassandraloaderTreasury.serviceContext=serviceContext;
		/* Initialising Component Object */		
		CassandraloaderTreasury.open = DaggerCassandraloaderComponent.create();		
		CassandraloaderTrack.init(CassandraloaderTreasury.open.takeCassandraloaderTrackerConfig());
	}

}
