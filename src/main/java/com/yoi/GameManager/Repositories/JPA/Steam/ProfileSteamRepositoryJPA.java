package com.yoi.GameManager.Repositories.JPA.Steam;

import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamProfile;
import org.springframework.data.repository.Repository;

public interface ProfileSteamRepositoryJPA extends Repository<SteamProfile, String> {
}
