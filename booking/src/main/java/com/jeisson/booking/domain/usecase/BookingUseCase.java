package com.jeisson.booking.domain.usecase;

import com.jeisson.booking.domain.model.Booking;
import com.jeisson.booking.domain.model.BookingRepositoryGateway;
import com.jeisson.booking.domain.model.common.ServiceException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookingUseCase {
    private final BookingRepositoryGateway bookingRepositoryGateway;
    public Booking save(Booking booking) throws ServiceException {
        return bookingRepositoryGateway.save(booking);
    }
    public Booking update(Booking booking) throws ServiceException {
        validateBookingId(booking.getId());
        return bookingRepositoryGateway.update(booking);
    }
    public Booking findById(String id) throws ServiceException {
        validateBookingId(id);
        return bookingRepositoryGateway.findById(id);
    }
    public void deleteById(String id) throws ServiceException {
        validateBookingId(id);
        bookingRepositoryGateway.deleteById(id);
    }

    private void validateBookingId(String id) throws ServiceException {
        if (id == null) {
            throw new ServiceException("Booking id is required");
        }
    }

}
