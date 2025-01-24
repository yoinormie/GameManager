package com.yoi.GameManager.Model.Entity.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnershipKey implements Serializable {

    @Column(name = "id_owner", nullable = false)
    private UUID idOwner;

    @Column(name = "id_game", nullable = false)
    private UUID idGame;
}