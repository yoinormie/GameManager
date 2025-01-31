package com.yoi.GameManager.Model.DTO.EntityDTOs;

import com.yoi.GameManager.Model.Entity.JPA.Appuser;
import com.yoi.GameManager.Model.Entity.JPA.Owner;
import com.yoi.GameManager.Model.Entity.JPA.Ownership;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDTO {
    private UUID UUID_owner;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private Appuser userId;
    private List<Ownership> ownershipList;

    public OwnerDTO(Owner saved) {
        this.UUID_owner = saved.getId_owner();
        this.name = saved.getName();
        this.firstSurname = saved.getFirstSurname();
        this.secondSurname = saved.getSecondSurname();
        this.userId = saved.getUserId();
    }


}
