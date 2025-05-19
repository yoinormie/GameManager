package com.yoi.GameManager.Repositories.JPA.Steam;

import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamGame;
import org.springframework.data.repository.Repository;

public interface SteamGameRepositoryJPA extends Repository<SteamGame, Integer> {
}
