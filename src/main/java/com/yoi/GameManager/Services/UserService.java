package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.User.IncorrectPassword;
import com.yoi.GameManager.Exceptions.User.UserNotFound;
import com.yoi.GameManager.Exceptions.User.UserNotValid;
import com.yoi.GameManager.Model.DTO.UserDTO;
import com.yoi.GameManager.Model.Entity.User;
import com.yoi.GameManager.Repositories.JPA.UserRepositoryJPA;
import com.yoi.GameManager.Repositories.MongoDB.UserRepositoryMongoDB;
import com.yoi.GameManager.Utilities.DatabaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepositoryJPA userRepositoryJPA;
    private final UserRepositoryMongoDB userRepositoryMongoDB;

    public UserService(UserRepositoryJPA userRepositoryJPA, UserRepositoryMongoDB userRepositoryMongoDB) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.userRepositoryMongoDB = userRepositoryMongoDB;
    }

    public ResponseEntity<UserDTO> createUser(User user){
        if(!user.getName().isBlank() && DatabaseUtils.verifyValidEmail(user.getEmail()) && !user.getPassword().isBlank()){
            user.setId(DatabaseUtils.generateUUID());
            user.setPassword(DatabaseUtils.generateHashedPassword(user.getPassword()));
            userRepositoryJPA.save(user);
            userRepositoryMongoDB.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(user));
        }
        throw new UserNotValid();
    }

    public ResponseEntity deleteUser(String username, String password){
        if(userRepositoryJPA.findByName(username).isEmpty()){
            throw new UserNotFound();
        }
        User userToDelete = userRepositoryJPA.findByName(username).get();
        if(!DatabaseUtils.verifyInsertedPassword(password,userToDelete.getPassword())){
            throw new IncorrectPassword();
        }
        userRepositoryJPA.delete(userToDelete);
        userRepositoryMongoDB.delete(userToDelete);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<UserDTO> getUserByName (String username){
        if(userRepositoryJPA.findByName(username).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(userRepositoryJPA.findByName(username).get()));
        }
        throw new UserNotFound();
    }

    public ResponseEntity<UserDTO> modifyTheUsername(String username, String password, String newUsername){
        if(userRepositoryJPA.findByName(username).isPresent() && DatabaseUtils.verifyInsertedPassword(password,userRepositoryJPA.findByName(username).get().getPassword())){
            User user = userRepositoryJPA.findByName(username).get();
            user.setName(newUsername);
            userRepositoryJPA.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(user));
        }
        throw new UserNotValid();
    }
}
