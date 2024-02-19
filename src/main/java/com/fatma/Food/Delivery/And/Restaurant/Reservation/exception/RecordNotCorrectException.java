package com.fatma.Food.Delivery.And.Restaurant.Reservation.exception;

public class RecordNotCorrectException extends RuntimeException{
    public RecordNotCorrectException() {
        super();
    }

    public RecordNotCorrectException(String message) {
        super(message);
    }
}
