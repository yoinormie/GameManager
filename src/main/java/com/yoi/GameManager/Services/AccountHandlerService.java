package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.Appuser.UserNotValid;
import com.yoi.GameManager.Model.DTO.EntityDTOs.GameManager.AppuserDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.AccountHandlerRequest.HandlerCreate;
import com.yoi.GameManager.Model.Entity.JPA.GameManager.AccountHandler;
import com.yoi.GameManager.Model.Entity.JPA.GameManager.Appuser;
import com.yoi.GameManager.Repositories.JPA.GameManager.AccountHandlerRepositoryJPA;
import com.yoi.GameManager.Repositories.JPA.GameManager.AppuserRepositoryJPA;
import com.yoi.GameManager.Utilities.DatabaseUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AccountHandlerService {
    private final AppuserRepositoryJPA appuserRepositoryJPA;
    private final AccountHandlerRepositoryJPA accountHandlerRepositoryJPA;

    public AccountHandlerService(AppuserRepositoryJPA appuserRepositoryJPA, AccountHandlerRepositoryJPA accountHandlerRepositoryJPA) {
        this.appuserRepositoryJPA = appuserRepositoryJPA;
        this.accountHandlerRepositoryJPA = accountHandlerRepositoryJPA;
    }

    @Operation(summary = "Crea un usuario en las BB.DD.")

    public ResponseEntity<AppuserDTO> createUser(HandlerCreate handlerCreate) {
        if (comprobacionMinimaParaCrearUsuario(handlerCreate)) {
            AccountHandler handler = new AccountHandler(handlerCreate);
            guardarUsuarioEnBBDD(handlerCreate);
            return ResponseEntity.status(HttpStatus.CREATED).body(new AccountHandlerDTO(handlerCreate));
        }
        //Si no se cumple lanza esta excepción
        throw new UserNotValid();
    }

    private void guardarUsuarioEnBBDD(AccountHandler user) {
        accountHandlerRepositoryJPA.save(user);
        // appuserRepositoryMongoDB.save(AppuserMongoDB.newUser(user));
    }

    private boolean comprobacionMinimaParaCrearUsuario(HandlerCreate user) {
        return !user.getName().isBlank() &&
                !user.getUserId().toString().isBlank() && !user.getAccountId().isBlank() && !user.getSteamId().isBlank();
    }
}
