package com.next.travel_service.controller;

import com.next.travel_service.entity.TravelPackage;
import com.next.travel_service.service.TravelPackageService;
import com.next.travel_service.utill.ResponseUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/packages")
public class TravelPackageController {
    @Autowired
    private TravelPackageService travelPackageService;

    @PostMapping(value = "/add_package")
    public ResponseUtill addTravelPackage(@RequestBody TravelPackage travelPackage) {
        return new ResponseUtill("Okay", "Added", travelPackageService.addTravelPackage(travelPackage));
    }

    @PutMapping(value = "/update_package")
    public ResponseUtill updateTravelPackage(@RequestBody TravelPackage travelPackage) {
        return new ResponseUtill("Okay", "Done", travelPackageService.updateTravelPackage(travelPackage));
    }

    @DeleteMapping(value = "/delete_package")
    public ResponseUtill deletePackage(@RequestParam Integer id) {
        travelPackageService.deletePackage(id);
        return new ResponseUtill("Okay", "Deleted", null);
    }

    @GetMapping(value = "/get_packages")
    public ResponseUtill fetchAllPackages() {
        return new ResponseUtill("Okay", "Done", travelPackageService.fetchAllPackages());
    }

    @GetMapping(value = "/get_package")
    public ResponseUtill fetchPackageDetails(@RequestParam Integer id) {
        return new ResponseUtill("Okay", "Done", travelPackageService.fetchPackageDetails(id));
    }

}
