package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CartDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.OrdersDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Orders;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.User;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrdersUserService {
    @Autowired
    private OrdersService ordersService;
    @Autowired

    private UserService userService;
    @Autowired

    private  CartService cartService;

    public ResponseEntity<?> assignOrderToUser(int userId){
        User user=userService.getUserById(userId);
        CartDto cartWithAllFields=cartService.getCartById(user.getCart().getId());
        OrdersDto orders=new OrdersDto();
        orders.setUser(user);
        orders.setFoods(new ArrayList<>(cartWithAllFields.getFoods()));
        orders.setTotalAmount(orders.getFoods().size());
       return ordersService.addOrder(orders);

    }
}
