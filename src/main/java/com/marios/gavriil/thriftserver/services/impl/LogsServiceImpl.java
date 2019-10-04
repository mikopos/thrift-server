package com.marios.gavriil.thriftserver.services.impl;

import com.marios.gavriil.thriftserver.entities.LogsDTO;
import com.marios.gavriil.thriftserver.services.LogsService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;

@Service
public class LogsServiceImpl implements LogsService.Iface {

    private Logger logger = LoggerFactory.getLogger(LogsServiceImpl.class);

    @Value("${message.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, LogsDTO> kafkaTemplate;

    public LogsServiceImpl(KafkaTemplate<String, LogsDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public List<LogsDTO> getLogByDateTime(String datetime) throws TException {
        return null;
    }

    @Override
    public List<LogsDTO> getLogByLevel(String level) throws TException {
        return null;
    }

    @Override
    public void sendLog(LogsDTO logsDTO) throws TException {
        ListenableFuture<SendResult<String, LogsDTO>> future = kafkaTemplate.send(topicName,logsDTO);

        future.addCallback(new ListenableFutureCallback<SendResult<String, LogsDTO>>() {

            @Override
            public void onSuccess(SendResult<String, LogsDTO> result) {
                logger.info("Message = ["+logsDTO.toString()+"] was send successfully to Apache Kafka.");
            }
            @Override
            public void onFailure(Throwable ex) {
                logger.error("Message = ["+logsDTO.toString()+"] failed to be sent to Apache Kafka.");
            }
        });
    }



}
