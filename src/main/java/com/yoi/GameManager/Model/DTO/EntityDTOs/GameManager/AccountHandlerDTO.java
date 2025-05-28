package com.yoi.GameManager.Model.DTO.EntityDTOs.GameManager;

import com.yoi.GameManager.Model.Entity.JPA.GameManager.AccountHandler;
import com.yoi.GameManager.Model.Entity.JPA.GameManager.Appuser;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccountHandlerDTO {
    private String steamId;
    private String accountId;
    private Appuser user;
    private String name;

    public AccountHandlerDTO(AccountHandler handler) {
        this.steamId = handler.getId().getSteamid();
        this.accountId = handler.getId().getOnlineId();
        this.user = handler.getId_user();
        this.name = handler.getHandlerName();
    }
}
