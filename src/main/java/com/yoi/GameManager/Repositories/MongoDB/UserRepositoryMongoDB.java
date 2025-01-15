package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepositoryMongoDB extends MongoRepository<User, UUID> {
}
