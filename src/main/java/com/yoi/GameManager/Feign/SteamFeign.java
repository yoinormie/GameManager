package com.yoi.GameManager.Feign;

import com.yoi.GameManager.Model.DTO.RequestDTOs.SteamRequest.SteamAchievementsRequestDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.SteamRequest.SteamGamesRequestDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.SteamRequest.SteamUserRequestDTO;
import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamAchievement;
import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamGame;
import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "SteamFeign", url = "http://localhost:3000/steam")
public interface SteamFeign {
    @PostMapping("/getsteamiduser")
    SteamProfile getUser(@RequestBody SteamUserRequestDTO steamUserRequestDTO);

    @PostMapping("/getuserslibrary")
    SteamGame[] getUserGames(@RequestBody SteamGamesRequestDTO requestDTO);

    @PostMapping("/makeachievementslist")
    SteamAchievement[] getAchievementsList(@RequestBody SteamAchievementsRequestDTO achievementsRequestDTO);
}
