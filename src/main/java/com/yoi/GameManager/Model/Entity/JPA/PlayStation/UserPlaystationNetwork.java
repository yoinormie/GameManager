package com.yoi.GameManager.Model.Entity.JPA.PlayStation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "user_playstation_network")
@Data
@ToString
public class UserPlaystationNetwork {

    @Id
    @Column(name = "online_id", length = 100)
    @JsonProperty("onlineID")
    private String onlineId;

    @Column(name = "account_id", length = 100, nullable = false, unique = true)
    @JsonProperty("accountID")
    private String accountId;

    @Column(length = 2)
    private String country;

    @Column(length = 10)
    private String language;

    @JsonProperty("isPSPlus")
    @Column(name = "is_ps_plus")
    private Boolean isPsPlus;
}
