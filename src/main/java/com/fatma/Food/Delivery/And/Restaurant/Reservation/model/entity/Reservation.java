package com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.ReservationDto;
import jakarta.persistence.*;
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
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    @NotNull(message ="should be enter number of table ")
    private int tableNum;
    @Min(value = 1)
    @Max(value = 10,message ="The number Of guests should not exceed 10 guest" )
    private int numOfGuests;
    private LocalDateTime date;
    @OneToOne
    private  User user;

    public  static Reservation toEntity(ReservationDto dto){
        return Reservation.builder()
                .id(dto.getId())
                .tableNum(dto.getTableNumber())
                .numOfGuests(dto.getNumOfGuests())
                .date(dto.getDate())
                .user(dto.getUser())

                .build();

    }

}
