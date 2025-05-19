package com.yoi.GameManager.Model.Entity.Mongo.Steam;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "game_property_steam")
public class GamePropertySteamM {

    @Id
    private String id; // ID compuesto manual

    private Integer appid;
    private String steamid;

    public GamePropertySteamM(Integer appid, String steamid) {
        this.appid = appid;
        this.steamid = steamid;
        this.id = appid + "_" + steamid;
    }

    // Getters y setters
}
