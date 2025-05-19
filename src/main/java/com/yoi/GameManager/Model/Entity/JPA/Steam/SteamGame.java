package com.yoi.GameManager.Model.Entity.JPA.Steam;

import jakarta.persistence.*;

@Entity
@Table(name = "steamgame")
public class SteamGame {

    @Id
    @Column(name = "appid")
    private Integer appid;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "playtimeforever")
    private Double playtimeForever;
}
