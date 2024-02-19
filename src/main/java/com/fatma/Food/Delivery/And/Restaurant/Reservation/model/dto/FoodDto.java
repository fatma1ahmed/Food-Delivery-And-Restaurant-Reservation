package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Category;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Food;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDto {
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
    public static FoodDto fromEntityToDto(Food entity){
        return FoodDto.builder()
                .id(entity.getId())
                .foodName(entity.getFoodName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .category(entity.getCategory())
                .build();

    }

}
