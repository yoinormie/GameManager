package com.yoi.GameManager.Services;

import com.yoi.GameManager.Exceptions.Owner.OwnerNotFound;
import com.yoi.GameManager.Model.DTO.OwnerDTO;
import com.yoi.GameManager.Model.Entity.Owner;
import com.yoi.GameManager.Repositories.OwnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;


    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    public ResponseEntity<List<OwnerDTO>> getAllOwners(){
        List<OwnerDTO> ownerDTOList = ownerRepository.findAll().stream().map(OwnerDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(ownerDTOList);
    }

    public ResponseEntity<OwnerDTO> getOwnerById(Long id){
        Optional<Owner> gotten = ownerRepository.findById(id);

        if(gotten.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new OwnerDTO(gotten
                    .orElse(null)));
        }

        throw new OwnerNotFound(id, "El usuario no fue encontrado: ");
        //return ResponseEntity.status(HttpStatus.OK).body(new OwnerDTO(gotten));
    }

    public ResponseEntity<OwnerDTO> createOwner(Owner owner){
        Owner saved = ownerRepository.save(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(new OwnerDTO(saved));
    }

    public ResponseEntity<OwnerDTO> updatedOwner(Long id, Owner owner){
        Optional<Owner> gotten = ownerRepository.findById(id);
        if(gotten.isPresent()){
            Owner existingOwner = gotten.get();
            existingOwner.setName(owner.getName());
            existingOwner.setFirst_surname(owner.getFirst_surname());
            existingOwner.setSecond_surname(owner.getSecond_surname());
            ownerRepository.save(existingOwner);
            return ResponseEntity.status(HttpStatus.OK).body(new OwnerDTO(existingOwner));
        }
        throw new OwnerNotFound(id, "El usuario no fue encontrado: ");
    }

    public ResponseEntity deleteOwner(Long id){
        Optional<Owner> gotten = ownerRepository.findById(id);
        if(gotten.isPresent()){
            Owner existingOwner = gotten.get();
            ownerRepository.delete(existingOwner);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new OwnerNotFound(id, "El usuario no existe: ");
    }
}
