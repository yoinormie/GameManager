package com.yoi.GameManager.Controllers;

import com.yoi.GameManager.Model.DTO.OwnerDTO;
import com.yoi.GameManager.Model.Entity.Owner;
import com.yoi.GameManager.Services.OwnerService;
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

    @PostMapping()
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody Owner owner){
        return ownerService.createOwner(owner);
    }

//    @GetMapping("/owner/{id}")
//    public ResponseEntity<OwnerDTO> getOwner(Long id){
//        //return ResponseEntity.status(HttpStatus.OK).body("got owner");
//        return ownerService.getOwnerById(id);
//        }

    @GetMapping("/all")
    public ResponseEntity<List<OwnerDTO>> getAllOwners(){
        return ownerService.getAllOwners();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDTO> updateOwner(@PathVariable Long id, @RequestBody Owner owner){
        //return ResponseEntity.status(HttpStatus.OK).body("updated owner");
        return ownerService.updatedOwner(id, owner);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long id){
        return ownerService.getOwnerById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOwner(@PathVariable Long id){
        //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        return ownerService.deleteOwner(id);
    }

}
