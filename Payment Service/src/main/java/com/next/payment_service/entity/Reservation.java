package com.next.payment_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation_details")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservationId;
    private String packageId;
    private String hotelId;
    private String vehicleRegNumber;
    private String userId;
    private String status;
    private double totalAmount;
    private String driverId;
    private String guideId;
    private Date reservedDate;

}
