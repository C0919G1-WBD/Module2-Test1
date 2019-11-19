package com.controller;

import com.model.Product;
import com.repository.Impl.ProductRepositoryImpl;
import com.service.Impl.ProductServiceImpl;
import com.service.ProductService;

import java.util.List;

public class ProductController {
    ProductServiceImpl productService = new ProductServiceImpl();

    public List<Product> getProduct() {
        return productService.findAll();
    }

    public void addProduct(Product product) {
        productService.add(product);
    }

    public void deleteProduct(int id) {
        productService.delete(id);
    }

    public void editProduct(int id, Product product) {
        productService.edit(id, product);
    }

    public Product searchProduct(String name) {
        return productService.searchByName(name);
    }

    public void sortByPrice() {
        productService.sortByPrice();
    }
}
