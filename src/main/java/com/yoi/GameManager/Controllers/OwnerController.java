package com.yoi.GameManager.Controllers;

import com.yoi.GameManager.Model.DTO.EntityDTOs.OwnerDTO;
import com.yoi.GameManager.Model.Entity.JPA.Owner;
import com.yoi.GameManager.Services.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Operation(summary = "Crea un nuevo owner")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody Owner owner){
        return ownerService.createOwner(owner);
    }

    @Operation(summary = "Obtiene un owner por su nombre")
    @GetMapping("/{name}")
    public ResponseEntity<OwnerDTO> getOwnerByName(@RequestBody String name){
        return ownerService.getOwnerByName(name);
    }

    @Operation(summary = "Actualiza el nombre de un owner")
    @PutMapping("/newOwnerName/{name}")
    public ResponseEntity<OwnerDTO> updateOwnerName(@RequestBody String name, @RequestBody String newName){
        return ownerService.updateOwnerName(name,newName);
    }

    @Operation(summary = "Borra a un owner")
    @DeleteMapping("/{name}")
    public ResponseEntity deleteOwner(@RequestBody String name){
        return ownerService.deleteOwner(name);
    }

}
