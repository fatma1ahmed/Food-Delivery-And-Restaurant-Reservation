package com.fatma.Food.Delivery.And.Restaurant.Reservation.controller;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.FoodCategoryService;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.FoodService;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class FoodController {
    @Autowired
    private FoodCategoryService foodCategoryService;
    @Autowired
    private FoodService foodService;
    @PostMapping("/assignFoodToCategory")
    public ResponseEntity<?> assignFoodToCategory(@RequestBody   FoodDto foodDto){
        return foodCategoryService.assignFoodToCategory(foodDto);
    }

@PutMapping("/updateFood")
    public ResponseEntity<?> updateFood(@RequestBody FoodDto foodDto){
        return foodService.updateFood(foodDto);
    }
    @GetMapping("/getFoodById/{id}")

    public FoodDto getFoodById(@PathVariable int id){
        return foodService.getFoodById(id);
    }
    @GetMapping("/getAllFoods")

    public ResponseEntity<?> getAllFoods() {
        return foodService.getAllFoods();
    }
@DeleteMapping("/deleteFoodById/{id}")
    public ResponseEntity<?> deleteFoodById(@PathVariable int id){
        return foodService.deleteFoodById(id);
    }
@DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll(){
        return foodService.deleteAll();
    }

}
