package com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TrophyCounts {
    private Integer bronze;
    private Integer silver;
    private Integer gold;
    private Integer platinum;
}
