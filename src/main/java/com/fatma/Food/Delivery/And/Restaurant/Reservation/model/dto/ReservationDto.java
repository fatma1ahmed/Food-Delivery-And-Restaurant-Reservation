package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Reservation;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message ="should be enter number of table ")
    private int tableNumber;
    @Min(value = 1)
    @Max(value = 10,message ="The number Of guests should not exceed 10 guest" )
    private int numOfGuests;
    private LocalDateTime date;
    @OneToOne
    private User user;
public  static ReservationDto fromEntityToDto(Reservation entity){
    return ReservationDto.builder()
            .id(entity.getId())
            .tableNumber(entity.getTableNum())
            .numOfGuests(entity.getNumOfGuests())
           .date(entity.getDate())
            .user(entity.getUser())
            .build();
}
}
