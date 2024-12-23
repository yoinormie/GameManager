package com.yoi.GameManager.Services;

import com.yoi.GameManager.Model.Entity.Owner;
import com.yoi.GameManager.Repositories.OwnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;


    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }
}
