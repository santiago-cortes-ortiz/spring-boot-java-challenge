package com.jeisson.booking.application;

import com.jeisson.booking.domain.model.BookingRepositoryGateway;
import com.jeisson.booking.domain.usecase.BookingUseCase;
import com.jeisson.booking.infraestructure.driver_adapter.mapper_helper.BookingMapper;
import com.jeisson.booking.infraestructure.driver_adapter.mongo_repository.BookingRepository;
import com.jeisson.booking.infraestructure.driver_adapter.mongo_repository.BookingRepositoryDataAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public BookingRepositoryDataAdapter bookingRepositoryDataAdapter(BookingRepository bookingRepository, BookingMapper bookingMapper){
        return new BookingRepositoryDataAdapter(bookingRepository,bookingMapper);
    }
    @Bean
    public BookingUseCase bookingUseCase(BookingRepositoryGateway bookingRepositoryGateway){
        return new BookingUseCase(bookingRepositoryGateway);
    }
}
