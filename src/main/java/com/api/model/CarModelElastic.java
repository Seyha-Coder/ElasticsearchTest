package com.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@Document(indexName = "carindex")
@AllArgsConstructor
@NoArgsConstructor
public class CarModelElastic {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "model")
    private String model;

    @Field(type = FieldType.Integer, name = "year")
    private Integer yearOfManufacture;

    @Field(type = FieldType.Text, name = "brand")
    private String brand;
}
