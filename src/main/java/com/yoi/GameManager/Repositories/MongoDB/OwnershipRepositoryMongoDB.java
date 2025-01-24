package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.JPA.Ownership;
import com.yoi.GameManager.Model.Entity.JPA.OwnershipKey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OwnershipRepositoryMongoDB extends MongoRepository<Ownership,OwnershipKey> {
}
