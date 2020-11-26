package com.valdemar.backendspringboot.controller;

import com.valdemar.backendspringboot.entity.Category;
import com.valdemar.backendspringboot.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/test")
    public List<Category> test(){
        return categoryRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category){
        if(category.getId() != null && category.getId() !=0){
            return new ResponseEntity("Id shouldn't be null or 0", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: TITLE", HttpStatus.NOT_ACCEPTABLE);
        }
       return ResponseEntity.ok(categoryRepository.save(category));
    }

    @PutMapping("/update")
    public ResponseEntity<Category>update(@RequestBody Category category){
        if (category.getId() == null || category.getId() == 0){
            return new ResponseEntity("missed param: ID",HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: TITLE",HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(categoryRepository.save(category));
    }
}
