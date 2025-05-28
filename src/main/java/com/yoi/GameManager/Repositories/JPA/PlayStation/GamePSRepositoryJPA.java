package com.yoi.GameManager.Repositories.JPA.PlayStation;

import com.yoi.GameManager.Model.Entity.JPA.PlayStation.GamePlaystation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamePSRepositoryJPA extends JpaRepository<GamePlaystation,String> {
}
