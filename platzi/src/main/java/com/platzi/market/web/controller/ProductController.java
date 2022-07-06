package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //le indica a spring que es un Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productservice;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productservice.getAll();
    }

    @GetMapping("/product/{productId}")
    public Optional<Product> getProduct(@PathVariable("productId") int productId){
        return productservice.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getCategoryId(@PathVariable("categoryId") int categoryId){
        return productservice.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productservice.save(product);
    }

    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable("productId") int productId){
        productservice.delete(productId);
    }
}
