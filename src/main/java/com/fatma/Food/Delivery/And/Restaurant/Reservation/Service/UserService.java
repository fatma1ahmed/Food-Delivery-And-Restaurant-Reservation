package com.fatma.Food.Delivery.And.Restaurant.Reservation.Service;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.exception.DuplicateRecordException;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.exception.RecordNotCorrectException;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.exception.RecordNotFoundException;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.PersonDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.dto.UserDto;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Cart;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.User;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<?> register(User user){

        user.setCart(new Cart());
     Optional<User> user1=userRepo.findByEmail(user.getEmail());
     if(user1.isPresent()){
         throw new DuplicateRecordException("this email already found with anther user");
     }
        return new ResponseEntity<>(userRepo.save(user),HttpStatus.CREATED);
    }

    public ResponseEntity<?> findByEmail(String email){
        return new ResponseEntity<>(userRepo.findByEmail(email), HttpStatus.ACCEPTED);
    }
    public ResponseEntity<?> userLogin(String email,String password){
        User user=userRepo.login(email,password).orElseThrow(
                ()->new RecordNotCorrectException("email or password not correct")
        );
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }
    public User getUserById(int id){
      return userRepo.findById(id).orElseThrow(
              ()->new RecordNotFoundException("this user with " + id + " not found")
      );
    }
}
