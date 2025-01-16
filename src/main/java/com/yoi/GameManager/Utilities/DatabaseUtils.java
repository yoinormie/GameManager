package com.yoi.GameManager.Utilities;


import java.util.UUID;

import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCrypt;

@UtilityClass
public final class DatabaseUtils {

    public UUID generateUUID(){
        return UUID.randomUUID();
    }

    public String generateHashedPassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public boolean verifyValidEmail(String email){
        if(email == null || email.isBlank()){
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}
