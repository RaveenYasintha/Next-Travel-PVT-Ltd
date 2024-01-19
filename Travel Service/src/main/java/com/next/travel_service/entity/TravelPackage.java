package com.next.travel_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "travel_packages_details")
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String packageName;
    private Integer headCount;
    private String packageCategory;
    private Integer starRate;
    private String description;
}
