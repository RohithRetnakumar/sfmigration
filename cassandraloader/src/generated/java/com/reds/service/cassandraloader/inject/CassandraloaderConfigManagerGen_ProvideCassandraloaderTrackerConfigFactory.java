package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.config.CassandraloaderTrackerConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderConfigManagerGen_ProvideCassandraloaderTrackerConfigFactory
    implements Factory<CassandraloaderTrackerConfig> {
  private final CassandraloaderConfigManagerGen module;

  public CassandraloaderConfigManagerGen_ProvideCassandraloaderTrackerConfigFactory(
      CassandraloaderConfigManagerGen module) {
    this.module = module;
  }

  @Override
  public CassandraloaderTrackerConfig get() {
    return provideInstance(module);
  }

  public static CassandraloaderTrackerConfig provideInstance(
      CassandraloaderConfigManagerGen module) {
    return proxyProvideCassandraloaderTrackerConfig(module);
  }

  public static CassandraloaderConfigManagerGen_ProvideCassandraloaderTrackerConfigFactory create(
      CassandraloaderConfigManagerGen module) {
    return new CassandraloaderConfigManagerGen_ProvideCassandraloaderTrackerConfigFactory(module);
  }

  public static CassandraloaderTrackerConfig proxyProvideCassandraloaderTrackerConfig(
      CassandraloaderConfigManagerGen instance) {
    return Preconditions.checkNotNull(
        instance.provideCassandraloaderTrackerConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
