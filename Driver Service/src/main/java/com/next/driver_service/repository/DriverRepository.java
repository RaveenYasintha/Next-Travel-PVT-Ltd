package com.next.driver_service.repository;

import com.next.driver_service.enetity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
    boolean existsByIdAndName(Integer driverId,String name);

    @Query("SELECT drv FROM Driver drv WHERE drv.status='Available'")
    Driver findFirstAvailableDriver();
}
