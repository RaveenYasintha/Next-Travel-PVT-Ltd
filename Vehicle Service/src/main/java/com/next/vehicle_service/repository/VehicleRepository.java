package com.next.vehicle_service.repository;

import com.next.vehicle_service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByCategory(String category);

    Boolean existsByRegNumber(String regNumber);

    void deleteByRegNumber(String regNumber);
}
