package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.User.IncorrectPassword;
import com.yoi.GameManager.Exceptions.User.UserNotFound;
import com.yoi.GameManager.Exceptions.User.UserNotValid;
import com.yoi.GameManager.Model.DTO.EntityDTOs.AppuserDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.DeleteUserDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.ModifyUsernameDTO;
import com.yoi.GameManager.Model.Entity.JPA.Appuser;
import com.yoi.GameManager.Model.Entity.MongoDB.AppuserMongoDB;
import com.yoi.GameManager.Repositories.JPA.AppuserRepositoryJPA;
import com.yoi.GameManager.Repositories.MongoDB.AppuserRepositoryMongoDB;
import com.yoi.GameManager.Utilities.DatabaseUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppuserService {
    private final AppuserRepositoryJPA appuserRepositoryJPA;
    private final AppuserRepositoryMongoDB appuserRepositoryMongoDB;

    public AppuserService(AppuserRepositoryJPA appuserRepositoryJPA, AppuserRepositoryMongoDB appuserRepositoryMongoDB) {
        this.appuserRepositoryJPA = appuserRepositoryJPA;
        this.appuserRepositoryMongoDB = appuserRepositoryMongoDB;
    }

    @Operation(summary = "Crea un usuario en las BB.DD.")

    public ResponseEntity<AppuserDTO> createUser(Appuser user){
        //Verifica si el usuario tiene Nickname, si puso un correo válido y si puso una contraseña
        if(!user.getUsername().isBlank() && DatabaseUtils.verifyValidEmail(user.getEmail()) && !user.getPassword().isBlank()){
            user.setPassword(DatabaseUtils.generateHashedPassword(user.getPassword()));
            appuserRepositoryJPA.save(user);
            appuserRepositoryMongoDB.save(AppuserMongoDB.newUser(user));
            return ResponseEntity.status(HttpStatus.CREATED).body(new AppuserDTO(user));
        }
        //Si no se cumple lanza esta excepción
        throw new UserNotValid();
    }

    @Operation(summary = "Borra un usuario de las BB.DD")
    public ResponseEntity deleteUser(DeleteUserDTO request){
        //Lanza una excepción si no existe un usuario en la B.D. de Postgres
        if(appuserRepositoryJPA.findByUsername(request.getUsername()).isEmpty()){
            throw new UserNotFound();
        }
        //Crea un objeto Appuser con todas sus características. Lanza una excepción si la contraseña no es correcta
        Appuser userToDelete = appuserRepositoryJPA.findByUsername(request.getUsername()).get();
        if(!DatabaseUtils.verifyInsertedPassword(request.getPassword(),userToDelete.getPassword())){
            throw new IncorrectPassword();
        }
        //Borra al usuario de las bases de datos
        appuserRepositoryJPA.delete(userToDelete);
        appuserRepositoryMongoDB.delete(AppuserMongoDB.newUser(userToDelete));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca a un usuario en la B.D de Postgres")
    public ResponseEntity<AppuserDTO> getUserByName (String username){
        //Mira si el usuario está en la B.D.
        if(appuserRepositoryJPA.findByUsername(username).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new AppuserDTO(appuserRepositoryJPA.findByUsername(username).get()));
        }
        //De normal, lanza una excepción si no entra en el if.
        throw new UserNotFound();
    }

    @Operation(summary = "Modifica el nickname de un usuario existente")
    public ResponseEntity<AppuserDTO> modifyTheUsername(ModifyUsernameDTO request){
        //Mira si existe un usuario con ese nombre y si la contraseña es correcta
        if(appuserRepositoryJPA.findByUsername(request.getUsername()).isPresent() && DatabaseUtils.verifyInsertedPassword(request.getPassword(), appuserRepositoryJPA.findByUsername(request.getUsername()).get().getPassword())){
            //Crea un objeto para guardar toda la información del usuario y se le pone un nuevo nickname
            Appuser user = appuserRepositoryJPA.findByUsername(request.getUsername()).get();
            user.setUsername(request.getNewUsername());
            //Actualiza el nombre del usuario en la base PSQL
            appuserRepositoryJPA.save(user);
            //Crea un objeto de la base de mongo a través de un usuario de la entidad de JPA, y lo guarda en la base, pero 1ro busca la fecha de creación sino la actualiza como null.
            AppuserMongoDB userMDB = AppuserMongoDB.updateUser(user);
            userMDB.setCreateDate(appuserRepositoryMongoDB.findById(userMDB.getId_user()).get().getCreateDate());
            appuserRepositoryMongoDB.save(userMDB);
            return ResponseEntity.status(HttpStatus.OK).body(new AppuserDTO(user));
        }
        //Lanza una excepción si no entra dentro de la condición
        throw new UserNotValid();
    }
}
