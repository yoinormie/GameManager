package com.yoi.GameManager.Model.DTO.RequestDTOs.GameManager.AppuserRequests;

import lombok.Data;

@Data
public class ModifyUserPasswordDTO {
    private String username;
    private String password;
    private String newPassword;

}
