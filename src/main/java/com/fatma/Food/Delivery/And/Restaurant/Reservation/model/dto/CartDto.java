package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Cart;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Food;
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
public class CartDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    @ManyToMany
    private List<Food> foods;

    @OneToOne(mappedBy = "cart")
    @JsonIgnore
    private User user;

    public static CartDto fromEntityToDto(Cart entity ){
        return CartDto.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .foods(entity.getFoods())
                .user(entity.getUser())
                . build();
    }
}
