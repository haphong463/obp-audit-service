package com.windev.audit_service.event;

import com.windev.audit_service.dto.AccountDTO;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionEvent {
    private AccountDTO account;
    private BigDecimal amount;
    private String type;
}
