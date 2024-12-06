package com.windev.audit_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.windev.audit_service.model.AuditLog;

import java.util.List;

public interface AuditLogRepository extends MongoRepository<AuditLog, String> {
    List<AuditLog> findByUserId(String userId);

    List<AuditLog> findByAction(String action);
}
