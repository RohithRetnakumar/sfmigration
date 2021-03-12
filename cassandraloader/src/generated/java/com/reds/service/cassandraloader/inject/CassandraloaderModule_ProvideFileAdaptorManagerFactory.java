package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloader.FileAdaptorManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderModule_ProvideFileAdaptorManagerFactory
    implements Factory<FileAdaptorManager> {
  private final CassandraloaderModule module;

  public CassandraloaderModule_ProvideFileAdaptorManagerFactory(CassandraloaderModule module) {
    this.module = module;
  }

  @Override
  public FileAdaptorManager get() {
    return provideInstance(module);
  }

  public static FileAdaptorManager provideInstance(CassandraloaderModule module) {
    return proxyProvideFileAdaptorManager(module);
  }

  public static CassandraloaderModule_ProvideFileAdaptorManagerFactory create(
      CassandraloaderModule module) {
    return new CassandraloaderModule_ProvideFileAdaptorManagerFactory(module);
  }

  public static FileAdaptorManager proxyProvideFileAdaptorManager(CassandraloaderModule instance) {
    return Preconditions.checkNotNull(
        instance.provideFileAdaptorManager(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
