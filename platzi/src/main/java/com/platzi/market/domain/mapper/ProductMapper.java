package com.platzi.market.domain.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
/*
* Encargado de convertir producto en product y asi Orientar nuestra API al dominio con MapStruct
 */

@Mapper(componentModel = "spring" , uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({ //conversion de los atributos
            @Mapping(source = "idProducto" , target = "productId"),
            @Mapping(source = "nombre" , target = "name"),
            @Mapping(source = "idCategoria" , target = "categoryId"),
            @Mapping(source = "precioVenta" , target = "price"),
            @Mapping(source = "cantidadStock" , target = "stock"),
            @Mapping(source = "estado" , target = "active"),

    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration //conversion inversa
    @Mapping(target = "codigoBarra", ignore = true)
    Producto toProducto(Product product);


}
