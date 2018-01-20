package com.iqmsoft.dao;


public interface InventoryRepositoryCustom {

    long updateStockProduct(String id, int stock);

    long updatePriceProduct(String id, double price);
}
