package com.yoi.GameManager.Model.Entity.JPA.PlayStation;
import com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation.PlayStationGameDTO;
import com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation.TrophyCounts;
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

    public GamePlaystation(PlayStationGameDTO dto) {
        this.npCommunicationId = dto.getNpCommunicationId();
        this.gameTitle = dto.getGameTitle();
        this.platform = dto.getPlatform();

        TrophyCounts trophies = dto.getTotalTrophies();
        if (trophies != null) {
            this.totalTrophiesGold = trophies.getGold();
            this.totalTrophiesSilver = trophies.getSilver();
            this.totalTrophiesBronze = trophies.getBronze();
            this.totalTrophiesTotal =
                    (trophies.getGold() != null ? trophies.getGold() : 0) +
                            (trophies.getSilver() != null ? trophies.getSilver() : 0) +
                            (trophies.getBronze() != null ? trophies.getBronze() : 0);
        } else {
            this.totalTrophiesGold = 0;
            this.totalTrophiesSilver = 0;
            this.totalTrophiesBronze = 0;
            this.totalTrophiesTotal = 0;
        }
    }
}
