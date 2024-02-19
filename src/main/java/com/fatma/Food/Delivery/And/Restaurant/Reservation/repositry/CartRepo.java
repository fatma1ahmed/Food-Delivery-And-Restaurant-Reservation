package com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CartDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {

}
