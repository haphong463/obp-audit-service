package com.windev.audit_service.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class AccountDTO {
    private String id;

    private String accountNumber;

    private BigDecimal balance;

    private String accountType; // EX: SAVINGS, CHECKING

    private Date createdAt;

    private Date updatedAt;

    private UserDTO user;
}
