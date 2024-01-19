package com.next.vehicle_service.service.impl;

import com.next.vehicle_service.entity.Vehicle;
import com.next.vehicle_service.repository.VehicleRepository;
import com.next.vehicle_service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepo;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        if (!vehicleRepo.existsByRegNumber(vehicle.getRegNumber())){
            throw new RuntimeException("Vehicle Does Not Exists");
        }
        return vehicleRepo.save(vehicle);
    }

    @Override
    public void deleteVehicle(String regNumber) {
        if (!vehicleRepo.existsByRegNumber(regNumber)){
            throw new RuntimeException("Vehicle Does Not Exists");
        }
        vehicleRepo.deleteByRegNumber(regNumber);
    }

    @Override
    public List<Vehicle> fetchAllVehicleByCategory(String category) {
        return vehicleRepo.findByCategory(category);
    }

    @Override
    public List<Vehicle> fetchAllVehicle() {
        return vehicleRepo.findAll();
    }

    @Override
    public Object searchVehicleById(Integer id) {
        return  vehicleRepo.findById(id);
    }

}