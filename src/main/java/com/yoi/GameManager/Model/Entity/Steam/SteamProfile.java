package com.yoi.GameManager.Model.Entity.Steam;

import jakarta.persistence.*;

@Entity
@Table(name = "steamprofile")
public class SteamProfile {

    @Id
    @Column(name = "steamid", length = 20)
    private String steamid;

    @Column(name = "personaname", length = 100)
    private String personaName;

    @Column(name = "profileurl", length = 255)
    private String profileUrl;

    @Column(name = "realname", length = 100)
    private String realName;

    @Column(name = "loccountrycode", length = 2)
    private String locCountryCode;
}
