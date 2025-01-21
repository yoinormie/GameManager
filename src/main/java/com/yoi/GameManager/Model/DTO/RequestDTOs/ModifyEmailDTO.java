package com.yoi.GameManager.Model.DTO.RequestDTOs;

import lombok.Data;

@Data
public class ModifyEmailDTO {
    private String username;
    private String email;
    private String password;
    private String newEmail;
}
