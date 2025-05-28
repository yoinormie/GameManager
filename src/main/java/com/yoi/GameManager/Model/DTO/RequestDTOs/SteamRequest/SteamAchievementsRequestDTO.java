package com.yoi.GameManager.Model.DTO.RequestDTOs.SteamRequest;

import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamGame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class SteamAchievementsRequestDTO {

    private String steamID;
    private SteamGame[] ownedGames;
}
