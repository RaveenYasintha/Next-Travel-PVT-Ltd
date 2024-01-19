package com.next.hotel_servise.repository;

import com.next.hotel_servise.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface hotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findAllByStarRate(Integer starRate);

}
