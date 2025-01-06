package com.yoi.GameManager.Model.DTO;

import com.yoi.GameManager.Model.Entity.Owner;
import com.yoi.GameManager.Model.Entity.User;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OwnerDTO {


    private String UUID;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private User userId;



    public OwnerDTO() {
    }

    public OwnerDTO(String UUID, String name, String firstSurname, String secondSurname, User userId) {
        this.UUID = UUID;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.userId = userId;
    }

    public OwnerDTO(Owner saved) {
        this.name = saved.getName();
        this.firstSurname = saved.getFirstSurname();
        this.secondSurname = saved.getSecondSurname();
        this.userId = saved.getUserId();
    }


}
