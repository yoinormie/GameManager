package com.yoi.GameManager.Model.DTO.EntityDTOs;

import com.yoi.GameManager.Model.Entity.Ownership;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameDTO {
        private UUID id_game;
        private String title;
        private String developer;
        private String publisher;
        private Date release_date;
        private BigDecimal metacritic_score;
        private List<Ownership> ownershipList;
}

