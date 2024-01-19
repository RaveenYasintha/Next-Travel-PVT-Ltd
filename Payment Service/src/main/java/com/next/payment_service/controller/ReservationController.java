package com.next.payment_service.controller;

import com.next.payment_service.entity.Reservation;
import com.next.payment_service.service.ReservationService;
import com.next.payment_service.utill.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "/make")
    public ResponseUtil makeReservation(@RequestBody Reservation reservation) {
        return new ResponseUtil(HttpStatus.OK,"Reserved",reservationService.makeReservation(reservation));
    }

    @PutMapping(value = "/edit")
    public ResponseUtil editReservation(@RequestBody Reservation reservation) {
        if (findDateDifference(String.valueOf(reservation.getReservationId()))){
            return new ResponseUtil(HttpStatus.OK,"Edited",reservationService.editReservation(reservation));
        }
        return new ResponseUtil(HttpStatus.SERVICE_UNAVAILABLE,"Can't Edit",null);
    }

    @PutMapping(value = "/cancel")
    public Reservation cancelReservation(@RequestParam String reservationId) {
        if (findDateDifference(reservationId)){
            return reservationService.cancelReservation(reservationId);
        }
       return null;
    }

    private Boolean findDateDifference(String reservationId) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date start_date = reservationService.getReservedDate(reservationId);
        Date end_date = new Date();
        long difference_In_Time = end_date.getTime() - start_date.getTime();
        long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

        if (difference_In_Days < 2){
            return true;
        }
        return false;
    }
    @GetMapping(value = "/getAll")
    public ResponseUtil getAll(String id){
        return new ResponseUtil(HttpStatus.OK,"Done",reservationService.getAll(id));
    }
}
