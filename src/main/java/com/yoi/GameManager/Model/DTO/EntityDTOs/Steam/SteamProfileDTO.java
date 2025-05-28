package com.yoi.GameManager.Model.DTO.EntityDTOs.Steam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class SteamProfileDTO {
    private String steamid;
    private String personaName;
    private String profileUrl;
    private String realName;
    private String locCountryCode;
}
