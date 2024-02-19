package com.fatma.Food.Delivery.And.Restaurant.Reservation.controller;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.OrdersService;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.Service.OrdersUserService;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CategoryDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersUserService ordersUserService;

    @PostMapping("/addOrder/{userId}")
    public ResponseEntity<?> assignOrderToUser(@PathVariable int userId){
        return ordersUserService.assignOrderToUser(userId);
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<?> updateOrder(OrdersDto ordersDto){
        return ordersService.updateOrder(ordersDto);
    }
    @GetMapping("/getOrderById/{id}")
    public  OrdersDto getOrderById(int id) {
        return ordersService.getOrderById(id);
    }

    @GetMapping("/getAllOrders")
        public ResponseEntity<?> getAllOrders(){
        return ordersService.getAllOrders();
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public ResponseEntity<?> deleteOrderById(int id) {
        return ordersService.deleteOrderById(id);
    }

    @DeleteMapping("/deleteAllOrders")
    public ResponseEntity<?> deleteAllOrders() {
        return ordersService.deleteAllOrders();
    }


    }
