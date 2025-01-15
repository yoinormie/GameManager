package com.yoi.GameManager.Repositories.JPA;

import com.yoi.GameManager.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<User, UUID> {
}
