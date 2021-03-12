package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.CassandraManager;
import com.reds.service.cassandraloader.FileAdaptorManager;
import com.reds.service.cassandraloader.config.AssertMainDetailsConfig;
import com.reds.service.cassandraloader.config.AssetTransactionStatusHistoryConfig;
import com.reds.service.cassandraloader.config.CassandraloaderConfig;
import com.reds.service.cassandraloader.config.CassandraloaderTrackerConfig;
import com.reds.service.cassandraloader.config.CsvWriterConfig;
import com.reds.service.cassandraloader.config.MaterialMasterConfig;
import com.reds.service.cassandraloader.config.ProductMasterConfig;
import com.reds.service.cassandraloader.config.TestConfig;
import com.reds.service.cassandraloaderapi.info.CassandraloaderInfo;
import com.reds.service.datamanagementapi.DataManagement;
import com.reds.service.eventmanagementapi.EventManagement;
import com.reds.service.fileadapterapi.FileAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerCassandraloaderComponent implements CassandraloaderComponent {
  private CassandraloaderConfigManagerGen cassandraloaderConfigManagerGen;

  private CassandraloaderServiceProviderGen cassandraloaderServiceProviderGen;

  private Provider<CassandraloaderInfo> provideCassandraloaderInfoProvider;

  private Provider<CassandraManager> provideCassandraManagerProvider;

  private Provider<FileAdaptorManager> provideFileAdaptorManagerProvider;

  private DaggerCassandraloaderComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static CassandraloaderComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideCassandraloaderInfoProvider =
        DoubleCheck.provider(
            CassandraloaderModule_ProvideCassandraloaderInfoFactory.create(
                builder.cassandraloaderModule));
    this.cassandraloaderConfigManagerGen = builder.cassandraloaderConfigManagerGen;
    this.cassandraloaderServiceProviderGen = builder.cassandraloaderServiceProviderGen;
    this.provideCassandraManagerProvider =
        DoubleCheck.provider(
            CassandraloaderModule_ProvideCassandraManagerFactory.create(
                builder.cassandraloaderModule));
    this.provideFileAdaptorManagerProvider =
        DoubleCheck.provider(
            CassandraloaderModule_ProvideFileAdaptorManagerFactory.create(
                builder.cassandraloaderModule));
  }

  @Override
  public CassandraloaderInfo takeCassandraloaderInfo() {
    return provideCassandraloaderInfoProvider.get();
  }

  @Override
  public CassandraloaderConfig takeCassandraloaderConfig() {
    return CassandraloaderConfigManagerGen_ProvideCassandraloaderConfigFactory
        .proxyProvideCassandraloaderConfig(cassandraloaderConfigManagerGen);
  }

  @Override
  public CassandraloaderTrackerConfig takeCassandraloaderTrackerConfig() {
    return CassandraloaderConfigManagerGen_ProvideCassandraloaderTrackerConfigFactory
        .proxyProvideCassandraloaderTrackerConfig(cassandraloaderConfigManagerGen);
  }

  @Override
  public DataManagement accessDataManagement() {
    return CassandraloaderServiceProviderGen_ProvideDataManagement_1_0Factory
        .proxyProvideDataManagement_1_0(cassandraloaderServiceProviderGen);
  }

  @Override
  public FileAdapter accessFileAdapter() {
    return CassandraloaderServiceProviderGen_ProvideFileAdapter_1_0Factory
        .proxyProvideFileAdapter_1_0(cassandraloaderServiceProviderGen);
  }

  @Override
  public EventManagement accessEventManagement() {
    return CassandraloaderServiceProviderGen_ProvideEventManagement_1_0Factory
        .proxyProvideEventManagement_1_0(cassandraloaderServiceProviderGen);
  }

  @Override
  public CassandraManager takeCassandraManager() {
    return provideCassandraManagerProvider.get();
  }

  @Override
  public TestConfig takeTestConfig() {
    return CassandraloaderConfigManagerGen_ProvideTestConfigFactory.proxyProvideTestConfig(
        cassandraloaderConfigManagerGen);
  }

  @Override
  public AssertMainDetailsConfig takeAssertMainDetailsConfig() {
    return CassandraloaderConfigManagerGen_ProvideAssertMainDetailsConfigFactory
        .proxyProvideAssertMainDetailsConfig(cassandraloaderConfigManagerGen);
  }

  @Override
  public AssetTransactionStatusHistoryConfig takeAssetTransactionStatusHistoryConfig() {
    return CassandraloaderConfigManagerGen_ProvideAssetTransactionStatusHistoryConfigFactory
        .proxyProvideAssetTransactionStatusHistoryConfig(cassandraloaderConfigManagerGen);
  }

  @Override
  public ProductMasterConfig takeProductMasterConfig() {
    return CassandraloaderConfigManagerGen_ProvideProductMasterConfigFactory
        .proxyProvideProductMasterConfig(cassandraloaderConfigManagerGen);
  }

  @Override
  public FileAdaptorManager takeFileAdaptorManager() {
    return provideFileAdaptorManagerProvider.get();
  }

  @Override
  public CsvWriterConfig takeCsvWriterConfig() {
    return CassandraloaderConfigManagerGen_ProvideCsvWriterConfigFactory
        .proxyProvideCsvWriterConfig(cassandraloaderConfigManagerGen);
  }

  @Override
  public MaterialMasterConfig takeMaterialMasterConfig() {
    return CassandraloaderConfigManagerGen_ProvideMaterialMasterConfigFactory
        .proxyProvideMaterialMasterConfig(cassandraloaderConfigManagerGen);
  }

  public static final class Builder {
    private CassandraloaderModule cassandraloaderModule;

    private CassandraloaderConfigManagerGen cassandraloaderConfigManagerGen;

    private CassandraloaderServiceProviderGen cassandraloaderServiceProviderGen;

    private Builder() {}

    public CassandraloaderComponent build() {
      if (cassandraloaderModule == null) {
        this.cassandraloaderModule = new CassandraloaderModule();
      }
      if (cassandraloaderConfigManagerGen == null) {
        this.cassandraloaderConfigManagerGen = new CassandraloaderConfigManagerGen();
      }
      if (cassandraloaderServiceProviderGen == null) {
        this.cassandraloaderServiceProviderGen = new CassandraloaderServiceProviderGen();
      }
      return new DaggerCassandraloaderComponent(this);
    }

    public Builder cassandraloaderModule(CassandraloaderModule cassandraloaderModule) {
      this.cassandraloaderModule = Preconditions.checkNotNull(cassandraloaderModule);
      return this;
    }

    public Builder cassandraloaderConfigManagerGen(
        CassandraloaderConfigManagerGen cassandraloaderConfigManagerGen) {
      this.cassandraloaderConfigManagerGen =
          Preconditions.checkNotNull(cassandraloaderConfigManagerGen);
      return this;
    }

    public Builder cassandraloaderServiceProviderGen(
        CassandraloaderServiceProviderGen cassandraloaderServiceProviderGen) {
      this.cassandraloaderServiceProviderGen =
          Preconditions.checkNotNull(cassandraloaderServiceProviderGen);
      return this;
    }
  }
}
