package com.yoi.GameManager.Repositories.JPA;

import com.yoi.GameManager.Model.Entity.JPA.GameScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameScoreRepositoryJPA extends JpaRepository<GameScore, UUID> {
}
