package com.marios.gavriil.thriftserver.services.impl;

import com.marios.gavriil.thriftserver.entities.LogsDTO;
import com.marios.gavriil.thriftserver.services.LogsService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

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
        logger.info(logsDTO.toString());
        kafkaTemplate.send(topicName,logsDTO);
    }



}
