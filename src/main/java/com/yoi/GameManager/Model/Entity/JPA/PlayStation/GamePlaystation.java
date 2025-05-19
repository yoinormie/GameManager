package com.yoi.GameManager.Model.Entity.JPA.PlayStation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "game_playstation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GamePlaystation {

    @Id
    @Column(name = "np_communication_id", length = 100)
    private String npCommunicationId;

    @Column(name = "game_title", length = 255)
    private String gameTitle;

    @Column(name = "platform", length = 50)
    private String platform;

    @Column(name = "total_trophies_gold")
    private Integer totalTrophiesGold;

    @Column(name = "total_trophies_silver")
    private Integer totalTrophiesSilver;

    @Column(name = "total_trophies_bronze")
    private Integer totalTrophiesBronze;

    @Column(name = "total_trophies_total")
    private Integer totalTrophiesTotal;


}
