package com.yoi.GameManager.Model.Entity.JPA.Steam;

import java.io.Serializable;
import java.util.Objects;

public class GamepropertyId implements Serializable {
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
        if (!(o instanceof GamepropertyId that)) return false;
        return appid.equals(that.appid) && steamid.equals(that.steamid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appid, steamid);
    }
}
