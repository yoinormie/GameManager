package com.yoi.GameManager.Controllers;

import com.yoi.GameManager.Model.DTO.EntityDTOs.OwnerDTO;
import com.yoi.GameManager.Model.Entity.JPA.Owner;
import com.yoi.GameManager.Services.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
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
    @PostMapping()
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody Owner owner){
        return ownerService.createOwner(owner);
    }

    @Operation(summary = "Obtiene un owner por su nombre")
    @GetMapping("/{name}")
    public ResponseEntity<OwnerDTO> getOwnerByName(@RequestBody String name){
        return ownerService.getOwnerByName(name);
    }

    @Operation(summary = "Borra a un owner")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOwner(@PathVariable Long id){
        //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        //return ownerService.deleteOwner(id);
        return null;
    }

}
