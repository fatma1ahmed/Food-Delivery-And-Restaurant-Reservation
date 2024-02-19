package com.fatma.Food.Delivery.And.Restaurant.Reservation.controller;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.CartService;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private FoodCartService foodCartService;
@PostMapping("addFoodToCart/{cartId}/{foodId}")
    public ResponseEntity<?> assignFoodToCart(@PathVariable int cartId,@PathVariable int foodId ){
        return foodCartService.assignFoodToCart(cartId,foodId);
    }

    @DeleteMapping("deleteFoodFromCart/{cartId}/{foodId}")
    public  ResponseEntity<?> deleteFoodFromCart(@PathVariable int cartId,@PathVariable int foodId){
    return foodCartService.deleteFoodFromCart(cartId,foodId);

    }
    @DeleteMapping("deleteAllFoodsFromCart")
    public ResponseEntity<?> deleteAllFoodsFromCart(int cartId){
    return cartService.deleteAllFoodsFromCart(cartId);
    }
    }
