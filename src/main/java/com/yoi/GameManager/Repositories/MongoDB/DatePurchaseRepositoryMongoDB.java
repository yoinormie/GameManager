package com.yoi.GameManager.Repositories.MongoDB;

import com.yoi.GameManager.Model.Entity.DatePurchase;
import com.yoi.GameManager.Model.Entity.DatePurchaseKey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DatePurchaseRepositoryMongoDB extends MongoRepository<DatePurchase, DatePurchaseKey> {
}
