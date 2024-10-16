package com.api.repository;

import com.api.model.CarModelMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarMongoRepository extends MongoRepository <CarModelMongo, String>{
}
