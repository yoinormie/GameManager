package com.yoi.GameManager.Model.Entity.MongoDB;

import com.yoi.GameManager.Model.Entity.JPA.Appuser;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Appuser")
public class AppuserMongoDB {
    @Id
    @Field(name = "id_user")
    private String id_user;

    @Field(name = "username")
    private String username;

    @Field(name = "email")
    private String email;

    @Field(name = "password")
    private String password;

    @Field(name = "createDate")
    @CreatedDate
    private Instant createDate;

    @Field(name = "lastModification")
    @LastModifiedDate
    private Instant lastModification;

    public AppuserMongoDB(Appuser user){
        id_user = user.getId_user().toString();
        username = user.getUsername();
        email = user.getEmail();
        password = user.getPassword();
        createDate = Instant.now();
        lastModification = Instant.now();
    }
}
