package com.fatma.Food.Delivery.And.Restaurant.Reservation.controller;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.EmailService;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.ReservationService;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.UserReservationService;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.ReservationDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserReservationService userReservationService;
    @PostMapping("/addReservation")
//    public ResponseEntity<?> addReservation(@RequestBody ReservationDto reservation){
//    reservationService.addReservation(reservation);
//       emailService.sendEmail(reservation.getUser().getEmail(), "About Reservation","Reservation successful");
//return ResponseEntity.ok("Success");
//    }

    public ResponseEntity<?> assignReservationToUser(@RequestBody ReservationDto reservation){
        ResponseEntity<?> reservationDto=userReservationService.assignReservationToUser(reservation);
        emailService.sendEmail(reservation.getUser().getEmail(), "About Reservation","Reservation successful");
        return reservationDto;
    }

    @GetMapping("/viewAllReservation")
    public ResponseEntity<?> viewAllReservation(){
        return reservationService.viewAllReservation();
    }
}
