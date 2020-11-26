package com.valdemar.backendspringboot.controller;

import com.valdemar.backendspringboot.entity.Category;
import com.valdemar.backendspringboot.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("test")
    public List<Category> test(){
        return categoryRepository.findAll();
    }
}
