package com.concordia.assignment2.controller;

import com.concordia.assignment2.model.EduCostStat;
import com.concordia.assignment2.repository.EduCostStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class query1 {
@Autowired
    private final EduCostStatRepository eduCostStatRepository;

    public query1(EduCostStatRepository eduCostStatRepository) {
        this.eduCostStatRepository = eduCostStatRepository;
    }


    @GetMapping("/product")
    public ResponseEntity<List<EduCostStat>> getAllProducts() {

        return ResponseEntity.ok(this.eduCostStatRepository.findAll());
    }
}






