package com.yoi.GameManager.Model.DTO.RequestDTOs.GameManager.AppuserRequests;

import lombok.Data;

@Data
public class ModifyUserEmailDTO {
    private String username;
    private String email;
    private String password;
    private String newEmail;
}
