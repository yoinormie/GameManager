package com.yoi.GameManager.Model.Entity.MongoDB;

import com.yoi.GameManager.Model.Entity.JPA.Appuser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
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
    @Field(name = "idUser")
    private String idUser;

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

    public static AppuserMongoDB newUser(Appuser user){
        AppuserMongoDB userMongo = new AppuserMongoDB();
        userMongo.setIdUser(user.getId_user().toString());
        userMongo.setUsername(user.getUsername()); ;
        userMongo.setEmail(user.getEmail());
        userMongo.setPassword(user.getPassword());
        userMongo.setCreateDate(Instant.now());
        userMongo.setLastModification(Instant.now());
        return userMongo;
    }

//    public static AppuserMongoDB updateUser(Appuser user, AppuserMongoDB existingUserMDB){
//        AppuserMongoDB appuserMongoDB = new AppuserMongoDB();
//        appuserMongoDB.setIdUser(user.getId_user().toString());
//        appuserMongoDB.setUsername(user.getUsername());
//        appuserMongoDB.setEmail(user.getEmail());
//        appuserMongoDB.setPassword(user.getPassword());
//        appuserMongoDB.setLastModification(Instant.now());
//
//        if(existingUserMDB.getCreateDate() != null){
//            appuserMongoDB.setCreateDate(existingUserMDB.getCreateDate());
//        }
//        return appuserMongoDB;
//    }
}
