package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.Appuser.IncorrectPassword;
import com.yoi.GameManager.Exceptions.Appuser.UserNotFound;
import com.yoi.GameManager.Exceptions.Appuser.UserNotValid;
import com.yoi.GameManager.Model.DTO.EntityDTOs.AppuserDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.AppuserRequests.DeleteUserDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.AppuserRequests.ModifyUserEmailDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.AppuserRequests.ModifyUserPasswordDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.AppuserRequests.ModifyUsernameDTO;
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
        if(comprobacionMinimaParaCrearUsuario(user)){
            user.setPassword(DatabaseUtils.generateHashedPassword(user.getPassword()));
            guardarUsuarioEnBBDD(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(new AppuserDTO(user));
        }
        //Si no se cumple lanza esta excepción
        throw new UserNotValid();
    }

    @Operation(summary = "Borra un usuario de las BB.DD")
    public ResponseEntity deleteUser(DeleteUserDTO request){

        Appuser userToDelete = comprobacionMinimaParaEliminarUsuario(request);
        //Borra al usuario de las bases de datos
        eliminacionDeLasBases(userToDelete);
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
        if(minimaVerificacionDeModificacionUsuario(request)){
            Appuser user = appuserRepositoryJPA.findByUsername(request.getUsername()).get();
            user.setUsername(request.getNewUsername());

            //Actualiza el nombre del usuario en la base PSQL
            appuserRepositoryJPA.save(user);

            //Crea un objeto de la base de mongo a través de un usuario de la entidad de JPA, y lo guarda en la base, pero 1ro busca la fecha de creación sino la actualiza como null.
            AppuserMongoDB existingDocument = obtenerYModificarUsuarioMongoDB(request, user.getId_user().toString());
            appuserRepositoryMongoDB.save(existingDocument);
            return ResponseEntity.status(HttpStatus.OK).body(new AppuserDTO(user));
        }
        //Lanza una excepción si no entra dentro de la condición
        throw new UserNotValid();
    }

    @Operation(summary = "Método que modifica un email de un usuario")
    public ResponseEntity<AppuserDTO> modifyTheEmail(ModifyUserEmailDTO request){

        if(verificacionMinimaModificacionDeEmail(request)){
            Appuser user = appuserRepositoryJPA.findByUsername(request.getUsername()).get();
            user.setEmail(request.getNewEmail());
            appuserRepositoryJPA.save(user);

            AppuserMongoDB existingDocument = obtenerYModificarUsuarioMongoDB(request,user.getId_user().toString());
            appuserRepositoryMongoDB.save(existingDocument);
            return ResponseEntity.status(HttpStatus.OK).body(new AppuserDTO(user));
        }
        throw new UserNotValid();
    }

    @Operation(summary = "Método que modifica la password de un usuario")
    public ResponseEntity<AppuserDTO> modifyThePassword(ModifyUserPasswordDTO request){

        if(minimaVerificacionDeModificacionUsuario(request)){
            Appuser user = appuserRepositoryJPA.findByUsername(request.getUsername()).get();
            user.setPassword(DatabaseUtils.generateHashedPassword(request.getNewPassword()));
            appuserRepositoryJPA.save(user);

            AppuserMongoDB existingDocument = obtenerYModificarUsuarioMongoDB(user);
            appuserRepositoryMongoDB.save(existingDocument);
            return ResponseEntity.status(HttpStatus.OK).body(new AppuserDTO(user));
        }
        throw new UserNotValid();
    }

    /**
     * Método que reune los guardados de las 2 bases de datos
     * @param user entidad a guardar
     */
    private void guardarUsuarioEnBBDD(Appuser user) {
        appuserRepositoryJPA.save(user);
        appuserRepositoryMongoDB.save(AppuserMongoDB.newUser(user));
    }

    /**
     * Mira, aparte del nombre y la contraseña que inserta el usuario, mira si el correo existente es igual al que se necesita insertar para cambiar
     * @param request clase con los datos necesario a comprobar
     * @return booleano que valida la verificación
     */
    private boolean verificacionMinimaModificacionDeEmail(ModifyUserEmailDTO request) {
        return minimaVerificacionDeModificacionUsuario(request) &&
                DatabaseUtils.verifyInsertedEmail(request.getEmail(), appuserRepositoryJPA.findByUsername(request.getUsername()).get().getEmail());
    }

    /**
     * Verifica si el usuario tiene Nickname, si puso un correo válido y si puso una contraseña
     * @param user Usuario insertado
     * @return booleano que comprueba si vale o no
     */
    private boolean comprobacionMinimaParaCrearUsuario(Appuser user) {
        return !user.getUsername().isBlank() &&
                DatabaseUtils.verifyValidEmail(user.getEmail()) && !user.getPassword().isBlank();
    }

    /**
     * Método que comprueba si vale la request o no
     * @param request valores necesario a comprobar
     * @return comprueba si los valores son correctos para ejecutar la acción
     */
    private Appuser comprobacionMinimaParaEliminarUsuario(DeleteUserDTO request) {
        //Lanza una excepción si no existe un usuario en la B.D. de Postgres
        comprobarNombreVacio(request);
        //Crea un objeto Appuser con todas sus características. Lanza una excepción si la contraseña no es correcta
        Appuser userToDelete = appuserRepositoryJPA.findByUsername(request.getUsername()).get();
        comprobarPassword(request, userToDelete);
        return userToDelete;
    }

    /**
     * Comprueba si la contraseña es válida
     * @param request clase que tiene la contraseña que se tiene que insertar
     * @param userToDelete usuario que tiene la contraseña almacenada
     */
    private static void comprobarPassword(DeleteUserDTO request, Appuser userToDelete) {
        if(!DatabaseUtils.verifyInsertedPassword(request.getPassword(), userToDelete.getPassword())){
            throw new IncorrectPassword();
        }
    }

    /**
     * Comprueba si el campo está vacio
     * @param request contiene los datos que pone el usuario
     */
    private void comprobarNombreVacio(DeleteUserDTO request) {
        if(appuserRepositoryJPA.findByUsername(request.getUsername()).isEmpty()){
            throw new UserNotFound();
        }
    }

    /**
     * Método para modificar el nombre de un usuario
     * @param request clase que tiene el nuevo nombre
     * @param id para buscar a X usuario
     * @return el documento de Mongo con el usuario modificado
     */
    private AppuserMongoDB obtenerYModificarUsuarioMongoDB(ModifyUsernameDTO request, String id) {
        AppuserMongoDB existingDocument = appuserRepositoryMongoDB.findById(id).get();
        existingDocument.setUsername(request.getNewUsername());
        return existingDocument;
    }

    /**
     * Método para modificar el email de un usuario
     * @param request clase que tiene el nuevo email
     * @param id para buscar a X usuario
     * @return el documento de Mongo con el usuario modificado
     */
    private AppuserMongoDB obtenerYModificarUsuarioMongoDB(ModifyUserEmailDTO request, String id) {
        AppuserMongoDB existingDocument = appuserRepositoryMongoDB.findById(id).get();
        existingDocument.setUsername(request.getNewEmail());
        return existingDocument;
    }

    private AppuserMongoDB obtenerYModificarUsuarioMongoDB(Appuser appuser) {
        AppuserMongoDB existingDocument = appuserRepositoryMongoDB.findById(appuser.getId_user().toString()).get();
        existingDocument.setPassword(appuser.getPassword());
        return existingDocument;
    }

    /**
     * Método que mira si los datos valen o no
     * @param request datos a comprobar
     * @return booleano que dice si los datos son correctos o no
     */
    private boolean minimaVerificacionDeModificacionUsuario(ModifyUsernameDTO request) {
        return appuserRepositoryJPA.findByUsername(request.getUsername()).isPresent()
                && DatabaseUtils.verifyInsertedPassword(request.getPassword(),
                appuserRepositoryJPA.findByUsername(request.getUsername()).get().getPassword());
    }

    /**
     * Método que mira si los datos valen o no
     * @param request datos a comprobar
     * @return booleano que dice si los datos son correctos o no
     */
    private boolean minimaVerificacionDeModificacionUsuario(ModifyUserEmailDTO request) {
        return appuserRepositoryJPA.findByUsername(request.getUsername()).isPresent()
                && DatabaseUtils.verifyInsertedPassword(request.getPassword(), appuserRepositoryJPA.findByUsername(request.getUsername()).get().getPassword());
    }

    private boolean minimaVerificacionDeModificacionUsuario(ModifyUserPasswordDTO request) {
        return appuserRepositoryJPA.findByUsername(request.getUsername()).isPresent()
                && DatabaseUtils.verifyInsertedPassword(request.getPassword(),
                appuserRepositoryJPA.findByUsername(request.getUsername()).get().getPassword());
    }
    /**
     * Método que junta otros dos que eliminan un usuario de las BB.DD.
     * @param userToDelete entidad a eliminar
     */
    private void eliminacionDeLasBases(Appuser userToDelete) {
        appuserRepositoryJPA.delete(userToDelete);
        appuserRepositoryMongoDB.deleteByUsername(AppuserMongoDB.newUser(userToDelete).getUsername());
    }
}
