package com.repository.Impl;

import com.model.Product;
import com.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    ArrayList<Product> listProduct = new ArrayList<>();
    {
        listProduct.add(new Product(1,"Samsung galaxy S8",6500000,true,"Hello"));
        listProduct.add(new Product(2,"Iphone 6",5700000,true,"Hello"));
        listProduct.add(new Product(3,"Oppo A9",8600000,true,"Hello"));
        listProduct.add(new Product(4,"Nokia 1280",9000000,true,"Hello"));
        listProduct.add(new Product(5,"Oneplus 2",4500000,true,"Hello"));
    }

    @Override
    public List<Product> findAll() {
        return listProduct;
    }

    @Override
    public void add(Product product) {
        listProduct.add(product);
    }

    @Override
    public void delete(int id) {
        for(int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getId() == id) {
                listProduct.remove(i);
                break;
            }
        }
    }

    @Override
    public void edit(int id, Product product) {
        for(int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getId() == id) {
                listProduct.set(i, product);
            }
        }
    }

    @Override
    public Product searchByName(String name) {
        for(int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                return listProduct.get(i);
            }
        }
        return null;
    }

    @Override
    public void sortByPrice() {
        listProduct.sort(new ProductComparator());
    }
}
