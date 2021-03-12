package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.config.CsvWriterConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderConfigManagerGen_ProvideCsvWriterConfigFactory
    implements Factory<CsvWriterConfig> {
  private final CassandraloaderConfigManagerGen module;

  public CassandraloaderConfigManagerGen_ProvideCsvWriterConfigFactory(
      CassandraloaderConfigManagerGen module) {
    this.module = module;
  }

  @Override
  public CsvWriterConfig get() {
    return provideInstance(module);
  }

  public static CsvWriterConfig provideInstance(CassandraloaderConfigManagerGen module) {
    return proxyProvideCsvWriterConfig(module);
  }

  public static CassandraloaderConfigManagerGen_ProvideCsvWriterConfigFactory create(
      CassandraloaderConfigManagerGen module) {
    return new CassandraloaderConfigManagerGen_ProvideCsvWriterConfigFactory(module);
  }

  public static CsvWriterConfig proxyProvideCsvWriterConfig(
      CassandraloaderConfigManagerGen instance) {
    return Preconditions.checkNotNull(
        instance.provideCsvWriterConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
