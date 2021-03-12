package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.config.AssetTransactionStatusHistoryConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderConfigManagerGen_ProvideAssetTransactionStatusHistoryConfigFactory
    implements Factory<AssetTransactionStatusHistoryConfig> {
  private final CassandraloaderConfigManagerGen module;

  public CassandraloaderConfigManagerGen_ProvideAssetTransactionStatusHistoryConfigFactory(
      CassandraloaderConfigManagerGen module) {
    this.module = module;
  }

  @Override
  public AssetTransactionStatusHistoryConfig get() {
    return provideInstance(module);
  }

  public static AssetTransactionStatusHistoryConfig provideInstance(
      CassandraloaderConfigManagerGen module) {
    return proxyProvideAssetTransactionStatusHistoryConfig(module);
  }

  public static CassandraloaderConfigManagerGen_ProvideAssetTransactionStatusHistoryConfigFactory
      create(CassandraloaderConfigManagerGen module) {
    return new CassandraloaderConfigManagerGen_ProvideAssetTransactionStatusHistoryConfigFactory(
        module);
  }

  public static AssetTransactionStatusHistoryConfig proxyProvideAssetTransactionStatusHistoryConfig(
      CassandraloaderConfigManagerGen instance) {
    return Preconditions.checkNotNull(
        instance.provideAssetTransactionStatusHistoryConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
