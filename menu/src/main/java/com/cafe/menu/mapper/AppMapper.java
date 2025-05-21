package com.cafe.menu.mapper;


import com.cafe.menu.dto.CategoryIU;
import com.cafe.menu.dto.DtoCategory;
import com.cafe.menu.dto.DtoProduct;
import com.cafe.menu.dto.ProductIU;
import com.cafe.menu.entities.Category;
import com.cafe.menu.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AppMapper {

DtoProduct ProductToDtoProduct(Product product);
Product ProtuctIUtoProduct(ProductIU  productIU);
void updateProductFromProductIU(ProductIU productIU, @MappingTarget Product product);


DtoCategory CategoryToDtoCategory(Category category);
Category CategoryIUtoCategory(CategoryIU categoryIU);
void updateCategoryFromCategoryIU(CategoryIU categoryIU, @MappingTarget Category category);

}
