package com.yoi.GameManager.Controllers;

import com.yoi.GameManager.Model.DTO.EntityDTOs.GameManager.AccountHandlerDTO;
import com.yoi.GameManager.Model.DTO.RequestDTOs.GameManager.AccountHandlerRequest.HandlerCreate;
import com.yoi.GameManager.Services.AccountHandlerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/handler")
@RestController
public class AccountHandlerController {

    private final AccountHandlerService accountHandlerService;

    public AccountHandlerController(AccountHandlerService accountHandlerService) {
        this.accountHandlerService = accountHandlerService;
    }

    @PostMapping()
    public ResponseEntity<AccountHandlerDTO> createUser(@RequestBody HandlerCreate handlerCreate){
        return accountHandlerService.createHandler(handlerCreate);
    }
}
