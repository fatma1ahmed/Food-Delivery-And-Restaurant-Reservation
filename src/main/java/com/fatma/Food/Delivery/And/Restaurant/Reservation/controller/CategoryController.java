package com.fatma.Food.Delivery.And.Restaurant.Reservation.controller;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.CategoryService;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }
    @PutMapping("/updateCategory")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.updateCategory(categoryDto);

    }
@GetMapping("/getCategoryById/{id}")
    public CategoryDto getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
@GetMapping("/getAllCategories")
    public ResponseEntity<?> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @DeleteMapping("/deleteCategoryById/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable int id){
        return categoryService.deleteCategoryById(id);

    }
    @DeleteMapping("/deleteAllCategories")
    public ResponseEntity<?> deleteAllCategories(){
        return categoryService.deleteAllCategories();
    }
}
