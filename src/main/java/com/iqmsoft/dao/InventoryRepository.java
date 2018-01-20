package com.iqmsoft.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iqmsoft.model.Inventory;

import java.util.List;
import java.util.Optional;


public interface InventoryRepository extends MongoRepository<Inventory, String>, InventoryRepositoryCustom {

    List<Inventory> findAll();

    Optional<Inventory> findById(String id);
}
