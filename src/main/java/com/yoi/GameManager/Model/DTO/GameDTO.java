package com.yoi.GameManager.Model.DTO;

import com.yoi.GameManager.Model.Entity.Owner;
import jakarta.persistence.*;

import java.sql.Date;

public class GameDTO {

    private long id;
    private String title;
    private String developer;
    private String publisher;
    private Date adquisitionDate;
    private Owner owner;

    public GameDTO() {
    }

    public GameDTO(long id, String title, String developer, String publisher, Date adquisitionDate, Owner owner) {
        this.id = id;
        this.title = title;
        this.developer = developer;
        this.publisher = publisher;
        this.adquisitionDate = adquisitionDate;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getAdquisitionDate() {
        return adquisitionDate;
    }

    public void setAdquisitionDate(Date adquisitionDate) {
        this.adquisitionDate = adquisitionDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "GameDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", developer='" + developer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", adquisitionDate=" + adquisitionDate +
                ", owner=" + owner +
                '}';
    }
}

