package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyForYear(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(2, foundWhisky.size());
		assertEquals("The Glendronach Revival", foundWhisky.get(0).getName());
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> foundDistilley = distilleryRepository.findDistilleryByRegion("Speyside");
		assertEquals(2, foundDistilley.size());
		assertEquals("Macallan", foundDistilley.get(0).getName());
	}

	@Test
	public void canFindWhiskyByDistilleryAndAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByDistilleryAndAge("Rosebank", 12);
		assertEquals(1, foundWhiskies.size());
		assertEquals("The Rosebank 12", foundWhiskies.get(0).getName());
	}

}