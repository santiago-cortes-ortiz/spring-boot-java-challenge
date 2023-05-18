package com.jeisson.booking.infraestructure.driver_adapter.mongo_repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<BookingData, ObjectId> {
}
