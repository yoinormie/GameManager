package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.Appuser.UserNotValid;
import com.yoi.GameManager.Feign.PSFeign;
import com.yoi.GameManager.Feign.SteamFeign;
import com.yoi.GameManager.Model.DTO.EntityDTOs.GameManager.AccountHandlerDTO;
import com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation.EnvolvedLists;
import com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation.PlayStationGameDTO;
import com.yoi.GameManager.Model.DTO.EntityDTOs.PlayStation.PlayStationPropertyDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.GameManager.AccountHandlerRequest.HandlerCreate;
import com.yoi.GameManager.Model.DTO.RequestDTOs.GameManager.AccountHandlerRequest.LoginRequest;
import com.yoi.GameManager.Model.DTO.RequestDTOs.PlayStationRequest.PSGamesRequestDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.PlayStationRequest.PSUserRequestDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.SteamRequest.SteamGamesRequestDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.SteamRequest.SteamUserRequestDTO;
import com.yoi.GameManager.Model.Entity.JPA.GameManager.AccountHandler;
import com.yoi.GameManager.Model.Entity.JPA.GameManager.Appuser;
import com.yoi.GameManager.Model.Entity.JPA.PlayStation.GamePlaystation;
import com.yoi.GameManager.Model.Entity.JPA.PlayStation.GamePropertyPlayStation;
import com.yoi.GameManager.Model.Entity.JPA.PlayStation.UserPlaystationNetwork;
import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamGame;
import com.yoi.GameManager.Model.Entity.JPA.Steam.SteamProfile;
import com.yoi.GameManager.Repositories.JPA.GameManager.AccountHandlerRepositoryJPA;
import com.yoi.GameManager.Repositories.JPA.GameManager.AppuserRepositoryJPA;
import com.yoi.GameManager.Repositories.JPA.PlayStation.GamePSRepositoryJPA;
import com.yoi.GameManager.Repositories.JPA.PlayStation.GamePropertyPSRepositoryJPA;
import com.yoi.GameManager.Repositories.JPA.PlayStation.UserPSNRepositoryJPA;
import com.yoi.GameManager.Repositories.JPA.Steam.ProfileSteamRepositoryJPA;
import com.yoi.GameManager.Repositories.JPA.Steam.SteamGameRepositoryJPA;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class AccountHandlerService {
    private final AppuserRepositoryJPA appuserRepositoryJPA;
    private final AccountHandlerRepositoryJPA accountHandlerRepositoryJPA;
    private final UserPSNRepositoryJPA userPSNRepositoryJPA;
    private final ProfileSteamRepositoryJPA profileSteamRepositoryJPA;
    private final GamePSRepositoryJPA gamePSRepositoryJPA;
    private final SteamGameRepositoryJPA steamGameRepositoryJPA;
    private final GamePropertyPSRepositoryJPA gamePropertyPSRepositoryJPA;
    private final PSFeign psFeign;
    private final SteamFeign steamFeign;

    public AccountHandlerService(AppuserRepositoryJPA appuserRepositoryJPA, AccountHandlerRepositoryJPA accountHandlerRepositoryJPA, UserPSNRepositoryJPA userPSNRepositoryJPA, ProfileSteamRepositoryJPA profileSteamRepositoryJPA, GamePSRepositoryJPA gamePSRepositoryJPA, SteamGameRepositoryJPA steamGameRepositoryJPA, GamePropertyPSRepositoryJPA gamePropertyPSRepositoryJPA, PSFeign psFeign, SteamFeign steamFeign) {
        this.appuserRepositoryJPA = appuserRepositoryJPA;
        this.accountHandlerRepositoryJPA = accountHandlerRepositoryJPA;
        this.userPSNRepositoryJPA = userPSNRepositoryJPA;
        this.profileSteamRepositoryJPA = profileSteamRepositoryJPA;
        this.gamePSRepositoryJPA = gamePSRepositoryJPA;
        this.steamGameRepositoryJPA = steamGameRepositoryJPA;
        this.gamePropertyPSRepositoryJPA = gamePropertyPSRepositoryJPA;
        this.psFeign = psFeign;
        this.steamFeign = steamFeign;
    }

    @Operation(summary = "Crea un usuario en las BB.DD.")

    public ResponseEntity<AccountHandlerDTO> createHandler(HandlerCreate handlerCreate) {
        if (comprobacionMinimaParaCrearUsuario(handlerCreate)) {
            Appuser appuser = appuserRepositoryJPA.findById(handlerCreate.getUserId()).get();
            UserPlaystationNetwork UserPSN = psFeign.getUser(new PSUserRequestDTO(handlerCreate.getAccountId()));
            System.out.println(UserPSN);
            SteamProfile UserSteam = steamFeign.getUser(new SteamUserRequestDTO(handlerCreate.getSteamId(),handlerCreate.isCustomSteam()));
            System.out.println(UserSteam);
            userPSNRepositoryJPA.save(UserPSN);
            profileSteamRepositoryJPA.save(UserSteam);
            EnvolvedLists envolvedLists = psFeign.getUserGames(new PSGamesRequestDTO(UserPSN.getAccountId()));
            guardarGames(envolvedLists);
            guardarProperties(envolvedLists);
            //SteamGame[] steamGames = steamFeign.getUserGames(new SteamGamesRequestDTO(handlerCreate.getSteamId()));
            //saveSteamGames(steamGames);
            AccountHandler handler = AccountHandler.createAH(handlerCreate, appuser);
            System.out.println(handler);
            guardarUsuarioEnBBDD(handler);
            return ResponseEntity.status(HttpStatus.CREATED).body(new AccountHandlerDTO(handler));
        }
        //Si no se cumple lanza esta excepción
        throw new UserNotValid();
    }


    public ResponseEntity<?> getAccountsByLogin(LoginRequest loginRequest) {
        Appuser user = appuserRepositoryJPA.findByUsernameAndPassword(
                loginRequest.getUsername(), loginRequest.getPassword());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
        }

        List<AccountHandler> handlers = accountHandlerRepositoryJPA.findById_user(user);
        return ResponseEntity.ok(handlers);
    }

    private void saveSteamGames(SteamGame[] steamGames) {
        for(SteamGame game : steamGames){
            try{
                steamGameRepositoryJPA.save(game);
            } catch (Exception e) {
                System.out.println("Error -> " + e.getMessage());
            }
        }
    }

    private void guardarGames(EnvolvedLists envolvedLists) {
        for(PlayStationGameDTO game : envolvedLists.getUserGames()){
            try{
                gamePSRepositoryJPA.save(new GamePlaystation(game));
            }catch (Exception ignored){
                System.out.println("Error -> " + ignored.getMessage());
            }
        }

    }

    private void guardarProperties(EnvolvedLists envolvedLists) {
        for(PlayStationPropertyDTO propertyPlayStation : envolvedLists.getUserPropertyGames()){
            try{
                gamePropertyPSRepositoryJPA.save(new GamePropertyPlayStation(propertyPlayStation));
            } catch (Exception ignored) {
            }
        }
    }

    private void guardarUsuarioEnBBDD(AccountHandler user) {
        accountHandlerRepositoryJPA.save(user);
    }

    private boolean comprobacionMinimaParaCrearUsuario(HandlerCreate user) {
        return !user.getName().isBlank() &&
                !user.getUserId().toString().isBlank() && !user.getAccountId().isBlank() && !user.getSteamId().isBlank();
    }


}
