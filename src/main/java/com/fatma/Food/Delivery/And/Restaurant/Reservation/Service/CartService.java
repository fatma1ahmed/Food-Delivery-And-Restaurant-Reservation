package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.exception.RecordNotFoundException;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CartDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.FoodDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Cart;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Food;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;
    public ResponseEntity<?> addFoodToCart(CartDto cartDto){

      return new ResponseEntity<>(CartDto.fromEntityToDto(cartRepo.save(Cart.toEntity(cartDto))), HttpStatus.CREATED);

    }
    public ResponseEntity<?> deleteAllFoodsFromCart(int cartId){
        CartDto cartDto=getCartById(cartId);
        cartDto.getFoods().clear();
        return new ResponseEntity<>("All foods from cart has been Successfully Deleted ", HttpStatus.OK);
    }
    public CartDto getCartById(int id) {
        Optional<Cart> cart=cartRepo.findById(id);
        if(cart.isPresent()) {
            return CartDto.fromEntityToDto(cart.get());
        }
        throw new RecordNotFoundException("this cart with " + id + "not found");
    }

}
