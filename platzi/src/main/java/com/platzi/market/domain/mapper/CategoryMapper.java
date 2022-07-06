package com.platzi.market.domain.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/*
 * Encargado de convertir categoria en category y asi Orientar nuestra API al dominio con MapStruct
 */
@Mapper(componentModel = "spring" , uses = {CategoryMapper.class})
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria" , target = "categoryId"),
            @Mapping(source = "descripcion" , target = "category"),
            @Mapping(source = "estado" , target = "active"),
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);



}
