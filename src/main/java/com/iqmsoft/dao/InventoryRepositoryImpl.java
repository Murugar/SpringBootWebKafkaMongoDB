package com.iqmsoft.dao;

import com.iqmsoft.model.Inventory;
import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


public class InventoryRepositoryImpl implements InventoryRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public long updateStockProduct(String id, int stock) {

        Query query = new Query();
                query.addCriteria(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("stock", stock);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Inventory.class, Inventory.COLLECTION_NAME);

        return result.getMatchedCount();
    }

    @Override
    public long updatePriceProduct(String id, double price) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("price", price);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Inventory.class, Inventory.COLLECTION_NAME);

        return result.getMatchedCount();
    }
}
