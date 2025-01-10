package com.yoi.GameManager.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnershipDTO {
    private UUID id_owner;
    private UUID id_game;
}
