package com.next.driver_service.service.impl;

import com.next.driver_service.enetity.Driver;
import com.next.driver_service.repository.DriverRepository;
import com.next.driver_service.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepo;
    @Override
    public Driver addDriver(Driver driver) {
        return driverRepo.save(driver);
    }

    @Override
    public List<Driver> fetchAllDriver() {
        return driverRepo.findAll();
    }

    @Override
    public boolean checkExistsDriver(Integer driverId, String name) {
        return driverRepo.existsByIdAndName(driverId,name);
    }

    @Override
    public void updateDriver(Driver driver) {
        if (!driverRepo.existsById(driver.getId())){
            throw new RuntimeException("Driver Not Found");
        }
        driverRepo.save(driver);
    }

    @Override
    public Driver searchDriver(Integer id) {
        return driverRepo.findById(id).get();
    }

    @Override
    public Driver getAvailableDriver() {
        Driver availableDriver = driverRepo.findFirstAvailableDriver();
        if (availableDriver == null ){
            throw new RuntimeException("There is no available Driver at this moment");
        }
        return availableDriver;
    }

    @Override
    public void setUnavailableDriver(Integer id) {
        Driver driver = searchDriver(id);
        driver.setStatus("Unavailable");
        updateDriver(driver);
    }

}
