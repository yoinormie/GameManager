package com.yoi.GameManager.Model.Entity.JPA.GameManager;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AccountHandlerEmbeddable implements Serializable {

    @Column(name = "steamid", length = 20)
    private String steamid;

    @Column(name = "online_id", length = 100)
    private String onlineId;

    public AccountHandlerEmbeddable() {
    }

    public AccountHandlerEmbeddable(String steamid, String onlineId) {
        this.steamid = steamid;
        this.onlineId = onlineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountHandlerEmbeddable)) return false;
        AccountHandlerEmbeddable that = (AccountHandlerEmbeddable) o;
        return Objects.equals(steamid, that.steamid) && Objects.equals(onlineId, that.onlineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steamid, onlineId);
    }
}