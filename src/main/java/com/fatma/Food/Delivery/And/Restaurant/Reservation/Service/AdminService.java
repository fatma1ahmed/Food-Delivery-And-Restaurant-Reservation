package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.exception.DuplicateRecordException;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.exception.RecordNotCorrectException;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Admin;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;
   public ResponseEntity<?> login(String email,String password){
     Admin admin=adminRepo.login(email,password).orElseThrow(
               ()->new RecordNotCorrectException("email or password not correct")
       );
       return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
   }
}
