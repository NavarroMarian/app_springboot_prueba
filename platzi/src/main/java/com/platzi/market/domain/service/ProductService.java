package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Intermediario entre Controller y Repository
public class ProductService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Product> getAll(){
        return productoRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productoRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productoRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productoRepository.save(product);
    }

    public void delete(int productId){
        productoRepository.delete(productId);
    }

    /*
    return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    */
}
