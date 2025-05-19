package com.yoi.GameManager.Model.Entity.JPA.Steam;

import java.io.Serializable;
import java.util.Objects;

public class SteamAchievementId implements Serializable {
    private Integer appid;
    private String steamid;
    private String name;

    public SteamAchievementId() {}

    public SteamAchievementId(Integer appid, String steamid, String name) {
        this.appid = appid;
        this.steamid = steamid;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SteamAchievementId that)) return false;
        return appid.equals(that.appid) && steamid.equals(that.steamid) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appid, steamid, name);
    }
}
