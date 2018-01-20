package com.iqmsoft.dao;


public interface InventoryRepositoryCustom {

    int updateStockProduct(String id, int stock);

    int updatePriceProduct(String id, double price);
}
