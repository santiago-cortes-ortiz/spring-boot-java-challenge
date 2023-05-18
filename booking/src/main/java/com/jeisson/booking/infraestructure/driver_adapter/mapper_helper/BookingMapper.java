package com.jeisson.booking.infraestructure.driver_adapter.mapper_helper;

import com.jeisson.booking.domain.model.Booking;
import com.jeisson.booking.infraestructure.driver_adapter.mongo_repository.BookingData;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {
    public Booking toBooking(BookingData bookingData){
        return Booking.builder()
                .id(bookingData.getId().toString())
                .name(bookingData.getName())
                .email(bookingData.getEmail())
                .destination(bookingData.getDestination())
                .departureDateTime(bookingData.getDepartureDateTime())
                .duration(bookingData.getDuration())
                .build();
    }
    public BookingData toBookingData(Booking booking){
        return BookingData.builder()
                .id(booking.getId() != null ? new ObjectId(booking.getId()) : null)
                .name(booking.getName())
                .email(booking.getEmail())
                .destination(booking.getDestination())
                .departureDateTime(booking.getDepartureDateTime())
                .duration(booking.getDuration())
                .build();
    }
}
