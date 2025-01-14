package com.springboot.jdbc.spring_demo;

import com.springboot.jdbc.spring_demo.model.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@AutoConfiguration
@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);

		Car car1 = context.getBean(Car.class);

		car1.getYear();
		car1.getModel();
		car1.getColor();

		CarRepo repo = context.getBean(CarRepo.class);
		repo.save(car1);

		System.out.println(repo.findAll());

	}

}
