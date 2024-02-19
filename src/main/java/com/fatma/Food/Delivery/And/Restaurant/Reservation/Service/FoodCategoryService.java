package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CategoryDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.FoodDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FoodCategoryService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private FoodService foodService;

    public ResponseEntity<?> assignFoodToCategory(FoodDto foodDto){
        CategoryDto categoryWithAllFields= categoryService.getCategoryById(foodDto.getCategory().getId());
       foodDto.setCategory(Category.toEntity(categoryWithAllFields));
       return foodService.addFood(foodDto);
    }

}
