package com.yoi.GameManager.Model.Entity.Mongo.PlayStation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_playstation_network")
public class UserPlaystationNetworkM {

    @Id
    private String onlineId;

    private String accountId;
    private String country;
    private String language;
    private Boolean isPsPlus;

    // getters y setters
}
