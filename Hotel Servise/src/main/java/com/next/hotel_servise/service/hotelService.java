package com.next.hotel_servise.service;

import com.next.hotel_servise.entity.Hotel;

import java.util.List;

public interface hotelService {
    Hotel addHotel(Hotel hotel);

    Hotel updateHotel(Hotel hotel);

    void deleteHotel(Integer hotelId);

    List<Hotel> fetchAllHotel();

    List<Hotel> findAllByStarRate(Integer starRate);
    Object searchHotel(Integer id);
}
