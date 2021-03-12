package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.config.ProductMasterConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderConfigManagerGen_ProvideProductMasterConfigFactory
    implements Factory<ProductMasterConfig> {
  private final CassandraloaderConfigManagerGen module;

  public CassandraloaderConfigManagerGen_ProvideProductMasterConfigFactory(
      CassandraloaderConfigManagerGen module) {
    this.module = module;
  }

  @Override
  public ProductMasterConfig get() {
    return provideInstance(module);
  }

  public static ProductMasterConfig provideInstance(CassandraloaderConfigManagerGen module) {
    return proxyProvideProductMasterConfig(module);
  }

  public static CassandraloaderConfigManagerGen_ProvideProductMasterConfigFactory create(
      CassandraloaderConfigManagerGen module) {
    return new CassandraloaderConfigManagerGen_ProvideProductMasterConfigFactory(module);
  }

  public static ProductMasterConfig proxyProvideProductMasterConfig(
      CassandraloaderConfigManagerGen instance) {
    return Preconditions.checkNotNull(
        instance.provideProductMasterConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
