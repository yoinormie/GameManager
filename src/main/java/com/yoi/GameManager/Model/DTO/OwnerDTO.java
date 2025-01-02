package com.yoi.GameManager.Model.DTO;

import com.yoi.GameManager.Model.Entity.Owner;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class OwnerDTO {

    private long id;
    private String name;
    private String first_surname;
    private String second_surname;


    public OwnerDTO() {
    }

    public OwnerDTO(long id, String name, String first_surname, String second_surname) {
        this.id = id;
        this.name = name;
        this.first_surname = first_surname;
        this.second_surname = second_surname;
    }

    public OwnerDTO(Owner saved) {
        this.name = saved.getName();
        this.first_surname = saved.getFirstSurname();
        this.second_surname = saved.getSecondSurname();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_surname() {
        return first_surname;
    }

    public void setFirst_surname(String first_surname) {
        this.first_surname = first_surname;
    }

    public String getSecond_surname() {
        return second_surname;
    }

    public void setSecond_surname(String second_surname) {
        this.second_surname = second_surname;
    }

    @Override
    public String toString() {
        return "OwnerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", first_surname='" + first_surname + '\'' +
                ", second_surname='" + second_surname + '\'' +
                '}';
    }
}
