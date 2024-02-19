package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.OrdersDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int totalAmount;
    private double totalPrice;
    @ManyToMany
    private List<Food> foods;
    @ManyToOne
    private User user;

    public static Orders toEntity(OrdersDto dto){
        return Orders.builder()
                .id(dto.getId())
                .totalAmount(dto.getTotalAmount())
                .totalPrice(dto.getTotalPrice())
                .foods(dto.getFoods())
                .user(dto.getUser())
                .build();
    }

}
