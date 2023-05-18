package com.jeisson.booking.infraestructure.driver_adapter.mongo_repository;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "booking")
@Builder
public class BookingData {
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String destination;
    private LocalDateTime departureDateTime;
    private Duration duration;
}
