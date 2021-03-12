package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.config.TestConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderConfigManagerGen_ProvideTestConfigFactory
    implements Factory<TestConfig> {
  private final CassandraloaderConfigManagerGen module;

  public CassandraloaderConfigManagerGen_ProvideTestConfigFactory(
      CassandraloaderConfigManagerGen module) {
    this.module = module;
  }

  @Override
  public TestConfig get() {
    return provideInstance(module);
  }

  public static TestConfig provideInstance(CassandraloaderConfigManagerGen module) {
    return proxyProvideTestConfig(module);
  }

  public static CassandraloaderConfigManagerGen_ProvideTestConfigFactory create(
      CassandraloaderConfigManagerGen module) {
    return new CassandraloaderConfigManagerGen_ProvideTestConfigFactory(module);
  }

  public static TestConfig proxyProvideTestConfig(CassandraloaderConfigManagerGen instance) {
    return Preconditions.checkNotNull(
        instance.provideTestConfig(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
