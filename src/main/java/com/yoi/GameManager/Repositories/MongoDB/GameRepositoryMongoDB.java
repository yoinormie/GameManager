package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.JPA.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface GameRepositoryMongoDB extends MongoRepository<Game, UUID> {
}
