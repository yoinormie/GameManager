package com.yoi.GameManager.Repositories.JPA;

import com.yoi.GameManager.Model.Entity.JPA.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface GameRepositoryJPA extends JpaRepository<Game, UUID> {
    //@Query()
    //Optional<Game> findByTitle (String title);
}
