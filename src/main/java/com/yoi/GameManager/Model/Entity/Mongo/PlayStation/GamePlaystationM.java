package com.yoi.GameManager.Model.Entity.Mongo.PlayStation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "game_playstation")
public class GamePlaystationM {

    @Id
    private String npCommunicationId;

    private String gameTitle;
    private String platform;
    private Integer totalTrophiesGold;
    private Integer totalTrophiesSilver;
    private Integer totalTrophiesBronze;
    private Integer totalTrophiesTotal;

    // getters y setters
}