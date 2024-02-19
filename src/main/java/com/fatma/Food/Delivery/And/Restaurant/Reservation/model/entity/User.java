package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.UserDto;
import jakarta.persistence.*;
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
@Builder
//@Builder(builderMethodName = "userBuilder")
@Table(name = "users")
public class User extends Person{
    @Size(max = 40,message = "The address should not exceed 40 characters")
private  String address;
private String phone;
@OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

@OneToMany(mappedBy = "user",cascade =CascadeType.ALL)
@JsonIgnore
private List<Orders> orders;




    public static User toEntity(UserDto dto){
        return User.builder()
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .build();

    }
}
