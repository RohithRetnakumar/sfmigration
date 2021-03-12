package com.reds.service.cassandraloader.inject;

import com.reds.service.eventmanagementapi.EventManagement;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderServiceProviderGen_ProvideEventManagement_1_0Factory
    implements Factory<EventManagement> {
  private final CassandraloaderServiceProviderGen module;

  public CassandraloaderServiceProviderGen_ProvideEventManagement_1_0Factory(
      CassandraloaderServiceProviderGen module) {
    this.module = module;
  }

  @Override
  public EventManagement get() {
    return provideInstance(module);
  }

  public static EventManagement provideInstance(CassandraloaderServiceProviderGen module) {
    return proxyProvideEventManagement_1_0(module);
  }

  public static CassandraloaderServiceProviderGen_ProvideEventManagement_1_0Factory create(
      CassandraloaderServiceProviderGen module) {
    return new CassandraloaderServiceProviderGen_ProvideEventManagement_1_0Factory(module);
  }

  public static EventManagement proxyProvideEventManagement_1_0(
      CassandraloaderServiceProviderGen instance) {
    return Preconditions.checkNotNull(
        instance.provideEventManagement_1_0(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
