package com.jeisson.booking.infraestructure.driver_adapter.mongo_repository;

import com.jeisson.booking.domain.model.Booking;
import com.jeisson.booking.domain.model.BookingRepositoryGateway;
import com.jeisson.booking.domain.model.common.ServiceException;
import com.jeisson.booking.infraestructure.driver_adapter.mapper_helper.BookingMapper;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

@RequiredArgsConstructor
public class BookingRepositoryDataAdapter implements BookingRepositoryGateway {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    @Override
    public Booking findById(String id) throws ServiceException {
        return this.bookingRepository.findById(new ObjectId(id))
                .map(bookingMapper::toBooking)
                .orElseThrow(() -> new ServiceException("Booking not found"));
    }
    @Override
    public Booking save(Booking booking) throws ServiceException {
        try {
            return bookingMapper.toBooking(bookingRepository.save(bookingMapper.toBookingData(booking)));
        }catch (MongoException e){
            throw new ServiceException("Error saving booking", e);
        }
    }
    @Override
    public Booking update(Booking booking) throws ServiceException {
        try {
            return bookingMapper.toBooking(bookingRepository.save(bookingMapper.toBookingData(booking)));
        }catch (MongoException e){
            throw new ServiceException("Error updating booking", e);
        }
    }
    @Override
    public void deleteById(String id) throws ServiceException {
        try {
            bookingRepository.deleteById(new ObjectId(id));
        }catch (MongoException e){
            throw new ServiceException("Error deleting booking", e);
        }
    }
}
