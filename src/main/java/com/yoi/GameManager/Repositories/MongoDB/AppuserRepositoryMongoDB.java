package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.MongoDB.AppuserMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;


public interface AppuserRepositoryMongoDB extends MongoRepository<AppuserMongoDB, String> {
    void deleteByUsername(String username);
    @Query("{'idUser' : ?0}")
    Optional<AppuserMongoDB> findByIdUser(String id_user);
}
