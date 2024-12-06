package com.windev.audit_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.windev.audit_service.dto.UserDTO;
import com.windev.audit_service.event.CreateTransactionEvent;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.windev.audit_service.model.AuditLog;
import com.windev.audit_service.repository.AuditLogRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuditService {
    @Autowired
    private AuditLogRepository auditLogRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = {"createTransaction"}, groupId = "audit-service")
    public void handleEvent(@Payload String message) {
        try {
            CreateTransactionEvent data = objectMapper.readValue(message, CreateTransactionEvent.class);

            AuditLog auditLog = new AuditLog();

            auditLog.setAction("POST");
            auditLog.setUserId(data.getAccount().getUser().getId());
            auditLog.setSourceService("TRANSACTION-SERVICE");
            auditLog.setDetails(message);
            auditLog.setTimestamp(new Date());

            auditLogRepository.save(auditLog);
            log.info("Decode data: {}", data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        log.info("Received event: {}", message);
    }

    @KafkaListener(topics = {"user-activity"}, groupId = "audit-service")
    public void handleUserEvent(@Payload String message) {
        try {
            UserDTO data = objectMapper.readValue(message, UserDTO.class);

            AuditLog auditLog = new AuditLog();

            auditLog.setAction("POST");
            auditLog.setUserId(data.getId());
            auditLog.setSourceService("IDENTITY-SERVICE");
            auditLog.setDetails(message);
            auditLog.setTimestamp(new Date());

            auditLogRepository.save(auditLog);
            log.info("Decode data: {}", data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        log.info("Received event: {}", message);
    }


    private AuditLog parseMessage(String message) {

        // Parse JSON to AuditLog object (using ObjectMapper or manual parsing)
        // Example:
        // AuditLog log = new AuditLog();
        // log.setAction("parsed-action"); // Replace with actual parsing logic
        // log.setTimestamp(new Date());
        return null;
    }
}
