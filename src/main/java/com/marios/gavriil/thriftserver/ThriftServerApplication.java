package com.marios.gavriil.thriftserver;

import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ThriftServerApplication {

    public static void main(String[] args) throws TTransportException {
        SpringApplication.run(ThriftServerApplication.class, args);
    }

}
