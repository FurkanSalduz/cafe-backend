package com.cafe.menu.controller;

import com.cafe.menu.dto.CategoryIU;
import com.cafe.menu.dto.DtoCategory;

import com.cafe.menu.services.ICategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final ICategoryService categoryService;


    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;

    }

    @GetMapping("/getById/{id}")
    public DtoCategory getCategoryById(@PathVariable(name = "id") Long id) {
       return categoryService.getCategoryById(id);

    }

    @GetMapping("/getAll")
    public List<DtoCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/update/{id}")
    public DtoCategory updateCategory(@PathVariable(name = "id") Long id, @RequestBody CategoryIU categoryIU) {
        return categoryService.UpdateCategory(id, categoryIU);
    }

    @PostMapping("/save")
    public DtoCategory createCategory(@RequestBody CategoryIU categoryIU) {
        return categoryService.createCategory(categoryIU);

    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCategoryById(@PathVariable(name = "id") Long id) {
        return categoryService.deleteCategoryById(id);

    }
}
