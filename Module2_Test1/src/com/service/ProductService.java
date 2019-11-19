package com.service;

import com.model.Product;

public interface ProductService extends GeneralService<Product> {
    Product searchByName(String name);

    void sortByPrice();
}
