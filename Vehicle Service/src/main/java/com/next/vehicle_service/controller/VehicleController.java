package com.next.vehicle_service.controller;

import com.next.vehicle_service.entity.Vehicle;
import com.next.vehicle_service.service.VehicleService;
import com.next.vehicle_service.utill.ResponseUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping(value = "/add_vehicle")
    public ResponseUtill addVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseUtill("Ok", "Vehicle Added", vehicleService.addVehicle(vehicle));
    }

    @PutMapping(value = "/update_vehicle")
    public ResponseUtill updateVehicle(@RequestBody Vehicle vehicle){
        return new ResponseUtill("Ok", "Vehicle Added", vehicleService.updateVehicle(vehicle));
    }

    @DeleteMapping(value = "/delete_vehicle")
    public ResponseUtill deleteVehicle(@RequestParam String regNumber){
        vehicleService.deleteVehicle(regNumber);
        return new ResponseUtill("Ok", "Vehicle Deleted", null);
    }

    @GetMapping(value = "/category")
    public ResponseUtill fetchAllVehicleByCategory(@RequestParam String category) {
        return new ResponseUtill("Ok", "", vehicleService.fetchAllVehicleByCategory(category));
    }

    @GetMapping(value = "/fetch_all")
    public ResponseUtill fetchAllVehicle() {
        return new ResponseUtill("Ok", "", vehicleService.fetchAllVehicle());
    }
@GetMapping(value ="search_Vehicle" )
    public ResponseUtill searchVehicle(Integer id){
        return  new ResponseUtill("Done","Okay",vehicleService.searchVehicleById(id));
}
}
