package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.CassandraManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderModule_ProvideCassandraManagerFactory
    implements Factory<CassandraManager> {
  private final CassandraloaderModule module;

  public CassandraloaderModule_ProvideCassandraManagerFactory(CassandraloaderModule module) {
    this.module = module;
  }

  @Override
  public CassandraManager get() {
    return provideInstance(module);
  }

  public static CassandraManager provideInstance(CassandraloaderModule module) {
    return proxyProvideCassandraManager(module);
  }

  public static CassandraloaderModule_ProvideCassandraManagerFactory create(
      CassandraloaderModule module) {
    return new CassandraloaderModule_ProvideCassandraManagerFactory(module);
  }

  public static CassandraManager proxyProvideCassandraManager(CassandraloaderModule instance) {
    return Preconditions.checkNotNull(
        instance.provideCassandraManager(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
