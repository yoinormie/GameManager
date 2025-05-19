package com.yoi.GameManager.Model.Entity.Mongo.Steam;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "steamgame")
public class SteamGameM {

    @Id
    private Integer appid;

    private String name;
    private Double playtimeForever;

    // getters y setters
}
