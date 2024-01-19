package com.next.payment_service.repository;

import com.next.payment_service.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Queue;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    @Query("SELECT rr.reservedDate FROM Reservation rr WHERE rr.reservationId=:reservationId")
    Date getReservedDateByReservationId(@Param("reservationId") String reservationId);
    List<Reservation> findAllByUserId(String id);
}
