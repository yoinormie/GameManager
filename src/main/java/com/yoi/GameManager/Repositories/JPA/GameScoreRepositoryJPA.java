package com.yoi.GameManager.Repositories.JPA;

import com.yoi.GameManager.Model.Entity.GameScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameScoreRepositoryJPA extends JpaRepository<GameScore, UUID> {
}
