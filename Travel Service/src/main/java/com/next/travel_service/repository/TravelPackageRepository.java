package com.next.travel_service.repository;

import com.next.travel_service.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Integer> {

    Boolean existsByPackageName(String packageName);
}
