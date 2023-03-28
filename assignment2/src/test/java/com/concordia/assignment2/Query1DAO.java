package com.concordia.assignment2;

import com.concordia.assignment2.model.EduCostStat;
import com.concordia.assignment2.repository.EduCostStatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Query1DAO {
    @Autowired

    private static EduCostStatRepository eduCostStatRepository ;
    public Query1DAO(EduCostStatRepository eduCostStatRepository) {
        this.eduCostStatRepository = eduCostStatRepository;
    }

    @Test
    public void showAllGroceryItems() {




        eduCostStatRepository.findAll().forEach(item -> System.out.println(getClass(item)));
    }

    private EduCostStat getClass(EduCostStat item) {
        return item;
    }

}
