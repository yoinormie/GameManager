package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.Game.GameNotFound;
import com.yoi.GameManager.Exceptions.Game.InvalidGame;
import com.yoi.GameManager.Model.DTO.EntityDTOs.GameDTO;
import com.yoi.GameManager.Model.Entity.JPA.Game;
import com.yoi.GameManager.Repositories.JPA.GameRepositoryJPA;
import com.yoi.GameManager.Repositories.MongoDB.GameRepositoryMongoDB;
import org.springframework.http.ResponseEntity;

public class GameService {

    private final GameRepositoryJPA gameRepositoryJPA;
    private final GameRepositoryMongoDB gameRepositoryMongoDB;

    public GameService(GameRepositoryJPA gameRepositoryJPA, GameRepositoryMongoDB gameRepositoryMongoDB) {
        this.gameRepositoryJPA = gameRepositoryJPA;
        this.gameRepositoryMongoDB = gameRepositoryMongoDB;
    }

    public ResponseEntity<GameDTO> createGame (Game game){
        if(!game.getTitle().isBlank() && !game.getDeveloper().isBlank() && !game.getPublisher().isBlank()){
            gameRepositoryJPA.save(game);
            gameRepositoryMongoDB.save(game);
        }
        throw new InvalidGame();
    }

    public ResponseEntity<GameDTO> modifyTitleGame(String name, String newName){
        if(comprobarValoresParaNombreNuevo(name, newName)){

        }
        throw new GameNotFound();
    }

    private static boolean comprobarValoresParaNombreNuevo(String name, String newName) {
        return !name.isBlank() && !newName.isBlank();
    }

    public ResponseEntity<GameDTO> buscarJuego(String titulo){
        if(!titulo.isEmpty()){
            RAWGAPIRequests rawgapiRequests = new RAWGAPIRequests();
            Game requestedGame = rawgapiRequests.envioReciboDatos(titulo);
        }
        throw new GameNotFound();
    }
}


