package com.yoi.GameManager.Repositories.JPA.Steam;

import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamAchievement;
import com.yoi.GameManager.Model.Entity.JPA.Steam.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SteamAchievementRepositoryJPA extends JpaRepository<SteamAchievement,SteamAchievementId> {
}
