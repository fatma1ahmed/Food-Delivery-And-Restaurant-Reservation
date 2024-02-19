package com.fatma.Food.Delivery.And.Restaurant.Reservation.controller;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email,@RequestParam  String password){
        return adminService.login(email,password);
    }
}
