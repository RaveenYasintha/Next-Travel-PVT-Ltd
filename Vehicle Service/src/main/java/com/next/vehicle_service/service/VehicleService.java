package com.next.vehicle_service.service;

import com.next.vehicle_service.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(String regNumber);
    List<Vehicle> fetchAllVehicleByCategory(String category);
    List<Vehicle> fetchAllVehicle();
    Object searchVehicleById(Integer id);

}
