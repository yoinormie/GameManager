package com.yoi.GameManager.Model.Entity.PlayStation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_playstation_network")
public class UserPlaystationNetwork {

    @Id
    @Column(name = "online_id", length = 100)
    private String onlineId;

    @Column(name = "account_id", length = 100, nullable = false, unique = true)
    private String accountId;

    @Column(length = 2)
    private String country;

    @Column(length = 10)
    private String language;

    @Column(name = "is_ps_plus")
    private Boolean isPsPlus;

    // getters y setters
}
