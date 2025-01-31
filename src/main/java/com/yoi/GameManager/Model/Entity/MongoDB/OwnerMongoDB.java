package com.yoi.GameManager.Model.Entity.MongoDB;

import com.yoi.GameManager.Model.Entity.JPA.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Owners")
public class OwnerMongoDB {

    @Id
    private String idOwner;

    @Field(name = "name")
    private String name;

    @Field(name = "first_surname")
    private String firstSurname;

    @Field(name = "second_surname")
    private String secondSurname;

    @Field(name = "idUser")
    private String idUser;

    public static OwnerMongoDB newOwner(Owner owner){
        OwnerMongoDB ownerMongoDB = new OwnerMongoDB();
        ownerMongoDB.setIdOwner(owner.getId_owner().toString());
        ownerMongoDB.setName(owner.getName());
        ownerMongoDB.setFirstSurname(owner.getFirstSurname());
        ownerMongoDB.setSecondSurname(owner.getSecondSurname());
        ownerMongoDB.setIdUser(owner.getUserId().toString());
        return ownerMongoDB;
    }
}
