package com.yoi.GameManager.Repositories.JPA.Steam;

import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileSteamRepositoryJPA extends JpaRepository<SteamProfile, String> {
}
