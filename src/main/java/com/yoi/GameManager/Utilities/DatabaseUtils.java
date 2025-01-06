package com.yoi.GameManager.Utilities;


import java.util.UUID;
import org.springframework.security.crypto.bcrypt.BCrypt;
public class DatabaseUtils {

    private UUID generateUUID(){
        return UUID.randomUUID();
    }

    private String generateHashedPassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    private boolean verifyValidEmail(String email){
        if(email == null || email.isBlank()){
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}
