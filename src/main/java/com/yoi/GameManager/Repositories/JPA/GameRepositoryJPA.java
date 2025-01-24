package com.yoi.GameManager.Repositories.JPA;

import com.yoi.GameManager.Model.Entity.JPA.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepositoryJPA extends JpaRepository<Game, UUID> {

}
