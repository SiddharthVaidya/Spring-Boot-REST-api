package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student siddharth =  new Student(
                    "Siddharth",
                    "sid@gmail.com",
                    LocalDate.of(1999, Month.MAY, 26),
                    23L
            );
            Student samarth = new Student(
                    "Samarth," ,
                    "samarth@gmail.com",
                    LocalDate.of(2003, Month.DECEMBER, 12),
                    19L
            );
          repository.saveAll(List.of(siddharth, samarth));
        };
    }
}
