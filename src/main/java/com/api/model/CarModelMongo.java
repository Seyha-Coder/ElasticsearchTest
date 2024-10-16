package com.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;


@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class CarModelMongo {

    @Id
    private String id;

    @Field(targetType = FieldType.STRING, name = "model")
    private String model;

    @Field(targetType = FieldType.INT32, name = "year")
    private Integer yearOfManufacture;

    @Field(targetType = FieldType.STRING, name = "brand")
    private String brand;
}
