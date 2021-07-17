package com.spring.annotations.beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.FortuneService;

@Component
public class FileFortuneService implements FortuneService {
	
	private String filePath = "C:/Users/PC/git/repository/spring-annotations-demo/src/fortuneFile.txt";
	private List<String> fortuneList;
	
	private Random random = new Random();
	
	public FileFortuneService() {
		System.out.println("Constructing FileFortuneService Instance");
	}
	
	@PostConstruct
	protected void doPostInitialization() {
		File fortuneFile = new File(filePath);
		fortuneList = new ArrayList<>();
		
		if (fortuneFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(fortuneFile))) {
				String tempLine;
				
				while((tempLine = reader.readLine())!=null) {
					fortuneList.add(tempLine);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("Fortunes loaded in File Fortune Service Instance");
		} else {
			System.out.println("No such Fortune File found");
		}
	}
	
	@Override
	public String getFortune() {
		return fortuneList.get(random.nextInt(fortuneList.size()));
	}
	
}
