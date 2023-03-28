package com.concordia.assignment2.Services;

import com.concordia.assignment2.model.EduCostStat;
import com.concordia.assignment2.repository.EduCostStatRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoader {
    @Autowired
    private final EduCostStatRepository eduCostStatRepository;

    public DataLoader(EduCostStatRepository eduCostStatRepository) {

        this.eduCostStatRepository = eduCostStatRepository;
    }



//    public List<EduCostStat> getAllUsers() {
//        return this.eduCostStatRepository.findAll();
//    }




//    EduCostStatRepository eduCostStatRepository;

//
//    public DataLoader(EduCostStatRepository eduCostStatRepository) {
//        this.eduCostStatRepository = eduCostStatRepository;
//    }



//    public void  fetchall()
//    {
//        List<EduCostStat> x = this.eduCostStatRepository.findAll();
//        System.out.println(x);
//    }

    public void loadData() throws IOException, CsvException {
        Reader reader = new FileReader("C:\\Users\\rajki\\Downloads\\Stats.csv");
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        List<String[]> rows = ((CSVReader) csvReader).readAll();
        List<EduCostStat> eduCostStats = new ArrayList<>();
        for (String[] row : rows) {
            EduCostStat eduCostStat = new EduCostStat();
            eduCostStat.setYear(row[0]);
            eduCostStat.setType(row[1]);
            eduCostStat.setState(row[2]);
            eduCostStat.setLength(row[3]);
            eduCostStat.setExpense(row[4]);
            eduCostStat.setValue(row[5]);



            this.eduCostStatRepository.save(eduCostStat);
        }
        System.out.println("terminated");

    }

//    public List<EduCostStat> fetchall() {
//
//        List<EduCostStat> x = this.eduCostStatRepository.findAll();
//        System.out.println(x);
//        return x;
//    }
}

