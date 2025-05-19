package com.yoi.GameManager.Model.Entity.Mongo.Steam;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "steamprofile")
public class SteamProfileM {

    @Id
    private String steamid;

    private String personaName;
    private String profileUrl;
    private String realName;
    private String locCountryCode;

    // getters y setters
}
