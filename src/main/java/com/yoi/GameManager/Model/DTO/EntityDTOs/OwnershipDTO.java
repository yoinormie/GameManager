package com.yoi.GameManager.Model.DTO.EntityDTOs;

import com.yoi.GameManager.Model.Entity.JPA.Game;
import com.yoi.GameManager.Model.Entity.JPA.Owner;
import com.yoi.GameManager.Model.Entity.JPA.OwnershipKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnershipDTO {
    private OwnershipKey id;
    private Owner owner;
    private Game game;
}
