package com.yoi.GameManager.Model.Entity.MongoDB;

import com.yoi.GameManager.Model.Entity.JPA.Game;
import com.yoi.GameManager.Model.Entity.JPA.Ownership;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Games")
public class GameMongoDB {

    @Id
    private String id_game;

    @Field(name = "title")
    private String title;

    @Field(name = "developer")
    private String developer;

    @Field(name = "publisher")
    private String publisher;

    @Field(name = "release_date")
    private Date release_date;

    @Field(name = "metacritic_score")
    private BigDecimal metacritic_score;

    @Field(name = "platforms")
    private String platforms;

    @Field(name = "createDate")
    @CreatedDate
    private Instant createDate;

    @Field(name = "lastModification")
    @LastModifiedDate
    private Instant lastModification;

    public static GameMongoDB newGame(Game game){
        GameMongoDB gameMongoDB = new GameMongoDB();
        gameMongoDB.setId_game(game.getId_game().toString());
        gameMongoDB.setTitle(game.getTitle());
        gameMongoDB.setDeveloper(game.getDeveloper());
        gameMongoDB.setPublisher(game.getPublisher());
        gameMongoDB.setRelease_date(game.getRelease_date());
        gameMongoDB.setMetacritic_score(game.getMetacritic_score());
        gameMongoDB.setPlatforms(game.getPlatforms());
        gameMongoDB.setCreateDate(Instant.now());
        gameMongoDB.setLastModification(Instant.now());
        return gameMongoDB;
    }
}

