package com.yoi.GameManager.Model.DTO;

import com.yoi.GameManager.Model.Entity.Game;
import com.yoi.GameManager.Model.Entity.Owner;
import com.yoi.GameManager.Model.Entity.OwnershipKey;
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
