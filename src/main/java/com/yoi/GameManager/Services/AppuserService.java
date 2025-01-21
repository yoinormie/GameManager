package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.User.IncorrectPassword;
import com.yoi.GameManager.Exceptions.User.UserNotFound;
import com.yoi.GameManager.Exceptions.User.UserNotValid;
import com.yoi.GameManager.Model.DTO.EntityDTOs.AppuserDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.ModifyUsernameDTO;
import com.yoi.GameManager.Model.Entity.Appuser;
import com.yoi.GameManager.Repositories.JPA.AppuserRepositoryJPA;
import com.yoi.GameManager.Repositories.MongoDB.AppuserRepositoryMongoDB;
import com.yoi.GameManager.Utilities.DatabaseUtils;
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

    public ResponseEntity<AppuserDTO> createUser(Appuser user){
        if(!user.getUsername().isBlank() && DatabaseUtils.verifyValidEmail(user.getEmail()) && !user.getPassword().isBlank()){
            user.setPassword(DatabaseUtils.generateHashedPassword(user.getPassword()));
            appuserRepositoryJPA.save(user);
            user.setMongo_id_user(appuserRepositoryJPA.findByUsername(user.getUsername()).get().getId_user().toString());
            user.setId_user(null);
            appuserRepositoryMongoDB.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(new AppuserDTO(user));
        }
        throw new UserNotValid();
    }

    public ResponseEntity deleteUser(String username, String password){
        if(appuserRepositoryJPA.findByUsername(username).isEmpty()){
            throw new UserNotFound();
        }
        Appuser userToDelete = appuserRepositoryJPA.findByUsername(username).get();
        if(!DatabaseUtils.verifyInsertedPassword(password,userToDelete.getPassword())){
            throw new IncorrectPassword();
        }
        appuserRepositoryJPA.delete(userToDelete);
        appuserRepositoryMongoDB.delete(userToDelete);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<AppuserDTO> getUserByName (String username){
        if(appuserRepositoryJPA.findByUsername(username).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new AppuserDTO(appuserRepositoryJPA.findByUsername(username).get()));
        }
        throw new UserNotFound();
    }

    public ResponseEntity<AppuserDTO> modifyTheUsername(String username, ModifyUsernameDTO request){
        if(appuserRepositoryJPA.findByUsername(username).isPresent() && DatabaseUtils.verifyInsertedPassword(request.getPassword(), appuserRepositoryJPA.findByUsername(username).get().getPassword())){
            Appuser user = appuserRepositoryJPA.findByUsername(username).get();
            user.setUsername(request.getNewUsername());
            appuserRepositoryJPA.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(new AppuserDTO(user));
        }
        throw new UserNotValid();
    }
}
