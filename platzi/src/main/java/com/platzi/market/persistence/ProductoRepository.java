package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.mapper.ProductMapper;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
Repositorio enfocado al dominio , con esto se evita que el proyecto se acople a una bd puntual
(Orientar nuestro repositoria al dominio)
 */

@Repository //interactua con la bd
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int stock){
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(stock, true);
        return productos.map(productos1 -> mapper.toProducts(productos1));
    }

    @Override
    public Optional<Product> getProduct(int idProducto){
        return productoCrudRepository.findById(idProducto).map(producto -> mapper.toProduct(producto));
    }

    public Product save(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
    
}
 