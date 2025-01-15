package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface GameRepositoryMongoDB extends MongoRepository<Game, UUID> {
}
