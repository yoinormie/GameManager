package com.yoi.GameManager.Feign;

import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamAchievement;
import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamGame;
import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "SteamFeign", url = "http://localhost:3000/steam")
public interface SteamFeign {
    @PostMapping("/getsteamiduser")
    SteamProfile getUser(String steamID, boolean isCustom);

    @PostMapping("/getuserslibrary")
    SteamGame[] getUserGames(String steamID);

    @PostMapping("/makeachievementslist")
    SteamAchievement[] getAchievementsList(String steamID, SteamGame[] ownedGames);
}
