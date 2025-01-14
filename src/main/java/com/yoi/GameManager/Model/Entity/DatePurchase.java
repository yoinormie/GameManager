package com.yoi.GameManager.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.UUID;


@Entity
@Table(name = "datepurchase")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatePurchase {

    @EmbeddedId
    private DatePurchaseKey id;

    @ManyToOne
    @JoinColumn(name = "owner", foreignKey = @ForeignKey(name = "id_owner"), insertable = false,updatable = false)
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "id_game", foreignKey = @ForeignKey(name = "id_game"), insertable = false,updatable = false)
    private Game game;

    @Column(name = "date_purchase", nullable = false)
    private Date datePurchase;

}
