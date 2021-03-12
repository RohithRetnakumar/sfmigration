package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.config.CassandraloaderConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderConfigManagerGen_ProvideCassandraloaderConfigFactory
    implements Factory<CassandraloaderConfig> {
  private final CassandraloaderConfigManagerGen module;

  public CassandraloaderConfigManagerGen_ProvideCassandraloaderConfigFactory(
      CassandraloaderConfigManagerGen module) {
    this.module = module;
  }

  @Override
  public CassandraloaderConfig get() {
    return provideInstance(module);
  }

  public static CassandraloaderConfig provideInstance(CassandraloaderConfigManagerGen module) {
    return proxyProvideCassandraloaderConfig(module);
  }

  public static CassandraloaderConfigManagerGen_ProvideCassandraloaderConfigFactory create(
      CassandraloaderConfigManagerGen module) {
    return new CassandraloaderConfigManagerGen_ProvideCassandraloaderConfigFactory(module);
  }

  public static CassandraloaderConfig proxyProvideCassandraloaderConfig(
      CassandraloaderConfigManagerGen instance) {
    return Preconditions.checkNotNull(
        instance.provideCassandraloaderConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
