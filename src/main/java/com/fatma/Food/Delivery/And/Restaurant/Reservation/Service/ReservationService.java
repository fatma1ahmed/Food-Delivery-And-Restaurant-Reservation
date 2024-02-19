package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.exception.RecordNotFoundException;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.PersonDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.ReservationDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.UserDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Reservation;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.User;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry.ReservationRepo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;
    public ResponseEntity<?> addReservation(ReservationDto reservation){

        return new ResponseEntity<>(ReservationDto.fromEntityToDto(reservationRepo.save(Reservation.toEntity(reservation))),HttpStatus.CREATED);
    }
    public ResponseEntity<?> viewAllReservation(){
      List<Reservation> reservations=reservationRepo. findAll();
      if(!reservations.isEmpty() && reservations!= null){
          for (Reservation reservation: reservations){
              return new ResponseEntity<>(ReservationDto.fromEntityToDto(reservation), HttpStatus.FOUND);
          }
      }
      throw new RecordNotFoundException("There are no reservations");

    }
}
