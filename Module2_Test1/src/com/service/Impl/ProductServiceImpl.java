package com.service.Impl;

import com.model.Product;
import com.repository.Impl.ProductRepositoryImpl;
import com.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void edit(int id, Product product) {
        productRepository.edit(id, product);
    }

    @Override
    public Product searchByName(String name) {
        return productRepository.searchByName(name);
    }

    @Override
    public void sortByPrice() {
        productRepository.sortByPrice();
    }
}
