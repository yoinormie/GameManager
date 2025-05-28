package com.yoi.GameManager.Model.DTO.EntityDTOs.Steam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class SteamGameDTO {
    private Integer appid;
    private String name;
    private Double playtimeForever;
}
