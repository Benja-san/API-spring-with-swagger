package SkillsLab.demo.API.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import SkillsLab.demo.API.entity.Category;
import SkillsLab.demo.API.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
//@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

     @GetMapping("")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // @GetMapping("/{id}")
    // public Category getCategory(@PathVariable Long id) {
    //     return categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    // }

    @GetMapping("/{slug}")
    public Category getCategory(@PathVariable String slug) {
        return categoryRepository.findBySlug(slug).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    @PostMapping("/add")
    public Category addCategory() {
        Category category = new Category("Personalized", "A fully personalized solution");
        category.setSlug("personalized");
        return categoryRepository.save(category);
    }

    @PutMapping("/update")
    public Category updateCategory() {
        Category categoryToUpdate = categoryRepository.findById(1L).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categoryToUpdate.setDescription("CMS solution updated !");
        return categoryRepository.save(categoryToUpdate);
    }

    @DeleteMapping("/delete")
    public void deleteContent() {
        categoryRepository.deleteById(4L);
    }
    
}
