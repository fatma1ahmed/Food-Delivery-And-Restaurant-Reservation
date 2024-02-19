package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.exception.RecordNotFoundException;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.FoodDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Food;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepo foodRepo;
    public ResponseEntity<?> addFood(FoodDto foodDto){
        return new ResponseEntity<>(FoodDto.fromEntityToDto(foodRepo.save(Food.toEntity(foodDto))), HttpStatus.CREATED);
    }
    public ResponseEntity<?> updateFood(FoodDto foodDto){
        CheckFoodIsExistOrThrowException(foodDto.getId());
        return new ResponseEntity<>(FoodDto.fromEntityToDto(foodRepo.save(Food.toEntity(foodDto))), HttpStatus.OK);

    }
    public FoodDto getFoodById(int id){
        Optional<Food> food=foodRepo.findById(id);
        if(food.isPresent()){
            return  FoodDto.fromEntityToDto(food.get());
        }

            throw new RecordNotFoundException("food with " + id + "not found");
    }

    public ResponseEntity<?> getAllFoods() {
        List<Food> foods = foodRepo.findAll();
        if (!foods.isEmpty() && foods != null) {
                return new ResponseEntity<>(foods, HttpStatus.FOUND);
        }
            throw new RecordNotFoundException("There are no foods");
    }
    public ResponseEntity<?> deleteFoodById(int id){
        CheckFoodIsExistOrThrowException(id);
        foodRepo.deleteById(id);
        return new ResponseEntity<>("food has been Successfully Deleted",HttpStatus.OK);
    }
    public ResponseEntity<?> deleteAll(){
        foodRepo.deleteAll();
        return new ResponseEntity<>("All foods have been Successfully Deleted ",HttpStatus.OK);
    }


    public FoodDto CheckFoodIsExistOrThrowException(int id){
         return getFoodById(id);
    }




}
