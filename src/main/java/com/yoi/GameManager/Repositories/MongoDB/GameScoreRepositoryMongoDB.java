package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.GameScore;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface GameScoreRepositoryMongoDB extends MongoRepository<GameScore, UUID> {
}
