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
    public ResponseEntity findById(@PathVariable String id){
        try {
            return new ResponseEntity<>(bookingUseCase.findById(id), HttpStatus.OK);
        }catch (ServiceException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Booking booking){
        try {
            return new ResponseEntity<>(bookingUseCase.save(booking), HttpStatus.CREATED);
        }catch (ServiceException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody Booking booking){
        try {
            return new ResponseEntity<>(bookingUseCase.update(booking), HttpStatus.OK);
        }catch (ServiceException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        try {
            bookingUseCase.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ServiceException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
