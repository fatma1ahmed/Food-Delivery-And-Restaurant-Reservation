package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.ReservationDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserReservationService {
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;

    public ResponseEntity<?> assignReservationToUser(ReservationDto reservation){
        User userAllFields=userService.getUserById(reservation.getUser().getId());
        reservation.setUser(userAllFields);
       return reservationService.addReservation(reservation);

    }
}
