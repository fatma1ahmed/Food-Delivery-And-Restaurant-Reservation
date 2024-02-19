package com.fatma.Food.Delivery.And.Restaurant.Reservation.controller;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.UserService;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        return userService.register(user);

    }

    @PostMapping("/userLogin")
    public ResponseEntity<?> userLogin(@RequestParam String email, @RequestParam  String password){
        return userService.userLogin(email,password);
    }

}
