package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloaderapi.info.CassandraloaderInfo;
import dagger.Provides;
import javax.inject.Singleton;
import com.reds.service.cassandraloader.CassandraManager;
import com.reds.service.cassandraloader.FileAdaptorManager;

/**
 * <b>Purpose:</b>CassandraloaderModule class, injects Concrete classes for an
 * interface. It allows different modules to inject different kinds of concrete
 * implementations into our code.
 *
 * @author <b>Algols Builder</b>
 *
 *         This code is generated by Reds on 30/07/2020 02:11:30
 */
@dagger.Module
public class CassandraloaderModule {

    @Provides
    @Singleton
    public CassandraloaderInfo provideCassandraloaderInfo() {
        return new CassandraloaderInfo();
    }

    @Provides
    @Singleton
    public CassandraManager provideCassandraManager() {
        return new CassandraManager();
    }

    @Provides
    @Singleton
    public FileAdaptorManager provideFileAdaptorManager() {
        return new FileAdaptorManager();
    }
}
