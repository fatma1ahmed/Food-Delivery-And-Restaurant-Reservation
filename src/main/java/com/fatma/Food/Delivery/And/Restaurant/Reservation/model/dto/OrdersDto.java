package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Food;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Orders;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int totalAmount;
    private double totalPrice;
    @ManyToMany
    private List<Food> foods;
    @ManyToOne
    private User user;

    public static OrdersDto fromEntityToDto(Orders entity){
        return OrdersDto.builder()
                .id(entity.getId())
                .totalAmount(entity.getTotalAmount())
                .totalPrice(entity.getTotalPrice())
                .foods(entity.getFoods())
                .user(entity.getUser())
                .build();
    }
}
