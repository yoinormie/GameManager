package com.yoi.GameManager.Model.DTO.EntityDTOs;

import com.yoi.GameManager.Model.Entity.JPA.Appuser;
import com.yoi.GameManager.Model.Entity.JPA.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppuserDTO {
    private UUID id_user;
    private String username;
    private String email;
    private String password;
    private List<Owner> ownerList;

    public AppuserDTO(Appuser user){
        this.id_user = user.getId_user();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
