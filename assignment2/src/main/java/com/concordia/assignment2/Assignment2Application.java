package com.concordia.assignment2;

import com.concordia.assignment2.Services.DataLoader;
import com.concordia.assignment2.model.EduCostStat;
import com.concordia.assignment2.repository.EduCostStatRepository;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

@EnableMongoRepositories("com.concordia.assignment2.repository")
//@ComponentScan("com.concordia.assignment2.*")
@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public  class Assignment2Application implements CommandLineRunner{



	 EduCostStatRepository eduCostStatRepository ;

	@Autowired
	public Assignment2Application(EduCostStatRepository eduCostStatRepository) {
		this.eduCostStatRepository = eduCostStatRepository;
	}


	public static void  main(String[] args) throws IOException, CsvException {



		SpringApplication.run(Assignment2Application.class, args);




//		System.out.println(eduCostStatRepository.findbytype("private"));


	}

	@Override
	public void run(String... args) throws Exception {

		for (EduCostStat eduCostStat : eduCostStatRepository.findAll())
		{
			System.out.println(eduCostStat);
		}

	}

//	@Override
//	public void run(String... args) throws Exception {
//		DataLoader dl = new DataLoader(this.eduCostStatRepository);
//		dl.fetchall();
//
//	}


//	@Override
//	public void run(String... args) throws Exception {
//
//
//
//
//	}
}
