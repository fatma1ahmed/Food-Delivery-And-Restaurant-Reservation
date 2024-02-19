package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.FoodDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "should be enter food name")
    private String foodName;
    @Size(min = 8, max = 25, message = "enter your description between 8 and 25 character")
    private String description;
    private double price;
    @ManyToOne
    private Category category;
    public static Food toEntity(FoodDto dto){
        return Food.builder()
                .id(dto.getId())
                .foodName(dto.getFoodName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .build();


    }



}
