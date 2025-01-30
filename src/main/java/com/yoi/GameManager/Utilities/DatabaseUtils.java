package com.yoi.GameManager.Utilities;


import java.util.UUID;

import com.yoi.GameManager.Repositories.JPA.AppuserRepositoryJPA;
import io.swagger.v3.oas.annotations.Operation;
import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCrypt;

@UtilityClass
public final class DatabaseUtils {

    @Operation(summary = "Genera una contraseña hasheada para guardarla en las bases de datos")
    public String generateHashedPassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    @Operation(summary = "Verifica a través de una expresión regular si el correo es válido")
    public boolean verifyValidEmail(String email){
        if(email == null || email.isBlank()){
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    @Operation(summary = "Verifica si la contraseña insertada y la que está guardada coinciden")
    public boolean verifyInsertedPassword(String insertedPassword, String checkedPassword){
        return BCrypt.checkpw(insertedPassword,checkedPassword);
    }

    @Operation(summary = "Verifica si el correo insertado es igual al almacenado")
    public boolean verifyInsertedEmail(String insertedEmail, String checkedEmail){
        return checkedEmail.equals(insertedEmail);
    }
}
