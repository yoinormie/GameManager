package com.yoi.GameManager.Controllers;

import com.yoi.GameManager.Model.DTO.UserDTO;
import com.yoi.GameManager.Model.Entity.User;
import com.yoi.GameManager.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "EndPoint que crea un User")
    @PostMapping()
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        return null;
    }

    @Operation(summary = "EndPoint para obtener un User")
    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username){
        return null;
    }

    @Operation(summary = "EndPoint para actualizar un User")
    @PutMapping("/{username}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String username, @RequestParam User user){
        return null;
    }

    @Operation(summary = "EndPoint para actualizar un User")
    @DeleteMapping("/{username}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String username, @RequestParam String password){
        return null;
    }
}
