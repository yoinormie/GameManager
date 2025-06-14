package com.yoi.GameManager.Model.Entity.JPA.Steam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "steamprofile")
@Data
@ToString
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
