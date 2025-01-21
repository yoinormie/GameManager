package com.yoi.GameManager.Model.DTO.EntityDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OwnershipKeyDTO {
    private UUID id_owner;
    private UUID id_game;
}
