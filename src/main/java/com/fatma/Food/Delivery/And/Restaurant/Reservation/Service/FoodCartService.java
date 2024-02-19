package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CartDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.FoodDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FoodCartService {
    @Autowired
    private FoodService foodService;
   @Autowired
    private CartService cartService;

    public ResponseEntity<?> assignFoodToCart(int cartId,int foodId ){
        FoodDto foodWithAllFields=foodService.getFoodById(foodId);
        CartDto cartDto=cartService.getCartById(cartId);
        cartDto.getFoods().add(Food.toEntity(foodWithAllFields));
        cartDto.setQuantity(cartDto.getFoods().size());
        return cartService.addFoodToCart(cartDto);

    }
    public  ResponseEntity<?> deleteFoodFromCart(int cartId,int foodId){
        CartDto cartDto=cartService.getCartById(cartId);
        FoodDto foodWithAllFields=foodService.getFoodById(foodId);
        cartDto.getFoods().remove(Food.toEntity(foodWithAllFields));
        return new ResponseEntity<>("food from cart has been Successfully Deleted ", HttpStatus.OK);
    }


}
