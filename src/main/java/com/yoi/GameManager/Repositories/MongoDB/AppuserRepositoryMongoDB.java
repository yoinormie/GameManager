package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.Appuser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AppuserRepositoryMongoDB extends MongoRepository<Appuser, UUID> {
}
