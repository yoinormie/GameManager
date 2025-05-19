package com.yoi.GameManager.Model.Entity.Mongo.PlayStation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "game_property_playstation")
public class GamePropertyPlayStationM {

    @Id
    private String id; // opcional: usar UUID.randomUUID().toString()

    private String accountId;
    private String npCommunicationId;

    private Integer trophyGold;
    private Integer trophySilver;
    private Integer trophyBronze;
    private Integer trophyTotal;

    private BigDecimal percentageProgress;
    private LocalDateTime lastUpdateTime;


}
