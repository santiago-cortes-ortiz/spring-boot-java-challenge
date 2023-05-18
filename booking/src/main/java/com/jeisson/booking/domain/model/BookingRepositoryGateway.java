package com.jeisson.booking.domain.model;

import com.jeisson.booking.domain.model.common.ServiceException;

public interface BookingRepositoryGateway {
    Booking save(Booking booking) throws ServiceException;
    Booking update(Booking booking) throws ServiceException;
    Booking findById(String id) throws ServiceException;
    void deleteById(String id) throws ServiceException;
}
