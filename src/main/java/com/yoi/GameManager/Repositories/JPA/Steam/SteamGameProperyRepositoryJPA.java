package com.yoi.GameManager.Repositories.JPA.Steam;

import com.yoi.GameManager.Model.Entity.JPA.Steam.GamePropertySteam;
import com.yoi.GameManager.Model.Entity.JPA.Steam.GamepropertyId;
import org.springframework.data.repository.Repository;

public interface SteamGameProperyRepositoryJPA extends Repository<GamePropertySteam, GamepropertyId> {
}
