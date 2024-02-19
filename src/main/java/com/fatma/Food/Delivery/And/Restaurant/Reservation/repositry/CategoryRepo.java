package com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
