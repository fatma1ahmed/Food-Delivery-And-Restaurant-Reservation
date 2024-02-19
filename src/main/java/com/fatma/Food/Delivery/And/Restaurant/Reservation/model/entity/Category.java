package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CategoryDto;
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
@Entity
@Table
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "should be enter categoryName")
    private String categoryName;
    @OneToMany(mappedBy = "category",cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Food> food;
        public static Category toEntity(CategoryDto dto){
        return Category.builder()
                .id(dto.getId())
                .categoryName(dto.getCategoryName())
                .food(dto.getFood())
                . build();
    }
}
