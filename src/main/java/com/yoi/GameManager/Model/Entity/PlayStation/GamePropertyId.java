package com.yoi.GameManager.Model.Entity.PlayStation;

import java.io.Serializable;
import java.util.Objects;

public class GamePropertyId implements Serializable {
    private String accountId;
    private String npCommunicationId;

    public GamePropertyId() {}

    public GamePropertyId(String accountId, String npCommunicationId) {
        this.accountId = accountId;
        this.npCommunicationId = npCommunicationId;
    }

    // equals y hashCode basados en ambos campos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GamePropertyId)) return false;
        GamePropertyId that = (GamePropertyId) o;
        return accountId.equals(that.accountId) && npCommunicationId.equals(that.npCommunicationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, npCommunicationId);
    }
}
