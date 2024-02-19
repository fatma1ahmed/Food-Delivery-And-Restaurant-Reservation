package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Person;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.User;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto extends PersonDto {
    @Size(max = 40,message = "The address should not exceed 40 characters")
    private  String address;
    private String phone;

    public static UserDto fromEntityToDto(User entity){
        return UserDto.builder()

                .address(entity.getAddress())
                .phone(entity.getPhone())



                .build();

    }
}
