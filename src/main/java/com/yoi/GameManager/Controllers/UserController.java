package com.yoi.GameManager.Controllers;

import com.yoi.GameManager.Model.DTO.UserDTO;
import com.yoi.GameManager.Model.Entity.User;
import com.yoi.GameManager.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
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
        return userService.createUser(user);
    }

    @Operation(summary = "EndPoint para obtener un User")
    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username){
        return null;
    }

    @Operation(summary = "EndPoint para actualizar el username de un User")
    @PutMapping("/newName/{username}")
    public ResponseEntity<UserDTO> updateTheUsername(@PathVariable String username, @RequestParam String password, @RequestBody String newUsername){
        return userService.modifyTheUsername(username,password,newUsername);
    }

    @Operation(summary = "EndPoint para borrar un User")
    @DeleteMapping("/{username}")
    public ResponseEntity deleteUser(@PathVariable String username, @RequestParam String password){
        return userService.deleteUser(username,password);
    }
}
