package com.jeisson.booking.infraestructure.entry_point;

import com.jeisson.booking.domain.model.Booking;
import com.jeisson.booking.domain.model.common.ServiceException;
import com.jeisson.booking.domain.usecase.BookingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingRest {
    private final BookingUseCase bookingUseCase;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        return new ResponseEntity<>(bookingUseCase.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Booking booking) {
        return new ResponseEntity<>(bookingUseCase.save(booking), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Booking booking) {
        return new ResponseEntity<>(bookingUseCase.update(booking), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        bookingUseCase.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
