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
            appuserRepositoryMongoDB.save(AppuserMongoDB.newUser(user));
            return ResponseEntity.status(HttpStatus.CREATED).body(new AppuserDTO(user));
        }
        throw new UserNotValid();
    }

    public ResponseEntity deleteUser(DeleteUserDTO request){
        if(appuserRepositoryJPA.findByUsername(request.getUsername()).isEmpty()){
            throw new UserNotFound();
        }
        Appuser userToDelete = appuserRepositoryJPA.findByUsername(request.getUsername()).get();
        if(!DatabaseUtils.verifyInsertedPassword(request.getPassword(),userToDelete.getPassword())){
            throw new IncorrectPassword();
        }
        appuserRepositoryJPA.delete(userToDelete);
        appuserRepositoryMongoDB.delete(new AppuserMongoDB(AppuserMongoDB));
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<AppuserDTO> getUserByName (String username){
        if(appuserRepositoryJPA.findByUsername(username).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new AppuserDTO(appuserRepositoryJPA.findByUsername(username).get()));
        }
        throw new UserNotFound();
    }

    public ResponseEntity<AppuserDTO> modifyTheUsername(ModifyUsernameDTO request){
        if(appuserRepositoryJPA.findByUsername(request.getUsername()).isPresent() && DatabaseUtils.verifyInsertedPassword(request.getPassword(), appuserRepositoryJPA.findByUsername(request.getUsername()).get().getPassword())){
            Appuser user = appuserRepositoryJPA.findByUsername(request.getUsername()).get();
            user.setUsername(request.getNewUsername());

            appuserRepositoryJPA.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(new AppuserDTO(user));
        }
        throw new UserNotValid();
    }
}
