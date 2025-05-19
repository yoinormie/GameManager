package com.yoi.GameManager.Model.Entity.JPA.GameManager;

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

}