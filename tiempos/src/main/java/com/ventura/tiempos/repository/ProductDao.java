package com.ventura.tiempos.repository;

import java.util.List;

import com.ventura.tiempos.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}