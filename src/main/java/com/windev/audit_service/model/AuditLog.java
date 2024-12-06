package com.windev.audit_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "audit_logs")
@AllArgsConstructor
@NoArgsConstructor
public class AuditLog {
    @Id
    private String id;
    private String userId;
    private String action;
    private String details;
    private Date timestamp;
    private String sourceService; // Microservice gửi log
}
