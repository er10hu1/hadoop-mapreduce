package org.apache.hadoop.mapreduce.v2;


import java.net.InetSocketAddress;

import junit.framework.Assert;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.Server;
import org.apache.hadoop.mapreduce.v2.api.MRClientProtocol;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.FailTaskAttemptRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.FailTaskAttemptResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetCountersRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetCountersResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetDiagnosticsRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetDiagnosticsResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetJobReportRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetJobReportResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetTaskAttemptCompletionEventsRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetTaskAttemptCompletionEventsResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetTaskAttemptReportRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetTaskAttemptReportResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetTaskReportRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetTaskReportResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetTaskReportsRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.GetTaskReportsResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.KillJobRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.KillJobResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.KillTaskAttemptRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.KillTaskAttemptResponse;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.KillTaskRequest;
import org.apache.hadoop.mapreduce.v2.api.protocolrecords.KillTaskResponse;
import org.apache.hadoop.net.NetUtils;
import org.apache.hadoop.yarn.YarnException;
import org.apache.hadoop.yarn.exceptions.YarnRemoteException;
import org.apache.hadoop.yarn.factories.impl.pb.RpcClientFactoryPBImpl;
import org.apache.hadoop.yarn.factories.impl.pb.RpcServerFactoryPBImpl;
import org.junit.Test;

public class TestRPCFactories {
  
  
  
  @Test
  public void test() {
    testPbServerFactory();
    
    testPbClientFactory();
  }
  
  
  
  private void testPbServerFactory() {
    InetSocketAddress addr = new InetSocketAddress(0);
    Configuration conf = new Configuration();
    MRClientProtocol instance = new MRClientProtocolTestImpl();
    Server server = null;
    try {
      server = RpcServerFactoryPBImpl.get().getServer(MRClientProtocol.class, instance, addr, conf, null);
      server.start();
    } catch (YarnException e) {
      e.printStackTrace();
      Assert.fail("Failed to crete server");
    } finally {
      server.stop();
    }
  }

  
  private void testPbClientFactory() {
    InetSocketAddress addr = new InetSocketAddress(0);
    System.err.println(addr.getHostName() + addr.getPort());
    Configuration conf = new Configuration();
    MRClientProtocol instance = new MRClientProtocolTestImpl();
    Server server = null;
    try {
      server = RpcServerFactoryPBImpl.get().getServer(MRClientProtocol.class, instance, addr, conf, null);
      server.start();
      System.err.println(server.getListenerAddress());
      System.err.println(NetUtils.getConnectAddress(server));

      MRClientProtocol client = null;
      try {
        client = (MRClientProtocol) RpcClientFactoryPBImpl.get().getClient(MRClientProtocol.class, 1, NetUtils.getConnectAddress(server), conf);
      } catch (YarnException e) {
        e.printStackTrace();
        Assert.fail("Failed to crete client");
      }
      
    } catch (YarnException e) {
      e.printStackTrace();
      Assert.fail("Failed to crete server");
    } finally {
      server.stop();
    }     
  }

  
  public class MRClientProtocolTestImpl implements MRClientProtocol {

    @Override
    public GetJobReportResponse getJobReport(GetJobReportRequest request)
        throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public GetTaskReportResponse getTaskReport(GetTaskReportRequest request)
        throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public GetTaskAttemptReportResponse getTaskAttemptReport(
        GetTaskAttemptReportRequest request) throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public GetCountersResponse getCounters(GetCountersRequest request)
        throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public GetTaskAttemptCompletionEventsResponse getTaskAttemptCompletionEvents(
        GetTaskAttemptCompletionEventsRequest request)
        throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public GetTaskReportsResponse getTaskReports(GetTaskReportsRequest request)
        throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public GetDiagnosticsResponse getDiagnostics(GetDiagnosticsRequest request)
        throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public KillJobResponse killJob(KillJobRequest request)
        throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public KillTaskResponse killTask(KillTaskRequest request)
        throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public KillTaskAttemptResponse killTaskAttempt(
        KillTaskAttemptRequest request) throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public FailTaskAttemptResponse failTaskAttempt(
        FailTaskAttemptRequest request) throws YarnRemoteException {
      // TODO Auto-generated method stub
      return null;
    }
    
  }
}