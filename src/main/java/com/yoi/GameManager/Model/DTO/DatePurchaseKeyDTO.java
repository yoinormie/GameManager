package com.yoi.GameManager.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DatePurchaseKeyDTO {
    private UUID id_owner;
    private UUID id_game;
}
