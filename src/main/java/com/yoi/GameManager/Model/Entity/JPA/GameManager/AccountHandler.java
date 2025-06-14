package com.yoi.GameManager.Model.Entity.JPA.GameManager;

import com.yoi.GameManager.Model.DTO.RequestDTOs.GameManager.AccountHandlerRequest.HandlerCreate;
import com.yoi.GameManager.Model.Entity.JPA.PlayStation.UserPlaystationNetwork;
import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamProfile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "account_handler")
public class AccountHandler {

    @EmbeddedId
    private AccountHandlerEmbeddable id;

    @ManyToOne
    @MapsId("steamid")
    @JoinColumn(name = "steamid")
    private SteamProfile steamProfile;

    @ManyToOne
    @MapsId("onlineId")
    @JoinColumn(name = "online_id")
    private UserPlaystationNetwork playstationNetwork;

    @Column(name = "handler_name", nullable = false, length = 100)
    private String handlerName;

    @JoinColumn(name = "id_user", unique = true, nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Appuser id_user;

    public static AccountHandler createAH(HandlerCreate handler, Appuser appuser) {
        AccountHandler accountHandler = new AccountHandler();
        accountHandler.setHandlerName(handler.getName());
        accountHandler.setId(new AccountHandlerEmbeddable(handler.getSteamId(), handler.getAccountId()));
        accountHandler.setId_user(appuser);
        return accountHandler;
    }
}