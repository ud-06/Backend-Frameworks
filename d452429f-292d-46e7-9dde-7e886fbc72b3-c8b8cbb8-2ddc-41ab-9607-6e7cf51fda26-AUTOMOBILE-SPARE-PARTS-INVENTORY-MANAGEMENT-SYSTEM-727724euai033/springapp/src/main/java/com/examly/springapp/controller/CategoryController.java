package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Category;
import com.examly.springapp.service.CategoryService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
  
  @Autowired
  private CategoryService categoryService;
  
  @PostMapping
  public ResponseEntity<Category> createCategory(@RequestBody Category category) {
    Category savedCategory = categoryService.saveCategory(category);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
  }
  
  @GetMapping
  public ResponseEntity<List<Category>> getAllCategories() {
    List<Category> categories = categoryService.getAllCategories();
    if (categories.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    return ResponseEntity.ok(categories);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
    Optional<Category> category = categoryService.getCategoryById(id);
    return category.map(ResponseEntity::ok)
           .orElse(ResponseEntity.notFound().build());
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
    Category updatedCategory = categoryService.updateCategory(id, category);
    return ResponseEntity.ok(updatedCategory);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    categoryService.deleteCategory(id);
    return ResponseEntity.ok().build();
  }
  
  @GetMapping("/page/{page}/{size}")
  public ResponseEntity<Page<Category>> getCategoriesWithPagination(
      @PathVariable int page, @PathVariable int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<Category> categories = categoryService.getCategoriesWithPagination(pageable);
    return ResponseEntity.ok(categories);
  }
}

