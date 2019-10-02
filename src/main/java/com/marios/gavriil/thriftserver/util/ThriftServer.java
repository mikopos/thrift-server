package com.marios.gavriil.thriftserver.util;

import com.marios.gavriil.thriftserver.conf.KafkaSender;
import com.marios.gavriil.thriftserver.services.LogsService;
import com.marios.gavriil.thriftserver.services.impl.LogsServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ThriftServer {

     private Logger logger = LoggerFactory.getLogger(ThriftServer.class);

     private TServer server;

     @Bean
    public void start() throws TTransportException {

        TServerTransport serverTransport = new TServerSocket(8081);

        server = new TSimpleServer(new TServer.Args(serverTransport).
                processor(new LogsService.Processor<>(new LogsServiceImpl())));

        logger.info("Thrift server is starting ...");

        server.serve();

    }

    public void stop() {
        if(server != null && server.isServing()){
            logger.info("Thrift server is stopping ...");

            server.stop();

            logger.info("Thrift server has stopped.");
        }
    }
}
