package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Category;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Food;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "should be enter categoryName")
    private String categoryName;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Food> food;
    public static CategoryDto fromEntityToDto(Category entity){
        return CategoryDto.builder()
                .id(entity.getId())
                .categoryName(entity.getCategoryName())
               .food(entity.getFood())
                . build();

    }
}

