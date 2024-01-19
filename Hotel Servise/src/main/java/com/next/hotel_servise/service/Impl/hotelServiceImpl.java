package com.next.hotel_servise.service.Impl;

import com.next.hotel_servise.entity.Hotel;
import com.next.hotel_servise.repository.hotelRepository;
import com.next.hotel_servise.service.hotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class hotelServiceImpl implements hotelService {
    @Autowired
    private hotelRepository hotelRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(Integer hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public List<Hotel> fetchAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> findAllByStarRate(Integer starRate) {
        return hotelRepository.findAllByStarRate(starRate);
    }

    @Override
    public Object searchHotel(Integer id) {
       return hotelRepository.findById(id);
    }
}
