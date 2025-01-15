package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnerRepositoryMongoDB extends MongoRepository<Owner, UUID> {
}
