package com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food,Integer> {
}
