package com.yoi.GameManager.Repositories.JPA.Steam;

import com.yoi.GameManager.Model.Entity.JPA.Steam.GamePropertySteam;
import com.yoi.GameManager.Model.Entity.JPA.Steam.GamepropertyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SteamGameProperyRepositoryJPA extends JpaRepository<GamePropertySteam, GamepropertyId> {
}
