package com.yoi.GameManager.Model.Entity.Mongo.GameManager;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Document(collection = "appuser")
public class AppuserM {

    @Id
    private UUID id_user;

    private String username;
    private String email;
    private String password;

    // getters y setters
}
