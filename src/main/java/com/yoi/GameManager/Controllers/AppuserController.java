package com.yoi.GameManager.Controllers;

import com.yoi.GameManager.Model.DTO.EntityDTOs.AppuserDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.AppuserRequests.DeleteUserDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.AppuserRequests.ModifyUserEmailDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.AppuserRequests.ModifyUserPasswordDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.AppuserRequests.ModifyUsernameDTO;
import com.yoi.GameManager.Model.Entity.JPA.Appuser;
import com.yoi.GameManager.Services.AppuserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class AppuserController {

    private final AppuserService appuserService;

    public AppuserController(AppuserService appuserService) {
        this.appuserService = appuserService;
    }

    @Operation(summary = "EndPoint que crea un User")
    @PostMapping()
    public ResponseEntity<AppuserDTO> createUser(@RequestBody Appuser appuser){
        return appuserService.createUser(appuser);
    }

    @Operation(summary = "EndPoint para obtener un User")
    @GetMapping("/{username}")
    public ResponseEntity<AppuserDTO> getUser(@PathVariable String username){
        return appuserService.getUserByName(username);
    }

    @Operation(summary = "EndPoint para actualizar el username de un User")
    @PutMapping("/newName/{username}")
    public ResponseEntity<AppuserDTO> updateTheUsername(@RequestBody ModifyUsernameDTO request){
        return appuserService.modifyTheUsername(request);
    }

    @Operation(summary = "EndPoint para borrar un User")
    @DeleteMapping("/{username}")
    public ResponseEntity deleteUser(@RequestBody DeleteUserDTO request){
        return appuserService.deleteUser(request);
    }

    @PutMapping("/newEmail/{username}")
    public ResponseEntity<AppuserDTO> updateTheEmail(@RequestBody ModifyUserEmailDTO request){
        return appuserService.modifyTheEmail(request);
    }

    @PutMapping("/newPassword/{username}")
    public ResponseEntity<AppuserDTO> updateThePassword(@RequestBody ModifyUserPasswordDTO request){
        return appuserService.modifyThePassword(request);
    }
}
