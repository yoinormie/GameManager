package com.yoi.GameManager.Model.Entity.Mongo.Steam;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "steam_achievements")
public class SteamAchievementM {

    @Id
    private String id; // ID compuesto generado manualmente

    private Integer appid;
    private String steamid;
    private String name;
    private Boolean achieved;

    public SteamAchievementM(Integer appid, String steamid, String name, Boolean achieved) {
        this.appid = appid;
        this.steamid = steamid;
        this.name = name;
        this.achieved = achieved;
        this.id = appid + "_" + steamid + "_" + name; // simulación de clave compuesta
    }

    // Getters y setters
}
