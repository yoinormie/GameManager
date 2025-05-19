package com.yoi.GameManager.Model.Entity.Mongo.GameManager;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account_handler")
public class AccountHandlerM {

    @Id
    private String id; // Combina steamid y onlineId

    private String handlerName;

    // Referencias manuales (relaciones "lógicas")
    private String steamid;
    private String onlineId;

    public AccountHandlerM(String steamid, String onlineId, String handlerName) {
        this.steamid = steamid;
        this.onlineId = onlineId;
        this.handlerName = handlerName;
        this.id = steamid + "_" + onlineId; // ID compuesto simulado
    }

    // Getters y setters
}
