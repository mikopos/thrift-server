package com.marios.gavriil.thriftserver;

import com.marios.gavriil.thriftserver.util.ThriftServer;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThriftServerApplication {

    public static void main(String[] args) throws TTransportException {

        ThriftServer server = new ThriftServer();

        server.start();
    }

}
