package com.yoi.GameManager.Model.DTO.RequestDTOs.AppuserRequests;

import lombok.Data;

@Data
public class DeleteUserDTO {
    private String username;
    private String password;
}
