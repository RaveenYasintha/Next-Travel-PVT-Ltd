package com.next.payment_service.service.impl;

import com.next.payment_service.entity.Reservation;
import com.next.payment_service.repository.ReservationRepository;
import com.next.payment_service.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public Reservation makeReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation editReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation cancelReservation(String reservationId) {
        return null;
    }

    @Override
    public Date getReservedDate(String reservationId) {
        return reservationRepository.getReservedDateByReservationId(reservationId);
    }

    @Override
    public List<Reservation> getAll(String id) {
        return reservationRepository.findAllByUserId(id);
    }
}
