package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.PersonDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "should be enter your firstName")
    @Size(min = 3,max = 11,message = "firstName should be enter between 3 and 11 characters ")
    private String firstName;
    @Size(min = 3,max = 11,message = "lastName should be enter between 3 and 11 characters ")
    private String lastName;
    @Email
    @Column(unique = true)
    @NotNull(message = "should be enter your email")
    private String email;
    @Column(unique = true)
    @NotNull(message = "should be enter your password")
    private String password;
    enum role {
        ADMIN,USER
    }
    public static Person toEntity(PersonDto dto){
        return Person.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
//                .lastName(dto.getLastName())
                .email(dto.getEmail())
//                .password(dto.getPassword())
                .build();

    }

}
