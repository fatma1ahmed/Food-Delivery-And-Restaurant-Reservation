package com.fatma.Food.Delivery.And.Restaurant.Reservation.exception;

public class DuplicateRecordException extends RuntimeException{
    public DuplicateRecordException() {
        super();
    }

    public DuplicateRecordException(String message) {
        super(message);
    }
}
