package com.yoi.GameManager.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatePurchaseDTO {
    private UUID id_owner;
    private UUID id_game;
    private Date datePurchase;
}
