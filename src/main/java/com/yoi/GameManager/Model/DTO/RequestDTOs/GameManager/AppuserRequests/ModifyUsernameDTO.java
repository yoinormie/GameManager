package com.yoi.GameManager.Model.DTO.RequestDTOs.GameManager.AppuserRequests;

import lombok.Data;

@Data
public class ModifyUsernameDTO {
    private String username;
    private String password;
    private String newUsername;
}
