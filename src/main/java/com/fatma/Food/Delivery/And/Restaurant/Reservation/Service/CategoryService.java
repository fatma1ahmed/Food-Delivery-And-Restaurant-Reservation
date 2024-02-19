package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.exception.RecordNotFoundException;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CategoryDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Category;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Food;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    public ResponseEntity<?> addCategory(CategoryDto categoryDto){
        return new ResponseEntity<>(CategoryDto.fromEntityToDto(categoryRepo.save(Category.toEntity(categoryDto))), HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateCategory(CategoryDto categoryDto){
        CheckCategoryIsExistOrThrowException(categoryDto.getId());
        System.out.println("category From fatma" + categoryDto);
        return new ResponseEntity<>(CategoryDto.fromEntityToDto(categoryRepo.save(Category.toEntity(categoryDto))),HttpStatus.OK);
    }


    public CategoryDto getCategoryById(int id){
       Optional<Category> category=categoryRepo.findById(id);
        if (category.isPresent()){
            return CategoryDto.fromEntityToDto(category.get());
        }

            throw new RecordNotFoundException("category with " + id + " not found");
    }
    public ResponseEntity<?> getAllCategories(){
        List<Category> categories=categoryRepo.findAll();
        if(!categories.isEmpty()&&categories!=null){
                return new ResponseEntity<>(categories,HttpStatus.FOUND);

        }
        throw new RecordNotFoundException("this Records not found");
    }

    public ResponseEntity<?> deleteCategoryById(int id){
        CheckCategoryIsExistOrThrowException(id);
        categoryRepo.deleteById(id);
        return new ResponseEntity<>("category has been Successfully Deleted ",HttpStatus.OK);
    }

    public ResponseEntity<?> deleteAllCategories(){
     categoryRepo.deleteAll();
     return new ResponseEntity<>(" All categories have been Successfully Deleted ",HttpStatus.OK);

    }

    public void CheckCategoryIsExistOrThrowException(int id){
        getCategoryById(id);

    }

}
