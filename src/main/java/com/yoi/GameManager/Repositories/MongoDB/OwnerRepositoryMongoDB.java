package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.JPA.Owner;
import com.yoi.GameManager.Model.Entity.MongoDB.OwnerMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnerRepositoryMongoDB extends MongoRepository<OwnerMongoDB, String> {
}
