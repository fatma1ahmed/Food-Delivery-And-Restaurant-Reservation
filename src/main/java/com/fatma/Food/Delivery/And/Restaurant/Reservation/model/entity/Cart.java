package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CartDto;
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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    @ManyToMany
    private List<Food> foods;

    @OneToOne(mappedBy = "cart")
    @JsonIgnore
    private User user;

    public static Cart  toEntity(CartDto dto ){
        return Cart.builder()
                .id(dto.getId())
                .quantity(dto.getQuantity())
                .foods(dto.getFoods())
                .user(dto.getUser())
                . build();
    }

}
