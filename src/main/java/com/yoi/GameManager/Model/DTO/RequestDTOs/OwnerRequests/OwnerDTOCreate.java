package com.yoi.GameManager.Model.DTO.RequestDTOs.OwnerRequests;

import lombok.Getter;

import java.util.UUID;

@Getter
public class OwnerDTOCreate {
    private String name;
    private String firstSurname;
    private String secondSurname;
    private UUID userId;

}
