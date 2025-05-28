package com.yoi.GameManager.Model.DTO.EntityDTOs.Steam;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SteamAchievementDTO {
    private Integer appid;
    private String steamid;
    private String name;
    private Boolean achieved;
}
