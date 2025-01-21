package com.yoi.GameManager.Controllers;

import com.yoi.GameManager.Model.DTO.OwnerDTO;
import com.yoi.GameManager.Model.Entity.Owner;
import com.yoi.GameManager.Services.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
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


    @Operation(summary = "Obtiene una lista de todos los owners de la base de datos")
    @GetMapping("/all")
    public ResponseEntity<List<OwnerDTO>> getAllOwners(){
        return ownerService.getAllOwners();
    }

    @Operation(summary = "Modifica a un owner pasándole un id y el owner modificado")
    @PutMapping("/{id}")
    public ResponseEntity<OwnerDTO> updateOwner(@PathVariable Long id, @RequestBody Owner owner){
        //return ResponseEntity.status(HttpStatus.OK).body("updated owner");
        //return ownerService.updatedOwner(id, owner);
        return null;
    }

    @Operation(summary = "Obtiene un owner por su id")
    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long id){
        //return ownerService.getOwnerById(id);
        return null;
    }

    @Operation(summary = "Borra a un owner")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOwner(@PathVariable Long id){
        //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        //return ownerService.deleteOwner(id);
        return null;
    }

}
