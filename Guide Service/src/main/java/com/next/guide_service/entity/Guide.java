package com.next.guide_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document("Cluster0")
public class Guide {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String contactNumber;
    private double manDayPrice;
    private String status;

}
