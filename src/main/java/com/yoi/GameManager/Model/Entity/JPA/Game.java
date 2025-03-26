package com.yoi.GameManager.Model.Entity.JPA;

import com.yoi.GameManager.Model.DTO.RequestDTOs.GameRequest.RAWGDTOs.GameDTORequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "game")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_game;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "developer")
    private String developer;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "release_date")
    private Date release_date;

    @Column(name = "metacritic_score")
    private BigDecimal metacritic_score;

    @Column(name = "platforms")
    private String platforms;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ownership> ownershipList;

    public static Game newGame(GameDTORequest gameDTORequest){

        return null;
    }
}
