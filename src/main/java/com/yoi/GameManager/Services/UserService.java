package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.User.UserNotValid;
import com.yoi.GameManager.Model.DTO.UserDTO;
import com.yoi.GameManager.Model.Entity.User;
import com.yoi.GameManager.Repositories.JPA.UserRepositoryJPA;
import com.yoi.GameManager.Utilities.DatabaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepositoryJPA userRepositoryJPA;

    public UserService(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    public ResponseEntity<UserDTO> createUser(User user){
        if(!user.getName().isBlank() && DatabaseUtils.verifyValidEmail(user.getEmail()) && !user.getPassword().isBlank()){
            user.setId(DatabaseUtils.generateUUID());
            user.setPassword(DatabaseUtils.generateHashedPassword(user.getPassword()));
            userRepositoryJPA.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(user));
        }
        throw new UserNotValid();
    }
}
