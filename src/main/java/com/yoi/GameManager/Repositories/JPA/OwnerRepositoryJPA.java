package com.yoi.GameManager.Repositories.JPA;

import com.yoi.GameManager.Model.Entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnerRepositoryJPA extends JpaRepository<Owner, UUID> {

}
