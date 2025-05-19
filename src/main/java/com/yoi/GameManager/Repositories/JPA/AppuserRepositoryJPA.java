package com.yoi.GameManager.Repositories.JPA;

import com.yoi.GameManager.Model.Entity.JPA.GameManager.Appuser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AppuserRepositoryJPA extends JpaRepository<Appuser, UUID> {
    Optional<Appuser> findByUsername(String username);
    Optional<Appuser> findByEmail(String email);
}
