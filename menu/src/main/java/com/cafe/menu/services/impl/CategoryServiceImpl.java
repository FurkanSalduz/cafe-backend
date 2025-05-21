package com.cafe.menu.services.impl;

import com.cafe.menu.dto.CategoryIU;
import com.cafe.menu.dto.DtoCategory;
import com.cafe.menu.entities.Category;
import com.cafe.menu.mapper.AppMapper;
import com.cafe.menu.repository.CategoryRepository;
import com.cafe.menu.services.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final AppMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, AppMapper AppMapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = AppMapper;
    }


    @Override
    public DtoCategory getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
          return  mapper.CategoryToDtoCategory(category.get());
        }
        return null;
    }

    @Override
    public DtoCategory createCategory(CategoryIU categoryIU) {
        Category saveCategory = categoryRepository.save(mapper.CategoryIUtoCategory(categoryIU));
        return mapper.CategoryToDtoCategory(saveCategory);

    }

    @Override
    public DtoCategory UpdateCategory(Long id, CategoryIU categoryIU) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            Category dbCategory = category.get();
            mapper.updateCategoryFromCategoryIU(categoryIU, dbCategory);
       return mapper.CategoryToDtoCategory(categoryRepository.save(dbCategory));

        }
        return null;
    }

    @Override
    public boolean deleteCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return true;

        }
        return false;
    }

    @Override
    public List<DtoCategory> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<DtoCategory> dtoCategories = new ArrayList<>();
        for (Category category : categoryList) {
            dtoCategories.add(mapper.CategoryToDtoCategory(category));

        }
        return dtoCategories;
    }
}
