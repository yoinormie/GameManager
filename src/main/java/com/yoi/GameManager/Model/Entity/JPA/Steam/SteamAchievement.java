package com.yoi.GameManager.Model.Entity.JPA.Steam;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "steamachievement")
@IdClass(SteamAchievementId.class)
public class SteamAchievement {

    @Id
    @Column(name = "appid", nullable = false)
    private Integer appid;

    @Id
    @Column(name = "steamid", length = 20, nullable = false)
    private String steamid;

    @Id
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "achieved")
    private Boolean achieved;

}


