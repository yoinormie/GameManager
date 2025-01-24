package com.yoi.GameManager.Repositories.JPA;

import com.yoi.GameManager.Model.Entity.JPA.Ownership;
import com.yoi.GameManager.Model.Entity.JPA.OwnershipKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnershipRepositoryJPA extends JpaRepository<Ownership, OwnershipKey> {
}
