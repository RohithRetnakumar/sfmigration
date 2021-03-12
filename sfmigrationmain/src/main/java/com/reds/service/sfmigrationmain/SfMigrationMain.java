package com.reds.service.sfmigrationmain;

import com.reds.platform.platformmanagement.Platform;
import com.reds.platform.platformmanagement.inject.PlatformmanagementTreasury;
import com.reds.platform.servicecommons.ServiceLookUp;
import com.reds.platform.servicecommons.context.ServiceContext;
import com.reds.platform.servicecommons.exception.ServiceException;
import com.reds.service.cassandraloader.CassandraloaderImpl;

/**
 * <b>Purpose:</b> This is the main class to test the services.
 * 
 * @author <b>Algols Service Builder</b>
 *
 *         This code is generated by Reds on 30/07/2020 01:46:16
 */
public class SfMigrationMain {

	public static void main(String[] args) {
      Platform.main(args);
      CassandraloaderImpl loader = new CassandraloaderImpl();
      try {
		loader.start(new ServiceContext((ServiceLookUp) PlatformmanagementTreasury.open.takeServiceRegistry(),
					".\\workspace\\businesspot\\Cassandraloader1.0\\config"));
		//new bitbucket checkin check 3
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
