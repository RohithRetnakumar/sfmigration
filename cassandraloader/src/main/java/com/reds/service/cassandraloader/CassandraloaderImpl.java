package com.reds.service.cassandraloader;

import com.reds.platform.servicecommons.AbstractService;
import com.reds.platform.servicecommons.context.CloseContext;
import com.reds.platform.servicecommons.context.DeploymentContext;
import com.reds.platform.servicecommons.context.InitContext;
import com.reds.platform.servicecommons.context.ServiceContext;
import com.reds.platform.servicecommons.exception.ServiceException;
import com.reds.service.cassandraloader.inject.CassandraloaderTreasury;
import com.reds.service.cassandraloaderapi.info.CassandraloaderInfo;
import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;
import com.reds.service.cassandraloaderapi.Cassandraloader;
import com.reds.service.cassandraloaderapi.exception.CassandraloaderException;
import com.reds.generator.redsannotations.Required;
import com.reds.generator.redsannotations.CoService;
import com.reds.service.datamanagementapi.DataManagement;
import com.reds.service.fileadapterapi.FileAdapter;
import com.reds.service.eventmanagementapi.EventManagement;

/**
 * <b>Purpose:</b> Implementation class for Cassandraloader service.
 *
 * @author <b>Algols Builder</b>
 *
 * This code is generated by Reds on 30/07/2020 02:11:30.
 */
@Required({ @CoService(name = "DataManagement", version = "1.0", service = DataManagement.class, exposeAsWeb = false, expose = false), @CoService(name = "FileAdapter", version = "1.0", service = FileAdapter.class, exposeAsWeb = false, expose = false), @CoService(name = "EventManagement", version = "1.0", service = EventManagement.class, exposeAsWeb = false, expose = false) })
public class CassandraloaderImpl extends AbstractService implements Cassandraloader {

    /**
     *  Platform call this method immediately AFTER  Cassandraloader service DEPLOYED in platform. <br>
     *  DeploymentContext holds deployment information of Cassandraloader service.<br>
     *  You will get Cassandraloader's <br>
     *  <b>1</b> Service Type (platform/business) <br>
     *  <b>2</b> Service Name and Service Version <br>
     *  <b>3</b> Physical location, configuration directory location <br>
     *  <b>4</b> Dependency libraries directory location
     *  <br>
     *  from deployment context.
     *
     *  @see com.reds.platform.servicecommons.Service#deployed(com.reds.platform.servicecommons.context.DeploymentContext)
     */
    @Override
    public void deployed(DeploymentContext context) throws ServiceException {
        CassandraloaderTreasury.deploymentContext = context;
        CassandraloaderTrack.me.info("Cassandraloader-Service:Deployed at {}", context.getServiceLocation());
    }

    /**
     *  Platform call this method immediately BEFORE  Cassandraloader service STARTED in platform. <br>
     *  You can use this method to initialise any resources required.
     *  @see com.reds.platform.servicecommons.Service#init(com.reds.platform.servicecommons.context.InitContext)
     */
    @Override
    public void init(InitContext context) throws ServiceException {
        CassandraloaderTreasury.initContext = context;
        CassandraloaderTrack.me.info("Cassandraloader-Service:Initialised");
    }

    /**
     *  Platform call this method for STARTING Cassandraloader service  <br>
     *  You can use this method to start internal service components.
     *  @see com.reds.platform.servicecommons.Service#start(com.reds.platform.servicecommons.context.ServiceContext)
     */
    @Override
    public void start(ServiceContext context) throws ServiceException {
        CassandraloaderTreasury.init(context);
        CassandraloaderTrack.me.info("Cassandraloader-Service:Starts");
        try {
            CassandraloaderTreasury.open.takeFileAdaptorManager().start();
        } catch (CassandraloaderException e) {
            e.printStackTrace();
        }
    // System.out.println("TEst");
    }

    /**
     *  Platform call this method for just before  STOP triggered for Cassandraloader service  <br>
     *  You can use this method to release any resources claimed by this service.
     *  @see com.reds.platform.servicecommons.Service#close(com.reds.platform.servicecommons.context.CloseContext)
     */
    @Override
    public void close(CloseContext context) throws ServiceException {
        CassandraloaderTreasury.closeContext = context;
        CassandraloaderTrack.me.info("Cassandraloader-Service:Close");
    }

    /**
     *  Platform call this method for STOPPING Cassandraloader service  <br>
     *  You can use this method to stop any internal service components.
     *  @see com.reds.platform.servicecommons.Service#stop(com.reds.platform.servicecommons.context.ServiceContext)
     */
    @Override
    public void stop(ServiceContext context) throws ServiceException {
        CassandraloaderTreasury.serviceContext = context;
        CassandraloaderTrack.me.info("Cassandraloader-Service:Stop");
    }

    /**
     *  Platform call this method for immediately after when Cassandraloader service  UNDEPLOYED from platform <br>
     *  @see com.reds.platform.servicecommons.Service#unDeployed(com.reds.platform.servicecommons.context.DeploymentContext)
     */
    @Override
    public void unDeployed(DeploymentContext context) throws ServiceException {
        CassandraloaderTreasury.deploymentContext = context;
        CassandraloaderTrack.me.info("Cassandraloader-Service:UnDeployed");
    }

    /**
     *  To get basic information about Cassandraloader <br>
     */
    @Override
    public CassandraloaderInfo getInfo() {
        return CassandraloaderTreasury.open.takeCassandraloaderInfo();
    }
}
