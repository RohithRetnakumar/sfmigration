package com.reds.service.cassandraloader.inject;

import com.reds.service.fileadapterapi.FileAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderServiceProviderGen_ProvideFileAdapter_1_0Factory
    implements Factory<FileAdapter> {
  private final CassandraloaderServiceProviderGen module;

  public CassandraloaderServiceProviderGen_ProvideFileAdapter_1_0Factory(
      CassandraloaderServiceProviderGen module) {
    this.module = module;
  }

  @Override
  public FileAdapter get() {
    return provideInstance(module);
  }

  public static FileAdapter provideInstance(CassandraloaderServiceProviderGen module) {
    return proxyProvideFileAdapter_1_0(module);
  }

  public static CassandraloaderServiceProviderGen_ProvideFileAdapter_1_0Factory create(
      CassandraloaderServiceProviderGen module) {
    return new CassandraloaderServiceProviderGen_ProvideFileAdapter_1_0Factory(module);
  }

  public static FileAdapter proxyProvideFileAdapter_1_0(
      CassandraloaderServiceProviderGen instance) {
    return Preconditions.checkNotNull(
        instance.provideFileAdapter_1_0(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
