package com.yoi.GameManager.Repositories.JPA.GameManager;

import com.yoi.GameManager.Model.Entity.JPA.GameManager.AccountHandler;
import com.yoi.GameManager.Model.Entity.JPA.GameManager.AccountHandlerEmbeddable;
import org.springframework.data.repository.Repository;

public interface AccountHandlerRepositoryJPA extends Repository<AccountHandler, AccountHandlerEmbeddable> {
}
