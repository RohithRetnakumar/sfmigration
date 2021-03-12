package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.config.AssertMainDetailsConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderConfigManagerGen_ProvideAssertMainDetailsConfigFactory
    implements Factory<AssertMainDetailsConfig> {
  private final CassandraloaderConfigManagerGen module;

  public CassandraloaderConfigManagerGen_ProvideAssertMainDetailsConfigFactory(
      CassandraloaderConfigManagerGen module) {
    this.module = module;
  }

  @Override
  public AssertMainDetailsConfig get() {
    return provideInstance(module);
  }

  public static AssertMainDetailsConfig provideInstance(CassandraloaderConfigManagerGen module) {
    return proxyProvideAssertMainDetailsConfig(module);
  }

  public static CassandraloaderConfigManagerGen_ProvideAssertMainDetailsConfigFactory create(
      CassandraloaderConfigManagerGen module) {
    return new CassandraloaderConfigManagerGen_ProvideAssertMainDetailsConfigFactory(module);
  }

  public static AssertMainDetailsConfig proxyProvideAssertMainDetailsConfig(
      CassandraloaderConfigManagerGen instance) {
    return Preconditions.checkNotNull(
        instance.provideAssertMainDetailsConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
