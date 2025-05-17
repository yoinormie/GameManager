package com.yoi.GameManager.Model.Entity.Steam;

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

    // getters y setters
}

class GamepropertyId implements Serializable {
    private Integer appid;
    private String steamid;

    public GamepropertyId() {}

    public GamepropertyId(Integer appid, String steamid) {
        this.appid = appid;
        this.steamid = steamid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GamepropertyId)) return false;
        GamepropertyId that = (GamepropertyId) o;
        return appid.equals(that.appid) && steamid.equals(that.steamid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appid, steamid);
    }
}
