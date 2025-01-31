package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.Owner.InvalidOwner;
import com.yoi.GameManager.Exceptions.Owner.OwnerNotFound;
import com.yoi.GameManager.Model.DTO.EntityDTOs.OwnerDTO;
import com.yoi.GameManager.Model.Entity.JPA.Owner;
import com.yoi.GameManager.Model.Entity.MongoDB.OwnerMongoDB;
import com.yoi.GameManager.Repositories.JPA.OwnerRepositoryJPA;
import com.yoi.GameManager.Repositories.MongoDB.OwnerRepositoryMongoDB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepositoryJPA ownerRepositoryJPA;
    private final OwnerRepositoryMongoDB ownerRepositoryMongoDB;

    public OwnerService(OwnerRepositoryJPA ownerRepositoryJPA, OwnerRepositoryMongoDB ownerRepositoryMongoDB) {
        this.ownerRepositoryJPA = ownerRepositoryJPA;
        this.ownerRepositoryMongoDB = ownerRepositoryMongoDB;
    }

    public ResponseEntity<OwnerDTO> createOwner(Owner owner){
        if(validarCreacionOwner(owner))
            return guardarOwnerEnBBDD(owner);
        throw new InvalidOwner();
    }


    public ResponseEntity<OwnerDTO> getOwnerByName(String name){
        if(!name.isBlank()){
            Owner search = ownerRepositoryJPA.findByName(name).get();
            return ResponseEntity.status(HttpStatus.OK).body(new OwnerDTO(search));
        }
        throw new OwnerNotFound();
    }

    private ResponseEntity<OwnerDTO> guardarOwnerEnBBDD(Owner owner) {
        ownerRepositoryJPA.save(owner);
        OwnerMongoDB ownerDocument = OwnerMongoDB.newOwner(owner);
        ownerRepositoryMongoDB.save(ownerDocument);
        return ResponseEntity.status(HttpStatus.CREATED).body(new OwnerDTO(owner));
    }

    private static boolean validarCreacionOwner(Owner owner) {
        return comprobarNombresOwner(owner) && !owner.getUserId().getId_user().toString().isBlank();
    }

    private static boolean comprobarNombresOwner(Owner owner) {
        return !owner.getName().isBlank() && !owner.getFirstSurname().isBlank() && !owner.getSecondSurname().isBlank();
    }
}
