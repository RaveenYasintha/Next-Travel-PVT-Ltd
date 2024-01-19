package com.next.hotel_servise.controller;

import com.next.hotel_servise.entity.Hotel;
import com.next.hotel_servise.service.hotelService;
import com.next.hotel_servise.utill.ResponseUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/hotel")
public class hotelController {
    @Autowired
    private hotelService hotelService;

    @PostMapping(value = "/add_hotel")
    public ResponseUtill addHotel(@RequestBody Hotel hotel) {
        return new ResponseUtill("Okay", "Done and Added", hotelService.addHotel(hotel));
    }

    @PutMapping(value = "/update_hotel")
    public ResponseUtill updateHotel(@RequestBody Hotel hotel) {
        return new ResponseUtill("Okay", "Done and Added", hotelService.updateHotel(hotel));
    }

    @DeleteMapping(value = "/delete_hotel")
    public ResponseUtill deleteHotel(@RequestParam String hotelId) {
        hotelService.deleteHotel(Integer.valueOf(hotelId));
        return new ResponseUtill("Okay", "Done and Added", null);
    }

    @GetMapping(value = "/view_all")
    public ResponseUtill fetchAllHotel() {
        return new ResponseUtill("Ok", "Done", hotelService.fetchAllHotel());
    }

    @GetMapping
    public ResponseUtill getHotelsByCategory(@RequestParam Integer starRate) {
        return new ResponseUtill("Ok", "Done", hotelService.findAllByStarRate(starRate));
    }
    @GetMapping(value = "/search")
    public ResponseUtill searchHotelById(@RequestParam Integer id){
        return new ResponseUtill("Okay","Done",hotelService.searchHotel(id));
    }
}
