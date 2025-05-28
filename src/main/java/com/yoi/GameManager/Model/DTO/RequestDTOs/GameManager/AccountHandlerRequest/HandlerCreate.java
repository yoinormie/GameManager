package com.yoi.GameManager.Model.DTO.RequestDTOs.GameManager.AccountHandlerRequest;

import lombok.Getter;

import java.util.UUID;

@Getter
public class HandlerCreate {
    private String name;
    private String accountId;
    private String steamId;
    private UUID userId;
    private boolean isCustomSteam;
}
