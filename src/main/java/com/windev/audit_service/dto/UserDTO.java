package com.windev.audit_service.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String id;

    private String email;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String phoneNumber;
}
