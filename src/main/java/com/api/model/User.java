package com.api.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users") // MongoDB collection
@org.springframework.data.elasticsearch.annotations.Document(indexName = "users")
public class User {

    @Id
    private String id;

    private String username;

    private String email;

    @Transient
    @Field(type = FieldType.Text)  // Field to be indexed in Elasticsearch
    private String description;
}
