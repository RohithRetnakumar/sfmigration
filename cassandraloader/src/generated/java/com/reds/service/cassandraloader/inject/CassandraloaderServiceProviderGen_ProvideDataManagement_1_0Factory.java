package com.reds.service.cassandraloader.inject;

import com.reds.service.datamanagementapi.DataManagement;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderServiceProviderGen_ProvideDataManagement_1_0Factory
    implements Factory<DataManagement> {
  private final CassandraloaderServiceProviderGen module;

  public CassandraloaderServiceProviderGen_ProvideDataManagement_1_0Factory(
      CassandraloaderServiceProviderGen module) {
    this.module = module;
  }

  @Override
  public DataManagement get() {
    return provideInstance(module);
  }

  public static DataManagement provideInstance(CassandraloaderServiceProviderGen module) {
    return proxyProvideDataManagement_1_0(module);
  }

  public static CassandraloaderServiceProviderGen_ProvideDataManagement_1_0Factory create(
      CassandraloaderServiceProviderGen module) {
    return new CassandraloaderServiceProviderGen_ProvideDataManagement_1_0Factory(module);
  }

  public static DataManagement proxyProvideDataManagement_1_0(
      CassandraloaderServiceProviderGen instance) {
    return Preconditions.checkNotNull(
        instance.provideDataManagement_1_0(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
