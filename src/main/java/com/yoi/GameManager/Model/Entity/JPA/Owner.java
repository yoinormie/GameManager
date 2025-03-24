package com.yoi.GameManager.Model.Entity.JPA;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.yoi.GameManager.Components.AppuserDeserialzer;
import com.yoi.GameManager.Model.DTO.RequestDTOs.OwnerRequests.OwnerDTOCreate;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "owner")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_owner;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "first_surname", nullable = false)
    private String firstSurname;

    @Column(name = "second_surname")
    private String secondSurname;

    @JoinColumn(name = "id_user", unique = true, nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JsonIgnore
    private Appuser userId;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Ownership> ownershipList;

    public static Owner newOwner(OwnerDTOCreate ownerDTOCreate, Appuser appuserVinculated){
        Owner owner = new Owner();
        owner.setName(ownerDTOCreate.getName());
        owner.setFirstSurname(ownerDTOCreate.getFirstSurname());
        owner.setSecondSurname(ownerDTOCreate.getSecondSurname());
        owner.setUserId(appuserVinculated);
        return owner;
    }
}
