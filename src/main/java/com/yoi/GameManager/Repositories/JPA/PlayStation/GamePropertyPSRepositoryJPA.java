package com.yoi.GameManager.Repositories.JPA.PlayStation;

import com.yoi.GameManager.Model.Entity.JPA.PlayStation.GamePropertyId;
import com.yoi.GameManager.Model.Entity.JPA.PlayStation.GamePropertyPlayStation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GamePropertyPSRepositoryJPA extends JpaRepository<GamePropertyPlayStation, GamePropertyId> {
}
