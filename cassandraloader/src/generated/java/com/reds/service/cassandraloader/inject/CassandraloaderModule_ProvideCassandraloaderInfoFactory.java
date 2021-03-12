package com.reds.service.cassandraloader.inject;

import com.reds.service.cassandraloaderapi.info.CassandraloaderInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CassandraloaderModule_ProvideCassandraloaderInfoFactory
    implements Factory<CassandraloaderInfo> {
  private final CassandraloaderModule module;

  public CassandraloaderModule_ProvideCassandraloaderInfoFactory(CassandraloaderModule module) {
    this.module = module;
  }

  @Override
  public CassandraloaderInfo get() {
    return provideInstance(module);
  }

  public static CassandraloaderInfo provideInstance(CassandraloaderModule module) {
    return proxyProvideCassandraloaderInfo(module);
  }

  public static CassandraloaderModule_ProvideCassandraloaderInfoFactory create(
      CassandraloaderModule module) {
    return new CassandraloaderModule_ProvideCassandraloaderInfoFactory(module);
  }

  public static CassandraloaderInfo proxyProvideCassandraloaderInfo(
      CassandraloaderModule instance) {
    return Preconditions.checkNotNull(
        instance.provideCassandraloaderInfo(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
