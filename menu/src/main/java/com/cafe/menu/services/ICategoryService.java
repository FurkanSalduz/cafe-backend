package com.cafe.menu.services;

import com.cafe.menu.dto.CategoryIU;
import com.cafe.menu.dto.DtoCategory;

import java.util.List;

public interface ICategoryService {

    DtoCategory getCategoryById(Long id);
    DtoCategory createCategory(CategoryIU categoryIU);
    DtoCategory UpdateCategory(Long id ,CategoryIU categoryIU);
    boolean deleteCategoryById(Long id);
    List<DtoCategory> getAllCategories();

}
