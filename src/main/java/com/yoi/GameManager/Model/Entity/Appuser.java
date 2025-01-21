package com.yoi.GameManager.Model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "appuser")
@NoArgsConstructor
@Data
@ToString
@AllArgsConstructor
@Document(collection = "Users")
public class Appuser {
    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_user;

    @Field
    @Transient
    private String mongo_id_user;

    @Column(name = "username",nullable = false,length = 255)
    private String username;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Owner> ownerList;
}
