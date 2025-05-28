package com.yoi.GameManager.Model.DTO.RequestDTOs.SteamRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SteamUserRequestDTO {
    @JsonProperty("steamID")
    private String steamID;
    @JsonProperty("isCustom")
    private boolean isCustom;
}
