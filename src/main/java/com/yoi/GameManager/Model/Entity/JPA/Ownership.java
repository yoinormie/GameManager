package com.yoi.GameManager.Model.Entity.JPA;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ownership")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ownership {

    @EmbeddedId
    private OwnershipKey id;

    @ManyToOne
    @MapsId("idOwner")  // Mapea el id a la clave embebida
    @JoinColumn(name = "id_owner", nullable = false, foreignKey = @ForeignKey(name = "fk_owner"))
    private Owner owner;  // Relación con la entidad Owner

    @ManyToOne
    @MapsId("idGame")  // Mapea el id a la clave embebida
    @JoinColumn(name = "id_game", nullable = false, foreignKey = @ForeignKey(name = "fk_game"))
    private Game game;  // Relación con la entidad Game
}
