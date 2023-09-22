package com.springbootdemo.demo.student;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class studentConfig { 

    @Bean
    CommandLineRunner clr( studentRepository repo){
        return args ->{
             student anna = new student(
                    
                     "Anna",
                     LocalDate.of(2000, Month.APRIL, 15),
                    "anna@"
                   
            );
            student alex = new student(
                     "Alex",
                     LocalDate.of(2000, Month.APRIL, 15),
                    "alex@"
                 
            );
            repo.saveAll(
                    List.of(anna, alex )
                );
        };

    }
}