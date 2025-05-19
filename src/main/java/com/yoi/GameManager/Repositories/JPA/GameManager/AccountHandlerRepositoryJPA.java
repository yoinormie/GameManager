package com.yoi.GameManager.Repositories.JPA.GameManager;

import com.yoi.GameManager.Model.Entity.JPA.GameManager.AccountHandler;
import com.yoi.GameManager.Model.Entity.JPA.GameManager.AccountHandlerEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHandlerRepositoryJPA extends JpaRepository<AccountHandler, AccountHandlerEmbeddable> {
}
