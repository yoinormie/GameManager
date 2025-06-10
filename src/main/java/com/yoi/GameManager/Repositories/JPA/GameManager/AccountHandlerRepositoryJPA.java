package com.yoi.GameManager.Repositories.JPA.GameManager;

import com.yoi.GameManager.Model.Entity.JPA.GameManager.AccountHandler;
import com.yoi.GameManager.Model.Entity.JPA.GameManager.AccountHandlerEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yoi.GameManager.Model.Entity.JPA.GameManager.Appuser;

import java.util.List;


public interface AccountHandlerRepositoryJPA extends JpaRepository<AccountHandler, AccountHandlerEmbeddable> {
    List<AccountHandler> findById_user(Appuser user);
}
