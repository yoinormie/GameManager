package com.yoi.GameManager.Repositories.JPA;

import com.yoi.GameManager.Model.Entity.Ownership;
import com.yoi.GameManager.Model.Entity.OwnershipKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnershipRepositoryJPA extends JpaRepository<Ownership, OwnershipKey> {
}
