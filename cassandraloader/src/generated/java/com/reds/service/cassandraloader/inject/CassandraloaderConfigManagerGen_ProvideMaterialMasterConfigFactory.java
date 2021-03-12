package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.config.MaterialMasterConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderConfigManagerGen_ProvideMaterialMasterConfigFactory
    implements Factory<MaterialMasterConfig> {
  private final CassandraloaderConfigManagerGen module;

  public CassandraloaderConfigManagerGen_ProvideMaterialMasterConfigFactory(
      CassandraloaderConfigManagerGen module) {
    this.module = module;
  }

  @Override
  public MaterialMasterConfig get() {
    return provideInstance(module);
  }

  public static MaterialMasterConfig provideInstance(CassandraloaderConfigManagerGen module) {
    return proxyProvideMaterialMasterConfig(module);
  }

  public static CassandraloaderConfigManagerGen_ProvideMaterialMasterConfigFactory create(
      CassandraloaderConfigManagerGen module) {
    return new CassandraloaderConfigManagerGen_ProvideMaterialMasterConfigFactory(module);
  }

  public static MaterialMasterConfig proxyProvideMaterialMasterConfig(
      CassandraloaderConfigManagerGen instance) {
    return Preconditions.checkNotNull(
        instance.provideMaterialMasterConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
