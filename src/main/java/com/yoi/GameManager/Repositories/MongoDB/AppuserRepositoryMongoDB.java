package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.MongoDB.AppuserMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AppuserRepositoryMongoDB extends MongoRepository<AppuserMongoDB, String> {
}
