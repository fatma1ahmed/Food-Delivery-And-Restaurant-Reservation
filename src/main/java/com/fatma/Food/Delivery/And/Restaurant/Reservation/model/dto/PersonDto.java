package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Person;
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
@MappedSuperclass
@Builder
public class PersonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "should be enter your firstName")
    @Size(min = 3,max = 11,message = "firstName should be enter between 3 and 11 characters ")
    private String firstName;
//    @Size(min = 3,max = 11,message = "lastName should be enter between 3 and 11 characters ")
//    private String lastName;
    @Email
    @Column(unique = true)
    @NotNull(message = "should be enter your email")
    private String email;
    @Column(unique = true)
//    @NotNull(message = "should be enter your password")
//    private String password;

    public static PersonDto fromEntityToDto(Person entity){
        return PersonDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
//                .lastName(entity.getLastName())
                .email(entity.getEmail())
//                .password(entity.getPassword())

                .build();

    }
}
