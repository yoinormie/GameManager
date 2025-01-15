package com.yoi.GameManager.Repositories.JPA;

import com.yoi.GameManager.Model.Entity.DatePurchase;
import com.yoi.GameManager.Model.Entity.DatePurchaseKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatePurchaseJPA extends JpaRepository<DatePurchase, DatePurchaseKey> {
}
