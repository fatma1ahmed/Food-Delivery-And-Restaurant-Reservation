package com.fatma.Food.Delivery.And.Restaurant.Reservation.repositry;

import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.Admin;
import com.fatma.Food.Delivery.And.Restaurant.Reservation.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "select * from users user where user.email= :email and user.password = :password",nativeQuery = true)
    Optional<User> login(String email, String password);

    @Query(value = "select * from users user where user.email= :email",nativeQuery = true)
    Optional<User> findByEmail(String email);

}
