package com.next.guide_service.repository;

import com.next.guide_service.entity.Guide;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface GuideRepository extends MongoRepository<Guide, String> {

    @Query("{'status': 'Available'}")
    List<Guide> findFirstByStatus();
}

