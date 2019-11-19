package com.repository;

import com.model.Product;

public interface IProductRepository extends IGeneralRepository<Product> {
    Product searchByName(String name);

    void sortByPrice();
}
