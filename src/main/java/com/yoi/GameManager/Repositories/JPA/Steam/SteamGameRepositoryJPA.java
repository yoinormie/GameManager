package com.yoi.GameManager.Repositories.JPA.Steam;

import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SteamGameRepositoryJPA extends JpaRepository<SteamGame, Integer> {
}
