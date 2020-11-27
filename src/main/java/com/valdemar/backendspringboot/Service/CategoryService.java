package com.valdemar.backendspringboot.Service;

import com.valdemar.backendspringboot.entity.Category;
import com.valdemar.backendspringboot.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public List<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public List<Category> findByOrderByTitleASC() {
        return categoryRepository.findAllByOrderByTitleAsc();
    }

    public List<Category> findAllByOrderByTitleAsc(){return findByOrderByTitleASC();}
}
