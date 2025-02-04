package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.Appuser.UserNotFound;
import com.yoi.GameManager.Exceptions.Owner.InvalidOwner;
import com.yoi.GameManager.Exceptions.Owner.OwnerNotFound;
import com.yoi.GameManager.Model.DTO.EntityDTOs.OwnerDTO;
import com.yoi.GameManager.Model.Entity.JPA.Owner;
import com.yoi.GameManager.Model.Entity.MongoDB.OwnerMongoDB;
import com.yoi.GameManager.Repositories.JPA.AppuserRepositoryJPA;
import com.yoi.GameManager.Repositories.JPA.OwnerRepositoryJPA;
import com.yoi.GameManager.Repositories.MongoDB.OwnerRepositoryMongoDB;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepositoryJPA ownerRepositoryJPA;
    private final OwnerRepositoryMongoDB ownerRepositoryMongoDB;
    private final AppuserRepositoryJPA appuserRepositoryJPA;

    public OwnerService(OwnerRepositoryJPA ownerRepositoryJPA, OwnerRepositoryMongoDB ownerRepositoryMongoDB, AppuserRepositoryJPA appuserRepositoryJPA) {
        this.ownerRepositoryJPA = ownerRepositoryJPA;
        this.ownerRepositoryMongoDB = ownerRepositoryMongoDB;
        this.appuserRepositoryJPA = appuserRepositoryJPA;
    }

    @Operation(summary = "Crea un Owner en las BB.DD")
    public ResponseEntity<OwnerDTO> createOwner(Owner owner){
        if(!validarCreacionOwner(owner))
            throw new InvalidOwner();
        if(!appuserRepositoryJPA.findById(owner.getUserId().getId_user()).isPresent())
            throw new UserNotFound();
        return guardarOwnerEnBBDD(owner);
    }

    @Operation(summary = "Busca un Owner en la B.D de Postgres a través del nombre")
    public ResponseEntity<OwnerDTO> getOwnerByName(String name){
        if(!name.isBlank()){
            if(ownerRepositoryJPA.findByName(name).isPresent()){
                return devolucionOwner(name);
            }
        }
        throw new OwnerNotFound();
    }

    public ResponseEntity deleteOwner (String name){
        if(!name.isBlank()){
            if (ownerRepositoryJPA.findByName(name).isPresent()){
                borrarOwnerDeBBDD(name);
                return ResponseEntity.noContent().build();
            }
        }
         throw new OwnerNotFound();
    }
    
    @Operation(summary = "Modifica el nombre de un owner")
    public ResponseEntity<OwnerDTO> updateOwnerName (String name, String newName){
        if(!name.isBlank()){
            if(ownerRepositoryJPA.findByName(name).isPresent()){
                Owner ownerToUpdate = ownerRepositoryJPA.findByName(name).get();
                ownerToUpdate.setName(newName);
                OwnerMongoDB ownerMongoDBToUpdate = ownerRepositoryMongoDB.findById(ownerToUpdate.getId_owner().toString()).get();
                ownerMongoDBToUpdate.setName(newName);
                modificarEnLasBBDD(ownerToUpdate, ownerMongoDBToUpdate);
            }
        }
        throw new OwnerNotFound();
    }

    private void modificarEnLasBBDD(Owner ownerToUpdate, OwnerMongoDB ownerMongoDBToUpdate) {
        ownerRepositoryJPA.save(ownerToUpdate);
        ownerRepositoryMongoDB.save(ownerMongoDBToUpdate);
    }

    private void borrarOwnerDeBBDD(String name) {
        Owner ownerToDelete = ownerRepositoryJPA.findByName(name).get();
        ownerRepositoryMongoDB.delete(OwnerMongoDB.newOwner(ownerToDelete));
        ownerRepositoryJPA.delete(ownerToDelete);
    }

    private ResponseEntity<OwnerDTO> devolucionOwner(String name) {
        Owner search = ownerRepositoryJPA.findByName(name).get();
        return ResponseEntity.status(HttpStatus.OK).body(new OwnerDTO(search));
    }

    private ResponseEntity<OwnerDTO> guardarOwnerEnBBDD(Owner owner) {
        ownerRepositoryJPA.save(owner);
        OwnerMongoDB ownerDocument = OwnerMongoDB.newOwner(owner);
        ownerDocument.setIdOwner(ownerRepositoryJPA.findByName(owner.getName()).get().getId_owner().toString());
        ownerRepositoryMongoDB.save(ownerDocument);
        return ResponseEntity.status(HttpStatus.CREATED).body(new OwnerDTO(owner));
    }

    private static boolean validarCreacionOwner(Owner owner) {
        return comprobarNombresOwner(owner) && !owner.getUserId().getId_user().toString().isBlank();
    }

    private static boolean comprobarNombresOwner(Owner owner) {
        return !owner.getName().isBlank() && !owner.getFirstSurname().isBlank();
    }
}
