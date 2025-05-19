package com.yoi.GameManager.Repositories.JPA.PlayStation;

import com.yoi.GameManager.Model.Entity.JPA.PlayStation.UserPlaystationNetwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPSNRepositoryJPA extends JpaRepository<UserPlaystationNetwork,String> {
}
