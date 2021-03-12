package com.reds.service.cassandraloader.inject;

import com.reds.platform.servicecommons.AbstractServiceProvider;
import com.reds.service.datamanagementapi.DataManagement;
import com.reds.service.eventmanagementapi.EventManagement;
import com.reds.service.fileadapterapi.FileAdapter;
import dagger.Module;
import dagger.Provides;

/**
 * <b>Purpose: </b> Service Provider class for CassandraloaderServiceProviderGen
 *
 *  @author <b>REDS GENERATOR</b>
 *
 *  @since  */
@Module
public final class CassandraloaderServiceProviderGen extends AbstractServiceProvider {
  public CassandraloaderServiceProviderGen() {
    super(CassandraloaderTreasury.serviceContext);
  }

  /**
   * <b>Purpose: </b> To provide DataManagement1.0 */
  @Provides
  public DataManagement provideDataManagement_1_0() {
    return (DataManagement) super.getServiceContext().getService("DataManagement", "1.0");
  }

  /**
   * <b>Purpose: </b> To provide FileAdapter1.0 */
  @Provides
  public FileAdapter provideFileAdapter_1_0() {
    return (FileAdapter) super.getServiceContext().getService("FileAdapter", "1.0");
  }

  /**
   * <b>Purpose: </b> To provide EventManagement1.0 */
  @Provides
  public EventManagement provideEventManagement_1_0() {
    return (EventManagement) super.getServiceContext().getService("EventManagement", "1.0");
  }
}
