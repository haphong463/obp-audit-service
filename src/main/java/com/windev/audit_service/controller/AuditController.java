package com.windev.audit_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.windev.audit_service.model.AuditLog;
import com.windev.audit_service.repository.AuditLogRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {
    @Autowired
    private AuditLogRepository auditLogRepository;

    @GetMapping("/logs")
    public List<AuditLog> getAllLogs() {
        return auditLogRepository.findAll();
    }

    @GetMapping("/logs/user/{userId}")
    public List<AuditLog> getLogsByUser(@PathVariable String userId) {
        return auditLogRepository.findByUserId(userId);
    }

    @GetMapping("/logs/action/{action}")
    public List<AuditLog> getLogsByAction(@PathVariable String action) {
        return auditLogRepository.findByAction(action);
    }
}
