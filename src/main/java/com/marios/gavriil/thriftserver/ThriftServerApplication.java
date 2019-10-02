package com.marios.gavriil.thriftserver;

import com.marios.gavriil.thriftserver.util.ThriftServer;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ThriftServerApplication {

    public static void main(String[] args) throws TTransportException {
        SpringApplication.run(ThriftServerApplication.class, args);
    }

}
