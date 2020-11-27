package com.valdemar.backendspringboot.controller;

import com.valdemar.backendspringboot.util.MyLogger;
import com.valdemar.backendspringboot.entity.Category;
import com.valdemar.backendspringboot.repository.CategoryRepository;
import com.valdemar.backendspringboot.search.CategorySearchValues;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final MyLogger helper = new MyLogger();

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/all")
    public List<Category> findAll() {
        helper.showClassAndMethod("Category Controller: method:findAll() -------------------------------------------");
        return categoryRepository.findAllByOrderByTitleAsc();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category) {
        helper.showClassAndMethod("Category Controller: method:add() -----------------------------------------------");

        if (category.getId() != null && category.getId() != 0) {
            return new ResponseEntity("Id shouldn't be null or 0", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() == null || category.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: TITLE", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category) {
        helper.showClassAndMethod("Category Controller: method:update() --------------------------------------------");

        if (category.getId() == null || category.getId() == 0) {
            return new ResponseEntity("missed param: ID", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() == null || category.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: TITLE", HttpStatus.NOT_ACCEPTABLE);
        }
        categoryRepository.save(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        helper.showClassAndMethod("Category Controller: method:findById() ------------------------------------------");

        Category category;
        try {
            category = categoryRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id = " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable Long id) {
        helper.showClassAndMethod("Category Controller: method:deleteById() ----------------------------------------");

        try {
            categoryRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id = " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategorySearchValues categorySearchValues) {
        helper.showClassAndMethod("Category Controller: method:search() --------------------------------------------");
        return ResponseEntity.ok(categoryRepository.findByTitle(categorySearchValues.getTitle()));
    }


}
