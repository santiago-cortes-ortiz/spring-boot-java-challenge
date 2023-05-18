package com.jeisson.booking.domain.model;

import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Booking {
    private String id;
    private String name;
    private String email;
    private String destination;
    private LocalDateTime departureDateTime;
    private Duration duration;
}
