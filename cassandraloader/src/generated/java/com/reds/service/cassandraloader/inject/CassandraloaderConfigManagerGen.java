package com.reds.service.cassandraloader.inject;

import com.reds.library.redscommons.exception.RedscommonsException;
import com.reds.platform.redsplatformcommons.config.AbstractConfigurationManager;
import com.reds.service.cassandraloader.config.AssertMainDetailsConfig;
import com.reds.service.cassandraloader.config.AssetTransactionStatusHistoryConfig;
import com.reds.service.cassandraloader.config.CassandraloaderConfig;
import com.reds.service.cassandraloader.config.CassandraloaderTrackerConfig;
import com.reds.service.cassandraloader.config.CsvWriterConfig;
import com.reds.service.cassandraloader.config.MaterialMasterConfig;
import com.reds.service.cassandraloader.config.ProductMasterConfig;
import com.reds.service.cassandraloader.config.TestConfig;
import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;
import dagger.Module;
import dagger.Provides;

/**
 * <b>Purpose: </b> Configuration class for CassandraloaderConfigManagerGen
 *
 *  @author <b>REDS GENERATOR</b>
 *
 *  @since  */
@Module
public final class CassandraloaderConfigManagerGen extends AbstractConfigurationManager {
  public CassandraloaderConfigManagerGen() {
    super(CassandraloaderTreasury.serviceContext.getConfigLocation());
    register();
    try {
    	init();
    } catch (RedscommonsException e) {
    	CassandraloaderTrack.me.error("Failed to initialize configurations ", e);
    }
  }

  /**
   * <b>Purpose: </b> To provide...AssertMainDetailsConfig */
  @Provides
  public AssertMainDetailsConfig provideAssertMainDetailsConfig() {
    try {
    	return (AssertMainDetailsConfig) super.read(new AssertMainDetailsConfig());
    } catch (RedscommonsException e) {
    	CassandraloaderTrack.me.error("Failed to read configuration", e);
    }
    return null;
  }

  /**
   * <b>Purpose: </b> To provide...AssetTransactionStatusHistoryConfig */
  @Provides
  public AssetTransactionStatusHistoryConfig provideAssetTransactionStatusHistoryConfig() {
    try {
    	return (AssetTransactionStatusHistoryConfig) super.read(new AssetTransactionStatusHistoryConfig());
    } catch (RedscommonsException e) {
    	CassandraloaderTrack.me.error("Failed to read configuration", e);
    }
    return null;
  }

  /**
   * <b>Purpose: </b> To provide...CassandraloaderConfig */
  @Provides
  public CassandraloaderConfig provideCassandraloaderConfig() {
    try {
    	return (CassandraloaderConfig) super.read(new CassandraloaderConfig());
    } catch (RedscommonsException e) {
    	CassandraloaderTrack.me.error("Failed to read configuration", e);
    }
    return null;
  }

  /**
   * <b>Purpose: </b> To provide...CassandraloaderTrackerConfig */
  @Provides
  public CassandraloaderTrackerConfig provideCassandraloaderTrackerConfig() {
    try {
    	return (CassandraloaderTrackerConfig) super.read(new CassandraloaderTrackerConfig());
    } catch (RedscommonsException e) {
    	CassandraloaderTrack.me.error("Failed to read configuration", e);
    }
    return null;
  }

  /**
   * <b>Purpose: </b> To provide...CsvWriterConfig */
  @Provides
  public CsvWriterConfig provideCsvWriterConfig() {
    try {
    	return (CsvWriterConfig) super.read(new CsvWriterConfig());
    } catch (RedscommonsException e) {
    	CassandraloaderTrack.me.error("Failed to read configuration", e);
    }
    return null;
  }

  /**
   * <b>Purpose: </b> To provide...MaterialMasterConfig */
  @Provides
  public MaterialMasterConfig provideMaterialMasterConfig() {
    try {
    	return (MaterialMasterConfig) super.read(new MaterialMasterConfig());
    } catch (RedscommonsException e) {
    	CassandraloaderTrack.me.error("Failed to read configuration", e);
    }
    return null;
  }

  /**
   * <b>Purpose: </b> To provide...ProductMasterConfig */
  @Provides
  public ProductMasterConfig provideProductMasterConfig() {
    try {
    	return (ProductMasterConfig) super.read(new ProductMasterConfig());
    } catch (RedscommonsException e) {
    	CassandraloaderTrack.me.error("Failed to read configuration", e);
    }
    return null;
  }

  /**
   * <b>Purpose: </b> To provide...TestConfig */
  @Provides
  public TestConfig provideTestConfig() {
    try {
    	return (TestConfig) super.read(new TestConfig());
    } catch (RedscommonsException e) {
    	CassandraloaderTrack.me.error("Failed to read configuration", e);
    }
    return null;
  }

  private void register() {
    super.registerConfig(AssertMainDetailsConfig.class);
    super.registerConfig(AssetTransactionStatusHistoryConfig.class);
    super.registerConfig(CassandraloaderConfig.class);
    super.registerConfig(CassandraloaderTrackerConfig.class);
    super.registerConfig(CsvWriterConfig.class);
    super.registerConfig(MaterialMasterConfig.class);
    super.registerConfig(ProductMasterConfig.class);
    super.registerConfig(TestConfig.class);
  }

  private void init() throws RedscommonsException {
    super.initConfig(new AssertMainDetailsConfig().getDefault());
    super.initConfig(new AssetTransactionStatusHistoryConfig().getDefault());
    super.initConfig(new CassandraloaderConfig().getDefault());
    super.initConfig(new CassandraloaderTrackerConfig().getDefault());
    super.initConfig(new CsvWriterConfig().getDefault());
    super.initConfig(new MaterialMasterConfig().getDefault());
    super.initConfig(new ProductMasterConfig().getDefault());
    super.initConfig(new TestConfig().getDefault());
  }
}
