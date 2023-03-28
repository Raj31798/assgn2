package com.concordia.assignment2.repository;

import com.concordia.assignment2.model.EduCostStat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EduCostStatRepository extends MongoRepository <EduCostStat,String> {
//
// List<EduCostStat> findAll();
// List<EduCostStat> findByType(String type);

}
