package com.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {
    private String model;
    private Integer yearOfManufacture;
    private String brand;

    public CarModelElastic toElasticEntity() {
        return new CarModelElastic(null, this.model, this.yearOfManufacture, this.brand);
    }

    public CarModelMongo toMongoEntity() {
        return new CarModelMongo(null, this.model, this.yearOfManufacture, this.brand);
    }

    public CarModelElastic toElasticEntity(String id) {
        return new CarModelElastic(id, this.model, this.yearOfManufacture, this.brand);
    }

    public CarModelMongo toMongoEntity(String id) {
        return new CarModelMongo(id, this.model, this.yearOfManufacture, this.brand);
    }
}
