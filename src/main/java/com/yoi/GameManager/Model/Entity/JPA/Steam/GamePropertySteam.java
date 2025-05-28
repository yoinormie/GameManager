package com.yoi.GameManager.Model.Entity.JPA.Steam;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "gameproperty")
@IdClass(GamepropertyId.class)
public class GamePropertySteam {

    @Id
    @Column(name = "appid", nullable = false)
    private Integer appid;

    @Id
    @Column(name = "steamid", length = 20, nullable = false)
    private String steamid;

}

