package com.yoi.GameManager.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnerController {

    @PostMapping
    public ResponseEntity<String> createOwner(){
        return ResponseEntity.status(HttpStatus.CREATED).body("created owner");
    }

    @GetMapping
    public ResponseEntity<String> getOwner(){
        return ResponseEntity.status(HttpStatus.OK).body("got owner");    }

    @PutMapping
    public ResponseEntity<String> updateOwner(){
        return ResponseEntity.status(HttpStatus.OK).body("updated owner");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOwner(){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

}
