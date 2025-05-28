package com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserPlayStationNetworkDTO {
    private String onlineId;
    private String accountId;
    private String country;
    private String language;
    private Boolean isPsPlus;

}
