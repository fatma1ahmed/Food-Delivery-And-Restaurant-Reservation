package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.exception.RecordNotFoundException;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.CartDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.OrdersDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Orders;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.User;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepo ordersRepo;

    public ResponseEntity<?> addOrder(OrdersDto ordersDto){

        return new ResponseEntity<>(OrdersDto.fromEntityToDto(ordersRepo.save(Orders.toEntity(ordersDto))), HttpStatus.CREATED);

    }
    public ResponseEntity<?> updateOrder(OrdersDto ordersDto){
        OrdersDto existingOrder=checkOrdersIfExistOrThrowException(ordersDto.getId());
        ordersDto.setFoods(existingOrder.getFoods());
        return new ResponseEntity<>(OrdersDto.fromEntityToDto(ordersRepo.save(Orders.toEntity(ordersDto))), HttpStatus.OK);
    }

    public  OrdersDto getOrderById(int id){
        Optional<Orders> order=ordersRepo.findById(id);
        if (order.isPresent()){
            return OrdersDto.fromEntityToDto(order.get());
        }
        throw new RecordNotFoundException("this order with " + id + "not found");
    }

    public ResponseEntity<?> getAllOrders(){
        List<Orders> orders=ordersRepo.findAll();
        if(!orders.isEmpty() && orders!=null){
            return new ResponseEntity<>(orders,HttpStatus.FOUND);
        }
        throw new RecordNotFoundException("There are no orders");
    }

    public ResponseEntity<?> deleteOrderById(int id){
        OrdersDto existingOrder=checkOrdersIfExistOrThrowException(id);
        ordersRepo.deleteById(id);
        return new ResponseEntity<>("Order has been Successfully Deleted ",HttpStatus.OK);
    }

    public ResponseEntity<?> deleteAllOrders(){
        ordersRepo.deleteAll();
        return new ResponseEntity<>("AllOrders have been Successfully Deleted ",HttpStatus.OK);
    }

    public OrdersDto checkOrdersIfExistOrThrowException(int id){
        return getOrderById(id);

    }
}
